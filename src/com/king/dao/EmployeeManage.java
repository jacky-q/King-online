/**
 * 
 */
package com.king.dao;

import java.util.List;

import org.dom4j.DocumentException;

import com.king.bean.ComOutput;

//import net.jackyq.employee.employee.Employee;

/**
 * EmployeeManage
 * <pre>
 * 功能说明：
 * 修改记录：
 * 修改日期    修改人   修改原因   版本
 * 2012-8-13   Jacky-Q  新建        1.0
 * </pre> 
 */
public interface EmployeeManage {
//	Employee getEmployee(String empNo);
//	String	addEmployee(Employee emp);
//	String updateEmployee(Employee emp);
//	String	delEmployee(Employee emp);
//	List	getAllEmployee() throws DocumentException;
	
	ComOutput	getObjectListById();
	ComOutput  getObject();
	ComOutput addObject();
	ComOutput updateObject();
	ComOutput deleteObject();
}

