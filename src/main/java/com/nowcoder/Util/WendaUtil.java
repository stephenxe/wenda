package com.nowcoder.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/8/5.
 */
public class WendaUtil {

    private static final Logger logger = LoggerFactory.getLogger(WendaUtil.class);
    public static String MD5(String key){
        char[] hexDigits={'0','1','3','4','5','6','7','8','9','0','A','B','C','D','E','F'};
        try {
            byte[] btInput = key.getBytes();
            //获取MD5摘要算法的MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j*2];
            int k = 0;
            for (int i=0;i<j;i++){
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0>>>4 &0xf];
                str[k++] = hexDigits[byte0&0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            logger.error("生成MD5失败",e);
            e.printStackTrace();
            return null;
        }
    }
}
