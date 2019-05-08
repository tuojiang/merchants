package com.chandler.passbook.service;

import com.alibaba.fastjson.JSON;
import com.chandler.passbook.vo.CreateMerchantsRequest;
import com.chandler.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Date;

/**
 * @Date: 19-5-8
 * @version： V1.0
 * @Author: Chandler
 * @Description: ${todo}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ iMerchantsServ;

    /**
     * {"data":{"id":17},"errorCode":0,"errorDesc":""}
     * {"data":{"id":18},"errorCode":0,"errorDesc":""}
     */
    @Test
    public void testCreateMerchantServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("Chandler-1");
        request.setLogoUrl("www.chandler.com");
        request.setBusinessLicenseUrl("www.chandler.com");
        request.setPhone("13574389593");
        request.setAddress("深圳市");


        System.out.println(JSON.toJSONString(iMerchantsServ.createMerchants(request)));
    }

    /**
     * {
     *  "data":{"address":"深圳市",
     *          "businessLicenseUrl":"www.chandler.com",
     *          "id":17,
     *          "isAudit":false,
     *          "logoUrl":"www.chandler.com",
     *          "name":"Chandler",
     *          "phone":"13574389593"},
     *          "errorCode":0,
     *          "errorDesc":""
     *  }
     */
    @Test
    public void testBuildMerchantsInfoById(){
        System.out.println(JSON.toJSONString(iMerchantsServ.buildMerchantsInfoById(17)));
    }

    /**
     * {"errorCode":0,"errorDesc":""}
     * {
     *    "backgroud": 2,
     *    "desc": "详情：Chandler的网盘",
     *    "end": 1558157181332,
     *    "hasToken": false,
     *    "id": 17,
     *    "limit": 1000,
     *    "start": 1556429181331,
     *    "summary": "简介：Chandler",
     *    "title": "Chandler - 1"
     * }
     */
    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(17);
        passTemplate.setTitle("Chandler - 2");
        passTemplate.setSummary("简介：Chandler");
        passTemplate.setDesc("详情：Chandler的网盘");
        passTemplate.setBackgroud(2);
        passTemplate.setHasToken(false);
        passTemplate.setLimit(1000L);
        passTemplate.setStart(DateUtils.addDays(new Date(),-10));
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));

        System.out.println(JSON.toJSONString(iMerchantsServ.dropPassTemplate(passTemplate)));
    }
}
