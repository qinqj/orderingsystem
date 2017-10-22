package com.qinqj.orderingsys.service;

import com.qinqj.orderingsys.dao.UserDAO;
import com.qinqj.orderingsys.vo.User;



public class LoginService {
	UserDAO dao=new UserDAO();
	
	public int login(String username,String pwd){
		int flag=3;
		User user=dao.selectByNamePwd(username, pwd);
		if(user!=null){
			String status=user.getStatus();
			if(status.equals("0")){
				flag=0;
			}else if(status.equals("1")){
				flag=1;
			}else if(status.equals("2")){
				flag=2;
			}
		}	
		return flag;
	}
}
