package org.furuifengyuan.web.biz.dao;

import org.furuifengyuan.web.model.UserModel;

/**
 * 
 * @author chunlong.lcl
 *
 */
public interface UserDao {
	public boolean insert(UserModel userModel);

	public boolean update(UserModel userModel);

	public UserModel selectName(String name);
}
