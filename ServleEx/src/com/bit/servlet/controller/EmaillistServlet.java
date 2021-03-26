package com.bit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/el")	//	현재 클래스를 /el url 패턴에 반응하는 서블릿으로 등록
//	web.xml에 <servler>과 <servlet-mapping>을 등록한 것과 동일 

@WebServlet(name="Emaillist", urlPatterns="/el")
public class EmaillistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	View 처리를 위한 RequestDispatcher를 확인
		//	자신이 처리하고 있던 요청 객체와 응답 객체를
		//	다른 서블릿(JSP)로 전달하여 추가 작업진행
		RequestDispatcher rd = 
				getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
		rd.forward(req, resp);
	}
	//	doGet Override
	
}