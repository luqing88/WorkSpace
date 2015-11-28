package org.furuifengyuan.web.biz.dao.impl;

import javax.annotation.Resource;

import org.furuifengyuan.web.biz.dao.UserDao;
import org.furuifengyuan.web.model.UserModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component("userDao")
public class DefaultUserDao implements UserDao {

	private SqlSessionTemplate sqlSessionTemplate;

	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public boolean insert(UserModel userModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int res = sqlSessionTemplate.insert(
				"org.furuifengyuan.web.model.UserModel.insert_user", userModel);
		if (res > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean update(UserModel userModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int res = sqlSessionTemplate.insert(
				"org.furuifengyuan.web.model.UserModel.update_user", userModel);
		if (res > 0) {
			flag = true;
		}
		return flag;
	}

	public UserModel selectName(String name) {
		// TODO Auto-generated method stub
		UserModel user = sqlSessionTemplate.selectOne(
				"org.furuifengyuan.web.model.UserModel.select_user_name", name);
		return user;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int res = sqlSessionTemplate.delete(
				"org.furuifengyuan.web.model.UserModel.delete_user", id);
		if (res > 0) {
			flag = true;
		}
		return flag;
	}

}
