package org.furuifengyuan.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public abstract class MD5Utils {
	 private static Logger log=LoggerFactory.getLogger(MD5Utils.class);
	  public static String getMd5(String plainText) { 
		   String result=null;
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
	            result= buf.toString();  
  
	        } catch (NoSuchAlgorithmException e) {  
	        	e.printStackTrace();
	        	log.error("Md5加密出错",e.getMessage());
	        }  
	       return result;
	    }   
}
