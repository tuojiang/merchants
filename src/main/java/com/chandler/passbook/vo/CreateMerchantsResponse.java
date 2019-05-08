package com.chandler.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 19-5-8
 * @version： V1.0
 * @Author: Chandler
 * @Description: 创建商户响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id:创建失败则为 -1 */
    private Integer id;
}
