package com.king.hello;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.king.dao.ComOutput;
import com.king.bean.Emperor;
import com.king.dao.ComDao;

/**
 *
 * <p>Title: </p>
 * <p>Description: demo子模块，放置想法</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: 新意科技</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2012-8-23 for td
 */
@At("/demo")
public class DemoModule {
	
	@At("/enlist")
	@Ok("->:/demo/enlist.html")
	public String enlist(){
			return null;
	}
	
	@At("/king profile")
	@Ok("jsp:/demo/kingprofile")
	public String kingprofile(){
		Emperor em = new Emperor();
		em.setName("电灯泡");
		return Json.toJson(em,JsonFormat.full());
	}
	@At("/save")
	@Ok("json")
	public ComOutput save(){
		ComOutput co = ComDao.save(); 
		return co;
	}
}

