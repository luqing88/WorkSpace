package org.furuifengyuan.web.test;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.furuifengyuan.web.biz.dao.UserDao;
import org.furuifengyuan.web.model.UserModel;
import org.junit.Test;

public class UserDaoTest extends BaseTest {
	@Resource
	private UserDao userDao;

	public void testInsert() {
		UserModel userModel = new UserModel();
		userModel.setName("admin");
		userModel.setPassword("123456");
		userModel.setRole("admin");
		userModel.setSex("man");
		userModel.setAge(30);
		userModel.setCreateDate(new Date());
		userModel.setStatus(1);

		boolean result = userDao.insert(userModel);
		Assert.assertEquals(true, result);
	}

	public void testUpdate() {
		String name = "lcl";
		UserModel user = userDao.selectName(name);
		Assert.assertNotNull(user);
		user.setModifyDate(new Date());
		user.setDescription("test");
		user.setPhone("15622360678");
		boolean restult = userDao.update(user);
		Assert.assertEquals(true, restult);
	}

//	@Test
	public void testDelete() {
		long id = 1;
		boolean result = userDao.delete(id);
		Assert.assertEquals(true, result);
	}
    @Test
	public void testSelectName() {
		String name = "admin";
		UserModel user = userDao.selectName(name);
		Assert.assertNotNull(user);
	}
}
