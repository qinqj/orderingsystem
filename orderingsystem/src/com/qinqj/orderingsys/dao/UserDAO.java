package com.qinqj.orderingsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qinqj.orderingsys.util.ConnectionFactory;
import com.qinqj.orderingsys.vo.User;


public class UserDAO {
	private Connection conn=ConnectionFactory.getConnection();
	
	public User selectByNamePwd(String username,String pwd){
		User user=null;
		String sql="select * from User where username=? and pwd=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
            rs=pstmt.executeQuery();
            if(rs.next()){
            	user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	public static void main(String[] args) {
		UserDAO dao=new UserDAO();
		User user=dao.selectByNamePwd("wangxh", "2");
		System.out.println(user);

	}
}
