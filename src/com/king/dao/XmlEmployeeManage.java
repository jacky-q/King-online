/**
 * 
 */
package com.king.dao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jdom.input.SAXBuilder;

import net.jackyq.employee.employee.Employee;
/**
 * XmlEmployeeManage
 * <pre>
 * 功能说明：
 * 修改记录：
 * 修改日期    修改人   修改原因   版本
 * 2012-8-13   Jacky-Q  新建        1.0
 * </pre> 
 */
public class XmlEmployeeManage implements EmployeeManage {
//	private Logger logger = Logger.getLogger(XmlEmployeeManage.class);
	final String DB_FILE_PATH = "/net/jackyq/employee/db/employee.xml";
	@Override
	public Employee getEmployee(String empNo){
		
		return this.xmlToEmployee(empNo);
	}
	@Override
	public String addEmployee(Employee emp){
		this.employeeToXml(emp,1);
		logger.debug("新增职员信息成功");
		return "操作成功";
	}
	
	@Override
	public List getAllEmployee(){
		SAXReader reader = new SAXReader();
		
		Document doc;
		List result = null;
		try {
			String staticPath = "C:\\workspace\\Employee\\src\\net\\jackyq\\employee\\db\\employee.xml";
			File f1 = new File(staticPath);
			doc = reader.read(new File(staticPath));
//			doc.setXMLEncoding("UTF-8");
			List list = doc.selectNodes("//employees/employee");
			result = new ArrayList();
			for (Iterator it = list.iterator(); it.hasNext();) {
				Node node = (Node) it.next();
				result.add(new Employee(node));
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		this.employeeToXml(emp,2);
		logger.debug("修改职员信息成功");
		return "操作成功";
	}

	@Override
	public String delEmployee(Employee emp) {
		this.employeeToXml(emp,3);
		logger.debug("删除职员信息成功");
		
		return "操作成功";
	}	
	public void employeeToXml(Employee emp,int op){
		SAXReader reader = new SAXReader();
		try {
			String staticPath = "C:\\workspace\\Employee\\src\\net\\jackyq\\employee\\db\\employee.xml";
			Document doc = reader.read(new File(staticPath));
//			doc.setXMLEncoding("UTF-8");
			logger.debug(doc.asXML());
			List list = doc.selectNodes("//employees/employee/empNo");
			//更新
			if( 2 == op){
				//节点存在则替换
				for (Iterator it = list.iterator(); it.hasNext();) {
					Node node = (Node) it.next();
					String empNo = emp.getEmpNo();
					logger.debug("node.value="+node.getStringValue());
					if(empNo.equals(node.getStringValue())){
						Node target = node.getParent();
						setNodeValue(target,"name",emp.getName());
						setNodeValue(target,"age",emp.getAge());
						setNodeValue(target,"sex",emp.getSex());
						setNodeValue(target,"mobile",emp.getMobile());
						setNodeValue(target,"birthday",emp.getBirthday());
						setNodeValue(target,"address",emp.getAddress());
						setNodeValue(target,"staffDate",emp.getStaffDate());
						setNodeValue(target,"description",emp.getDescription());
						break;
						//
					}
				}
				
			//不存在，插入节点
			}else if (1 == op){
				//根据最后的empNo值再递增
				Node oldNo = (Node)list.get(list.size()-1);
				String newNo = String.valueOf(Integer.parseInt(oldNo.getStringValue()) + 1);
//				setNodeValue(target,"empNo",newNo);
//				setNodeValue(target,"name",emp.getName());
//				setNodeValue(target,"age",emp.getAge());
//				setNodeValue(target,"sex",emp.getSex());
//				setNodeValue(target,"mobile",emp.getMobile());
//				setNodeValue(target,"birthday",emp.getBirthday());
//				setNodeValue(target,"address",emp.getAddress());
//				setNodeValue(target,"staffDate",emp.getStaffDate());
//				setNodeValue(target,"description",emp.getDescription());
				Element rootElement = (Element) doc.selectSingleNode("//employees");
//				rootElement.clearContent();
				Element el = rootElement.addElement("employee");
				el.addElement("empNo").addText(newNo);
				el.addElement("name").addText(trimNull(emp.getName()));
				el.addElement("age").addText(trimNull(emp.getAge()));
				el.addElement("sex").addText(trimNull(emp.getSex()));
				el.addElement("mobile").addText(trimNull(emp.getMobile()));
				el.addElement("birthday").addText(trimNull(emp.getBirthday()));
				el.addElement("address").addText(trimNull(emp.getAddress()));
				el.addElement("staffDate").addText(trimNull(emp.getStaffDate()));
				el.addElement("description").addText(trimNull(emp.getDescription()));
//				el.setParent((Element) doc.selectSingleNode("//Employees"));
			}else if(3 == op){
				for (Iterator it = list.iterator(); it.hasNext();) {
					Node node = (Node) it.next();
					String empNo = emp.getEmpNo();
					if(empNo.equals(node.getStringValue())){
						logger.debug("node.value="+node.getStringValue());
						node.getParent().detach();
						break;
					}
				}
			}
			
//			File tFile = new File(this.getClass().getResource(DB_FILE_PATH).getFile());
			 OutputFormat outformat = OutputFormat.createPrettyPrint();
//			 System.out.println("of = " + outformat.getEncoding());
//			 outformat.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(
//					new OutputStreamWriter(new FileOutputStream(tFile))
					new FileOutputStream(staticPath)
					
					,outformat);
//			        writer.write(  );
			
			logger.debug(doc.asXML());
//			writer.set
			writer.write(doc);
//			writer.flush();
			writer.close();
			return;
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void setNodeValue(Node target, String name, String val) {
//		if(StringUtils.isNotEmpty(val)){
//			target.selectSingleNode("name").setText(val);
//		}else{
//			target.selectSingleNode("name").setText("");
//		}
//		String s;
//		try {
////			s = new String(trimNull(val).getBytes("ISO-8859-1"),"UTF-8");
//			target.selectSingleNode(name).setText(s);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		target.selectSingleNode(name).setText(trimNull(val));
	}
	private String trimNull(String val){
		if(val == null){
			return "";
		}
		return val;
	}
	public Employee xmlToEmployee(String empNo){
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(this.getClass().getResource(DB_FILE_PATH));
//			logger.debug(doc.asXML());
			List list = doc.selectNodes("//employees/employee/empNo");
			for (Iterator it = list.iterator(); it.hasNext();) {
				Node node = (Node) it.next();
				if(empNo.equals(node.getStringValue())){
					Node target = node.getParent();
					Employee emp = new Employee(target);
					return emp;
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}



}

