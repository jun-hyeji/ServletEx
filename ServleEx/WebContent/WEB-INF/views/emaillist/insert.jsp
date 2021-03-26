<%@page import="com.bit.servlet.dao.EmailDaoOrclImpl"%>
<%@page import="com.bit.servlet.dao.EmailDao"%>
<%@page import="com.bit.servlet.dao.EmailVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//	요청 파라미터 받기
String firstName = request.getParameter("first_name");
String lastName = request.getParameter("last_name");
String email = request.getParameter("email");
//	VO 객체
EmailVo vo = new EmailVo(lastName, firstName, email);
EmailDao dao = new EmailDaoOrclImpl();
dao.insert(vo);	//	저장 완료
//	리스트 페이지로 돌려보내기: 302 -> REDIRECT
//	요청하는 페이지의 context path는 서버 환경, 설정에 따라
//	유동적으로 변할 수 있다 -> 동적으로 context path를 확인해야 한다
response.sendRedirect(request.getContextPath() + "/emaillist/");
%>