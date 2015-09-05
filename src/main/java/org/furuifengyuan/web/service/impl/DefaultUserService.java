package org.furuifengyuan.web.service.impl;

import javax.annotation.Resource;

import org.furuifengyuan.web.biz.dao.UserDao;
import org.furuifengyuan.web.enums.ErrorCode;
import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.service.UserService;
import org.furuifengyuan.web.vo.Result;
import org.springframework.stereotype.Service;
@Service("userService")
public class DefaultUserService implements UserService {
    
	@Resource
	private UserDao userDao;

	public Result<Boolean> addUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Result<Boolean>result=new Result<Boolean>();
		 if(userModel!=null){
			 try {
				boolean tag=userDao.insert(userModel);
			    if(tag){
			    	result.setSuccess(true);
			        result.setModule(true);
			    }
			    else {
					result.setSuccess(false);
					result.setMessage("用户数据插入失败");
					result.setCode(ErrorCode.FAIL_ERROR.getValue());
				}
			 } catch (Exception e) {
				// TODO: handle exception
				result.setSuccess(false);
				result.setMessage("用户数据插入异常");
				result.setCode(ErrorCode.EXCEPTION_ERROR.getValue());
			}
		 }
		 else {
			result.setMessage("数据为空");
			result.setSuccess(false);
			result.setCode(ErrorCode.NULL_ERROR.getValue());
		}
		return result;
	}

	public Result<Boolean> modifyUser(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Boolean> isLogin(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
