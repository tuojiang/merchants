package com.chandler.passbook.constant;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: 颜色码枚举定义
 */
public enum TemplateColor {

    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色");

    /** 颜色代码 */
    private Integer code;

    /** 颜色描述 */
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }
}
