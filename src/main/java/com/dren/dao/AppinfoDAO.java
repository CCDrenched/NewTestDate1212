package com.dren.dao;

import java.util.List;

import com.dren.pojo.AppCategory;
import com.dren.pojo.Appinfo;
import com.dren.pojo.AppinfoPage;
import com.dren.pojo.DataDictionary;

public interface AppinfoDAO {
	/**
	 * 有条件地查询应用信息列表
	 * @param appinfoPage
	 * @return
	 */
	List<Appinfo> findAppinfoList(AppinfoPage appinfoPage);
	/**
	 * 有条件地查询应用数量
	 * @param appinfoPage
	 * @return
	 */
	int findAppinfoCount(AppinfoPage appinfoPage);
	/**
	 * 根据指定的字典类型获取字典数据
	 * @param dictType
	 * @return
	 */
	List<DataDictionary> findDataDic(String dictType);
	/**
	 * 根据上下级id获取对应的下级菜单
	 * @param pid
	 * @return
	 */
	List<AppCategory> findAppCateByPid(int pid);
}
