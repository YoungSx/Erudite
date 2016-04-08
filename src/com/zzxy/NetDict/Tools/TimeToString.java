package com.zzxy.NetDict.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeToString {
    
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
