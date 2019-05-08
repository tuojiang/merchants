package com.chandler.passbook.dao;

import com.chandler.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: ${todo}
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {
    /**
     * 根据id获取商户对象
     * @param id　商户id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据名称获取商户对象
     * @param name　商户名称
     * @return {@link Merchants}
      */
    Merchants findByName(String name);
}
