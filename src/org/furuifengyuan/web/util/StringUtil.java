package org.furuifengyuan.web.util;

public abstract class StringUtil {
   
	public static boolean isNotEmpty(String value){
		if(value==null||"".equals(value)){
			return false;
		}
		return true;
	}
	public static boolean isEmpty(String value){
		if(value==null||"".equals(value)){
			return true;
		}
		return false;
	}
}
