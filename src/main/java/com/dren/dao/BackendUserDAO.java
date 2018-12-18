package com.dren.dao;

import com.dren.pojo.BackendUser;

public interface BackendUserDAO {
	public BackendUser findUserByName(String name);
}
