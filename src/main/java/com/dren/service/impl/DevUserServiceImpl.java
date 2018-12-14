package com.dren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dren.dao.DevUserDAO;
import com.dren.pojo.DevUser;
import com.dren.service.DevUserService;
@Service
public class DevUserServiceImpl implements DevUserService{
	@Autowired
	private DevUserDAO devUserDAO;
	
	public void setDevUserDAO(DevUserDAO devUserDAO) {
		this.devUserDAO = devUserDAO;
	}

	@Override
	public DevUser findDevUserByDevName(String DevName) {
		// TODO Auto-generated method stub
		return devUserDAO.findDevUserByDevName(DevName);
	}
	
}
