package com.chandler.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.chandler.passbook.constant.Constants;
import com.chandler.passbook.constant.ErrorCode;
import com.chandler.passbook.dao.MerchantsDao;
import com.chandler.passbook.entity.Merchants;
import com.chandler.passbook.service.IMerchantsServ;
import com.chandler.passbook.vo.CreateMerchantsRequest;
import com.chandler.passbook.vo.CreateMerchantsResponse;
import com.chandler.passbook.vo.PassTemplate;
import com.chandler.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 19-5-8
 * @version： V1.0
 * @Author: Chandler
 * @Description: 商户服务接口实现
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {

    /** Merchants数据库接口 */
    private final MerchantsDao merchantsDao;

    /** kafka　客户端 */
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao,
                             KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorDesc(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);

        if (null == merchants) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorDesc(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate passTemplate) {

        Response response = new Response();
        ErrorCode errorCode = passTemplate.validate(merchantsDao);

        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorDesc(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        } else {
            String template = JSON.toJSONString(passTemplate);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    template
            );
            log.info("DropPassTemplates: {}",template);
        }

        return response;
    }
}
