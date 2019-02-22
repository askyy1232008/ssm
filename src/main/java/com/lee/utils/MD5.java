package com.lee.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMd5(String plainText) {  
          try {  
             MessageDigest md = MessageDigest.getInstance("MD5");  
             md.update(plainText.getBytes());  
             byte b[] = md.digest();  

             int i;  

             StringBuffer buf = new StringBuffer("");  
             for (int offset = 0; offset < b.length; offset++) {  
                 i = b[offset];  
                 if (i < 0)  
                     i += 256;  
                 if (i < 16)  
                     buf.append("0");  
                 buf.append(Integer.toHexString(i));  
         }  
             //32位加密  
             return buf.toString();  
         } catch (NoSuchAlgorithmException e) {  
             e.printStackTrace();  
             return null;  
         }  

     }  
      
      public static void main(String[] args) {
//        String mm = "userId=100&secret=yaosi001&tel=18600000000&key=yaosi";
        String ff = "id=1&token=token&timestamp=123";
        
        /*
         * 转换成小写后MD5加密
         */
        System.out.println(getMd5(ff.toLowerCase()));
      }
}
