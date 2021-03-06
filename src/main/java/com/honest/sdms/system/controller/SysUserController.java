package com.honest.sdms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.honest.sdms.basedata.APIResponse;
import com.honest.sdms.basedata.ResultStatus;
import com.honest.sdms.basedata.config.SdmsLog;
import com.honest.sdms.basedata.exceptions.HSException;
import com.honest.sdms.system.entity.SysUser;
import com.honest.sdms.system.service.ISysUserService;

@RequestMapping("/userManagement")
@RestController
public class SysUserController{

	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 用户查询
	 * @param user
	 * @param pageNumber
	 * @param pageSize
	 * @param sortName
	 * @param sortOrder
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces={"application/json;charset=UTF-8;"})
	public @ResponseBody PageInfo<SysUser> searchUsers(SysUser cond,int pageNum,int pageSize,String sortName, String sortOrder){
		PageInfo<SysUser> pageInfo = sysUserService.findByCondWithPage(cond, sortName, sortOrder, pageNum, pageSize);
		return pageInfo;
	}
	
	/**
	 * 新增或更新用户
	 * @throws HSException 
	 * @throws CustomException 
	 */
	@SdmsLog(value = "新增或修改用户信息")  //这里添加了AOP的自定义注解
	@RequestMapping(value="/saveUser",method={RequestMethod.POST})
	public @ResponseBody APIResponse<String> saveUser(SysUser user) throws HSException{
		sysUserService.saveOrUpdateSysUser(user);
		return new APIResponse<String>(ResultStatus.OK);
	}
	
}
