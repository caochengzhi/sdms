package com.honest.sdms;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.honest.sdms.system.entity.SysUser;

public class Constants {
	 
	public static final Integer BUTTON = 3;//按钮
	public static final Integer MENU = 2;//菜单
	public static final Integer MODEL = 1;//模块
	public static final String DEFAULT_PASSWORD = "123456";
	public static final Long DEFAULT_ORGANIZATIONID = 360L;
	
	public static final int DEFAULT_PAGE_SIZE = 20;
	 
	 public static final String JWT_ERRCODE_EXPIRE = "TOKEN_ERRCODE_EXPIRE_TOKEN签名过期";//Token超时异常
	 public static final String JWT_ERRCODE_FAIL = "JWT_ERRCODE_FAIL_TOKEN签名验证不通过";//token校验失败
	 
	 public static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";//验证码id
	 
	 public static final String TOKEN_NAME = "token";
	 public static final String TOKEN_HEAD = "X-Token";
	 public static final String SYS_USER = "sysuser";
	 
	 public static final String ORGANIZATIONID = "organizationId";
	 public static final String DEFAULT_CAPTCHA_PARAM = "captcha"; //为的是页面表单提交验证码的参数
	 public static final String USERNAME = "userName";
	 
	 public static final String ADMINISTRATR = "administrator";
	 
	 public static final Long MODIFY = 0L;
	 public static final Long VIEW = 1L;
	 
	 public static final String ERROR_PAGE = "/jsp/error/error.jsp";
	 
	 /**
	  * ehcache缓存分类
	  * @author beisi
	  */
	 public static class EhcacheTypes{
		 public static final String dict_cache = "dictCache";
	 }
	 
	 /**
	  * 数据操作类型
	  * @author beisi
	  */
	 public static class Operator{
		 public static final String ADD = "add";
		 public static final String MODIFY = "modify";
		 public static final String DELETE = "delete";
		 public static final String SEARCH = "search";
		 public static final String UPDATE = "update";
	 }
	 
	 public static SysUser getCurrentSysUser(){
		 Subject subject = SecurityUtils.getSubject();//第一步:获取我们的主体
	     SysUser user = (SysUser) subject.getPrincipal();
	     return user;
	 }
	 
	 /**
	  * 生成token载体
	  * @param tokenExpiration 超时时间，单位毫秒
	  * @return
	  */
	 public static Map<String, Object> getClaims(Long tokenExpiration){
		 SysUser user =  getCurrentSysUser();
		 Map<String, Object> claims = new HashMap<>(); 
		 claims.put("loginName", user.getLoginName());
		 claims.put("passWord", user.getLoginPassword());
		 claims.put("uuid", UUID.randomUUID());
		 if(tokenExpiration != null)
			 claims.put("tokenExpiration", tokenExpiration);
		 return claims;
	 }
	 
	 public static Map<String, Object> getClaims(){
		 return getClaims(null);
	 }
	 
}
