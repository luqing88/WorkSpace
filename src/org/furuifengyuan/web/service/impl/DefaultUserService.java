package org.furuifengyuan.web.service.impl;

import javax.annotation.Resource;


import org.apache.commons.lang.StringUtils;
import org.furuifengyuan.web.biz.dao.UserDao;
import org.furuifengyuan.web.enums.ErrorCode;
import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.service.UserService;
import org.furuifengyuan.web.util.MD5Utils;
import org.furuifengyuan.web.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService {
	private Logger log = LoggerFactory.getLogger(DefaultUserService.class);
	@Resource
	private UserDao userDao;

	public Result<Void> addUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Result<Void> result = new Result<Void>();
		if (userModel != null) {
			try {
				String password = userModel.getName() + "#"
						+ userModel.getPassword();
				password = MD5Utils.getMd5(password);
				if (StringUtils.isBlank(password)) {
					log.error(userModel.getName() + ":用户数据加密失败");
					result.setMessage("用户数据插入失败");
					return result;
				}
				userModel.setPassword(password);
				boolean tag = userDao.insert(userModel);
				if (tag) {
					result.setSuccess(true);
				} else {
					result.setSuccess(false);
					result.setMessage("用户数据插入失败");
					result.setCode(ErrorCode.FAIL_ERROR.getValue());
					log.error("用户数据插入失败");
				}
			} catch (Exception e) {
				// TODO: handle exception
				result.setSuccess(false);
				result.setMessage("用户数据插入异常");
				result.setCode(ErrorCode.EXCEPTION_ERROR.getValue());
				log.error("用户数据插入异常", e.getMessage());
			}
		} else {
			result.setMessage("数据为空");
			result.setSuccess(false);
			result.setCode(ErrorCode.NULL_ERROR.getValue());
			log.error("数据为空");
		}
		return result;
	}

	public Result<Void> modifyUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Result<Void> result = new Result<Void>();
		if (userModel != null) {
			try {
				boolean tag = userDao.update(userModel);
				if (tag) {
					result.setSuccess(true);
				} else {
					result.setSuccess(false);
					result.setMessage("用户数据更新失败");
					result.setCode(ErrorCode.FAIL_ERROR.getValue());
					log.error("用户数据更新失败");
				}
			} catch (Exception e) {
				// TODO: handle exception
				result.setSuccess(false);
				result.setMessage("用户数据更新异常");
				result.setCode(ErrorCode.EXCEPTION_ERROR.getValue());
				log.error("用户数据更新异常", e.getMessage());
			}
		} else {
			log.error("用户数据为空");
			result.setMessage("用户数据为空");
			result.setSuccess(false);
			result.setCode(ErrorCode.NULL_ERROR.getValue());
		}
		return result;
	}

	public Result<Boolean> isLogin(UserModel userModel) {
		// TODO Auto-generated method stub
		Result<Boolean> result = new Result<Boolean>();

		if (userModel != null) {
			if (StringUtils.isNotBlank(userModel.getName())
					&& StringUtils.isNotBlank(userModel.getPassword())) {
				String password = MD5Utils.getMd5(userModel.getName() + "#"
						+ userModel.getPassword());
				UserModel user = null;
				try {
					user = userDao.selectName(userModel.getName());
				} catch (Exception e) {
					// TODO: handle exception
					result.setModule(false);
					log.error("获取用户数据失败", e.getMessage());

				}

				if (user != null && StringUtils.isNotBlank(user.getPassword())
						&& user.getPassword().equals(password)) {
					result.setModule(true);
					result.setSuccess(true);
				} else {
					log.error("用户登录失败", "用户名：" + userModel.getName());
					result.setMessage("用户登录失败");
					result.setCode(ErrorCode.FAIL_ERROR.getValue());
					result.setModule(false);
				}
			} else {
				result.setMessage("用户名或密码为空");
				result.setModule(false);
				result.setCode(ErrorCode.NULL_ERROR.getValue());
			}
		} else {
			log.error("用户数据为空");
			result.setModule(false);
			result.setMessage("用户数据为空");
			result.setCode(ErrorCode.NULL_ERROR.getValue());
		}
		return result;
	}

}
