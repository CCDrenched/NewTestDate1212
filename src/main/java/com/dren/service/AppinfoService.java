package com.dren.service;

import java.util.List;

import com.dren.pojo.AppCategory;
import com.dren.pojo.Appinfo;
import com.dren.pojo.AppinfoPage;
import com.dren.pojo.DataDictionary;

public interface AppinfoService {
	List<Appinfo> findAppInfoList(AppinfoPage appInfopage);
	int findAppInfoCount(AppinfoPage appInfopage);
	
	List<DataDictionary> findDataDic(String dictType);
	List<AppCategory> findAppCateByPid(int pid);

}
