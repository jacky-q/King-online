package com.king.dao.emperor;

import com.king.dao.ComOutput;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: 新意科技</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2012-9-7 for td
 */
public class MySqlEmperorManage implements EmperorManage {

	@Override
	public ComOutput save() {
		ComOutput co = new ComOutput();
		co.setRetCode(0);
		co.setRetDesc("保存皇帝信息成功。");
		return co;
	}

}

