package com.dao.daoImpl;

import com.dao.AdminLoginDao;

public class AdminLoginImplementation implements AdminLoginDao {

	@Override
	public int loginValidate(String username, String password) {
		if(username=="admin" || username=="Admin" && password=="@Pass1234")
		{
			return 1;
		}
		return 0;
	}

}
