package com.example.demo.en;

/**
 * ClassName: OrderStatusEnum
 * Package: com.example.demo.enum
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public enum OrderStatusEnum2 {
    START("1","创建中"),
    SUCCESS("2","成功"),
    FAIL("3","失败")
    ;

    private final String code;
    private final String message;

    OrderStatusEnum2(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public static OrderStatusEnum2 getByCode(String code) {
        for (OrderStatusEnum2 value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }

        return null;
    }

}
