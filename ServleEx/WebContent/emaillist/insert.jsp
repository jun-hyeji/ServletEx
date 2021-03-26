<% %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 String firstname = request.getParameter("first_name");
 String lastName = request.getParameter("last_name");
 String email = request.getParameter("email");
 
 //	VO객체
 EmailVo	vo = new EmailVo(lastName,FirstName,email);
 EmailDao = new EmailDaoOrclImpl();
 
 dao.insert(vo)	//	저장 완료
 
 //	라스트페이지로 돌려보내기 302  -> REDIRECT
 response.
 