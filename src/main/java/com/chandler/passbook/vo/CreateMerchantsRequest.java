package com.chandler.passbook.vo;

import com.chandler.passbook.constant.ErrorCode;
import com.chandler.passbook.dao.MerchantsDao;
import com.chandler.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 19-5-8
 * @version： V1.0
 * @Author: Chandler
 * @Description: 创建商户请求对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    /** 商户名称 */
    private String name;

    /** 商户 logo */
    private String logoUrl;

    /** 商户营业执照 */
    private String businessLicenseUrl;

    /** 商户联系电话 */
    private String phone;

    /** 商户地址 */
    private String address;

    /**
     * 验证请求的有效性
     * @param merchantsDao　{@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){

        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }
        if (null ==this.logoUrl) {
            return ErrorCode.EMPTY_LOGO;
        }
        if (null ==this.businessLicenseUrl) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if (null == this.phone) {
            return ErrorCode.EMPTY_PHONE;
        }
        if (null == this.address) {
            return ErrorCode.EMPTY_ADDRESS;
        }
        return ErrorCode.SUCCESS;
    }

    /**
     * 将请求对象转换为商户对象
     * @return {@link Merchants}
     */
    public Merchants toMerchants(){

        Merchants merchants = new Merchants();

        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }

}
