package com.example.prmgs.utils.enums;

/**
 * Enum for Gender
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
public enum Gender {

    MALE(1, "Male"), FEMALE(2, "Female");

    private Integer code;
    private String text;

    Gender(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
