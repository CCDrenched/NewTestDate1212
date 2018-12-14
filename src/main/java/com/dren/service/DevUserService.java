package com.dren.service;

import com.dren.pojo.DevUser;

public interface DevUserService {
	/**
	 * 根据用户名查询用户对象
	 * @param DevName
	 * @return
	 */
	public DevUser findDevUserByDevName(String DevName);
}
