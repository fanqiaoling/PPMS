package ppms.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ppms.action.interfaces.BaseInit;
import ppms.action.interfaces.InitPage;
import ppms.daoimpl.BaseDaoImp;
import ppms.domain.OrganizationNj;
import ppms.domain.TbEmployee;
import ppms.domain.TbJob;
import ppms.domain.TbPost;
import ppms.domain.TbRole;
import ppms.serviceimpl.userBaseInfoServiceImp;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 人员基本信息单条录入类
 */

public class userBaseInfoAction extends BaseInit{
	/**
	 * 构建对象
	 */
	private TbEmployee tbEmployee;
	

	public TbEmployee getTbEmployee() {
		return tbEmployee;
	}

	public void setTbEmployee(TbEmployee tbEmployee) {
		this.tbEmployee = tbEmployee;
	}
	
	/**
	 *声明request 
	 */
	protected HttpServletRequest request;

	public userBaseInfoAction() {

		request = ServletActionContext.getRequest();

	}
	@Autowired
	private userBaseInfoServiceImp service;
	
	/**
	 * 声明，调用API
	 */
	@Autowired
	@Qualifier("baseDaoImp")
	private BaseDaoImp dao;

	public userBaseInfoServiceImp getService() {
		return service;
	}

	public void setService(userBaseInfoServiceImp service) {
		this.service = service;
	}

	/**
	 * 人员基本信息录入
	 * @return
	 */
	@Action(value = "userInfo.userBase.userBaseInfoSingle.result", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoSingleResult.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String result() {
		try {
		service.adduserBaseInfo(tbEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 转至录入页面
	 * @return
	 */
	@Action(value = "userInfo.userBase.userBaseInfoSingle.resultBackSingle", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoSingle.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String resultBack() {
		
		return "success";
	}

	/**
	 * 转至查询页面
	 * @return
	 */
	@Action(value = "userInfo.userBase.userBaseInfoSearch.resultBackSearch", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoSearch.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String resultBackSearch() {
		return "success";
	}
	
	/**
	 * 详细查询人员信息
	 * @return
	 */
	@Action(value = "userInfo.userBase.userBaseInfoSearch.Detail", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoDetail.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String Detail() {
		String employeeid=request.getParameter("id");
		List<TbEmployee> tbEmployees=service.getTbEmployees(employeeid);
		request.setAttribute("tbEmpl", tbEmployees);
		return "success";
	}
	
	/**
	 * 实现人员信息查询页面初始化
	 * @return
	 */
	@Action(value = "userInfo.userBase.userBaseInfoSingle", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoSingle.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public  String firstIn(){
		
		initPage("userInfo.userBaseInfoSingle");
		toCache();
		return "success";
		
	}
	
	@Action(value = "userInfo.userBase.userBaseInfoSearch", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/userInfo/userBaseInfoSearch.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String search(){
		
		initPage("userInfo.userBaseInfoSearch");
		toCache();
		return "success";
	}
	private void  initPage(String url) {
		
		try {
			// 获取所有营业厅
			switch (url) {
			case "userInfo.userBaseInfoSingle":
				
				
				List<OrganizationNj> organizations = service.getOrganizations();
				List<TbPost> tbPosts = service.getTbPosts();			
				List<TbJob> tbJobs =service.getTbJobs();
				List<TbEmployee> tbEmployees =service.getTbEmployee();
				List<TbRole> tbRoles =service.getTbRoles();
				map.put("roles", tbRoles);
				map.put("orgs", organizations);
				map.put("posts", tbPosts);
				map.put("jobs", tbJobs);
				map.put("employees", tbEmployees);
				break;
			case "userInfo.userBaseInfoSearch":
				
				List<TbEmployee> employees=dao.getEntitiestNotLazy(new TbEmployee(), new String[]{"organizationNj","tbJob","tbRole","tbPost"});
				map.put("employees", employees);
			default:
				break;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 实例化map
	}

}
