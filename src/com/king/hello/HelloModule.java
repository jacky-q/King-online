package com.king.hello;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Modules;

/**
 *
 * <p>Title: </p>
 * <p>Description: ��ģ�飬��Ӧ������ں���@At</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2011-1-28 for td
 */

@Modules(scanPackage = true)
public class HelloModule {

	@Fail("jsp:/hello")
	public String doFail(){
		return "Where r u?";
	}
}

