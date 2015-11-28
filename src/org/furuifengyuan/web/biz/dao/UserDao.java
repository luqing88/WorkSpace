package org.furuifengyuan.web.biz.dao;

import org.furuifengyuan.web.model.UserModel;


public interface UserDao {
	public boolean insert(UserModel userModel);

	public boolean update(UserModel userModel);
	
	public Boolean delete(Long id);

	public UserModel selectName(String name);
}
