package com.king.dao;

import com.king.dao.ComOutput;
import com.king.dao.emperor.EmperorManage;
import com.king.dao.emperor.MySqlEmperorManage;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: 新意科技</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2012-9-5 for td
 */
public class ComDao {

	public static ComOutput save() {
		EmperorManage em = new MySqlEmperorManage();
		
		ComOutput co = em.save(); 
		return co;
	}

}

