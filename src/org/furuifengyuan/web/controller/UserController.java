package org.furuifengyuan.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.service.UserService;

import org.furuifengyuan.web.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/user")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping(value = { "/login.htm" }, method = { RequestMethod.POST })
	public String login(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(password)){
			UserModel userModel=new UserModel();
			userModel.setName(name);
			userModel.setPassword(password);
			Result<Boolean>result=userService.isLogin(userModel);
			if(result.isSuccess()&&result.getModule()){
			   model.addAttribute("userName", name);
			   return "admin/admin";
			 }
			else {
				model.addAttribute("error", "用户名或密码不正确");
				return "admin/index";
			}
		}
		else {
			model.addAttribute("error", "用户或密码为空");
			return "admin/index";
		}
       
	}

	@RequestMapping(value = { "/register.json" }, method = RequestMethod.POST)
	public @ResponseBody Result<Void> register(
			@RequestParam(required = true) UserModel userModel)throws Exception {
		Result<Void>result=new Result<Void>();
	    Result<Void>ret=userService.addUser(userModel);
	    if(ret.isSuccess()){
	    	result.setSuccess(true);
	    }
	    else {
			result.setSuccess(false);
			result.setMessage("数据格式不正确，注册失败");
		}
		return result;
	}
	@RequestMapping(value = { "/modify.json" }, method = RequestMethod.POST)
	public @ResponseBody Result<Void> modify(
			@RequestParam(required = true) UserModel userModel)throws Exception {
		Result<Void>result=new Result<Void>();
		 Result<Void>ret=userService.addUser(userModel);
		    if(ret.isSuccess()){
		    	result.setSuccess(true);
		    }
		    else {
				result.setSuccess(false);
				result.setMessage("数据格式不正确，修改个人信息失败");
			}
		return result;
	}
	
}
