package com.xiong.util;

import java.util.UUID;

/**
 * Created by gonghui on 2017/11/24.
 */
public class UUIDUtil {
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

}
