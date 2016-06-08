package com.zzxy.NetDict.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {
    /**
     * 求一个字符串的md5值
     * @param target 字符串
     * @return md5 value
     */
    public static String MD5(String target) {
        return DigestUtils.md5Hex(target);
    }
    
    
    
    /**
     * @return 当前系统时间的字符串
     */
    public static String getNowToString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        
        String dateNow = dateFormat.format(new Date());
        
        return dateNow;
    }
    
    
}
