package com.dren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dren.dao.BackendUserDAO;
import com.dren.pojo.BackendUser;
import com.dren.service.BackendUserService;
@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Autowired
	private BackendUserDAO backendDAO;
	@Override
	public BackendUser findUserByName(String name) {
		// TODO Auto-generated method stub
		return backendDAO.findUserByName(name);
	}
	public BackendUserDAO getBackendDAO() {
		return backendDAO;
	}
	public void setBackendDAO(BackendUserDAO backendDAO) {
		this.backendDAO = backendDAO;
	}
	
}
