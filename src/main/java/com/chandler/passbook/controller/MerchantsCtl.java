package com.chandler.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.chandler.passbook.service.IMerchantsServ;
import com.chandler.passbook.vo.CreateMerchantsRequest;
import com.chandler.passbook.vo.PassTemplate;
import com.chandler.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Date: 19-5-8
 * @version： V1.0
 * @Author: Chandler
 * @Description: 商户服务
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {

    /** 商户服务接口 */
    private IMerchantsServ iMerchantsServ;

    @Autowired
    public MerchantsCtl(IMerchantsServ iMerchantsServ) {
        this.iMerchantsServ = iMerchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return iMerchantsServ.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("buildMerchantsInfo: {}",id);
        return iMerchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("dropPassTemplate: {}",passTemplate);
        return iMerchantsServ.dropPassTemplate(passTemplate);
    }

}
