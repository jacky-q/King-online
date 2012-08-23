package com.king.hello;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: 新意科技</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2011-10-10 for td
 */
public class MainModule {
	@At("/main")
	@Ok("jsp:/main")
	public String doMain(){
		return "faint1";
	}
}

