package com.example.demo.tools;

/**
 * ClassName: StringUtils
 * Package: com.example.demo.tools
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class StringUtils{
    public static boolean isEmpty(String str){
        return null == str || "".equals(str);
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    public static String trim(String str){
        return null == str ? null : str.trim();
    }
}
