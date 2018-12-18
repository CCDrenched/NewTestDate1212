package com.dren.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dren.dao.AppinfoDAO;
import com.dren.pojo.AppCategory;
import com.dren.pojo.Appinfo;
import com.dren.pojo.AppinfoPage;
import com.dren.pojo.DataDictionary;
import com.dren.service.AppinfoService;
@Service
public class AppinfoServiceImpl implements AppinfoService {
	@Autowired
	private AppinfoDAO appinfoDAO;
	@Override
	public List<Appinfo> findAppInfoList(AppinfoPage appInfopage) {
		// TODO Auto-generated method stub
		return appinfoDAO.findAppinfoList(appInfopage);
	}

	@Override
	public int findAppInfoCount(AppinfoPage appInfopage) {
		// TODO Auto-generated method stub
		return appinfoDAO.findAppinfoCount(appInfopage);
	}

	@Override
	public List<DataDictionary> findDataDic(String dictType) {
		// TODO Auto-generated method stub
		return appinfoDAO.findDataDic(dictType);
	}

	@Override
	public List<AppCategory> findAppCateByPid(int pid) {
		// TODO Auto-generated method stub
		return appinfoDAO.findAppCateByPid(pid);
	}

	public void setAppinfoDAO(AppinfoDAO appinfoDAO) {
		this.appinfoDAO = appinfoDAO;
	}
	
}
