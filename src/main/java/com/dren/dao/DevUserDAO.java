package com.dren.dao;

import com.dren.pojo.DevUser;

public interface DevUserDAO {
	/**
	 * 根据用户名查询用户对象
	 * @param DevName
	 * @return
	 */
	public DevUser findDevUserByDevName(String DevName);
}
