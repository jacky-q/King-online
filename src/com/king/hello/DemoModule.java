package com.king.hello;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.king.bean.Emperor;

/**
 *
 * <p>Title: </p>
 * <p>Description: demo��ģ�飬�����뷨</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: ����Ƽ�</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2012-8-23 for td
 */
@At("/demo")
public class DemoModule {
	
	@At("/enlist")
	@Ok("jsp:/demo/enlist")
	public String enlist(){
			return null;
	}
	
	@At("/king profile")
	@Ok("jsp:/demo/kingprofile")
	public String kingprofile(){
		Emperor em = new Emperor();
		em.setName("�����");
//		System.o
		return Json.toJson(em,JsonFormat.full());
	}
}
