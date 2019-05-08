package com.chandler.passbook.service;

import com.chandler.passbook.vo.CreateMerchantsRequest;
import com.chandler.passbook.vo.PassTemplate;
import com.chandler.passbook.vo.Response;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: 对商户服务接口定义
 */
public interface IMerchantsServ {

    /**
     * 创建商户服务
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据 id 构建商户信息
     * @param id　商户信息
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * 投放优惠券信息
     * @param passTemplate {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate passTemplate);
}
