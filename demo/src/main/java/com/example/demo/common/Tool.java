package com.example.demo.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tool {
	public static Message dealMessage(String str) throws Exception {
		if(str==null) {
			return null;
		}
		String msg = "";
		ObjectMapper om = new ObjectMapper();
		if(!str.contains("name")) {
		  String[] strArray = str.split(",");
	        byte[] byteArray = new byte[strArray.length];
	        for(int i=0;i<strArray.length;i++) {
	            byteArray[i] = Byte.valueOf(strArray[i]);
	        }
	        msg = new String(byteArray);
		}
		if(str.contains("name")) {
		  msg = str;
		}
		return om.readValue(msg, Message.class);
	}
	/**
	 * 生成uuid
	 * @return
	 */
	public static String GetUUID() {
	  return UUID.randomUUID().toString();
	}
	/**
	 * 判断是否是ajax请求
	 * @param req
	 * @return
	 */
	public static Boolean isAjaxRequest(HttpServletRequest req) {
	  String value = "xmlhttpreqeust";
	  String str = "";
	  if(req!=null) {
	    str = req.getHeader("X-Requested-With");
	    if(str!=null&&value.equalsIgnoreCase(str.trim())) {
	      return true;
	    }
	  }
	  return false;
	}
}
