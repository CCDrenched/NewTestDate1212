package com.dren.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dren.pojo.AppCategory;
import com.dren.pojo.Appinfo;
import com.dren.pojo.AppinfoPage;
import com.dren.pojo.DataDictionary;
import com.dren.pojo.DevUser;
import com.dren.service.AppinfoService;

@Controller
public class AppInfoController {
	@Autowired
	private AppinfoService appinfoService;
	/**
	 * 开发者用户获取应用列表
	 * @return
	 */
	@RequestMapping(value="dev/appList")
	public String devAppList(AppinfoPage appinfoPage,HttpServletRequest request) {
		DevUser user=(DevUser) request.getSession().getAttribute("loginUser");
		//开发者用户固定只查询自己发布的应用
		appinfoPage.setAppCreatedby(user.getDevId());
		List<Appinfo> appList=appinfoService.findAppInfoList(appinfoPage);
		//根据条件获取应用总记录数
		int count=appinfoService.findAppInfoCount(appinfoPage);
		//计算总页数
		int pageCount=(int)Math.ceil(count*1.0/appinfoPage.getRows());
		request.setAttribute("appList",appList);
		request.setAttribute("count",count);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("pageNow",appinfoPage.getPageNow());
		return "dev/appList";
	}
	@RequestMapping(value="backend/appList")
	public String backendAppList(AppinfoPage appinfoPage,HttpServletRequest request) {
		appinfoPage.setAppState(1);//后台管理员固定只查询待审核的应用
		List<Appinfo> appList=appinfoService.findAppInfoList(appinfoPage);
		//根据条件获取应用总记录数
		int count=appinfoService.findAppInfoCount(appinfoPage);
		int pageCount=(int)Math.ceil(count*1.0/appinfoPage.getRows());
		request.setAttribute("appList", appList);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", appinfoPage.getPageNow());
		return "backend/appList";
	}
	
	
	@RequestMapping(value="/appstate")
	@ResponseBody
	public Object findAppState() {
		List<DataDictionary> appStateList=appinfoService.findDataDic("应用状态");
		
		return appStateList;
	} 
	
	@RequestMapping(value="/plateform")
	@ResponseBody
	public Object findPlateform() {
		List<DataDictionary> plateformList=appinfoService.findDataDic("所属平台");
		return plateformList;
	}
	@RequestMapping(value="/appcatelist")
	@ResponseBody
	public Object findAppCate(int pid) {
		List<AppCategory> appCateList=appinfoService.findAppCateByPid(pid);
		return appCateList;
	}
	public void setAppinfoService(AppinfoService appinfoService) {
		this.appinfoService = appinfoService;
	}
	
}
