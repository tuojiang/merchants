package com.chandler.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: 商户对象模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {
    /** 商户 id,主键 */
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;
    /** 商户名称，需要全局唯一 */
    @Basic
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    /** 商户　logo  */
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String logoUrl;
    /** 商户营业执照 */
    @Basic
    @Column(name = "business_license_url",nullable = false)
    private String businessLicenseUrl;
    /** 商户联系电话 */
    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;
    /** 商户地址　*/
    @Basic
    @Column(name = "address",nullable = false)
    private String address;
    /** 是否审核通过 */
    @Basic
    @Column(name = "is_audit",nullable = false)
    private Boolean isAudit = false;
}
