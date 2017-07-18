package com.jredu.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jredu.entity.User;
import com.jredu.service.TestService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 表示每次接收一个请求创建一个Action对象..
 * 若改成其他,例如单例模式,则很多请求公用同一个Action.
 * 一个注册的例子,如果没加上这个注解,注册完成后,下一个请求再注册一次,Action里会保留上一次注册的信息..
 * @author Administrator
 */
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {

	private User user;
	
	@Autowired
	private TestService serice;
	
	private String code;
	
	public String execute() {
		if(code.equals("success")) {
			user=serice.test(user);
			//没存session...都一样
			return "success";
		} else {
			addActionError(getText("error.exist"));
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
