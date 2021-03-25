package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	서블릿의 생명 주기 확인
public class LifecycleServelt extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//	첫 호출시 init 메서드가 수행 : 서블릿 초기화 담당
		super.init();
		System.out.println("Lisfecycle : init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청이 들어올 때 호출, 요청 방식에 따라 doGet or doPost
		super.doGet(req, resp);
		System.out.println("Lifecycle : service()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청이 GET 메서드 일 때
		System.out.println("Lifecycle : doGet()");
		//	컨텍스트 파라미터 불러오기
		//	1. 웹 앱의 컨텍스트 확보
		ServletContext context = getServletContext();
		String dbur1 = context.getInitParameter("dbur1");
		String dbuser = context.getInitParameter("dbuser");
		String dbpass = context.getInitParameter("dbpass");
		
		//	서블릿 초기화 파라미터
		//	먼저 서블릿 설정 받아오기
		ServletConfig config = getServletConfig();
		String servletNmae = config.getInitParameter("servlet-name");
		
		//	응답 인코딩 설정		-> 필터에서 처리
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/hteml;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>doGet call</h1>");
		out.println("<ul>");
		out.println("<li>dbur1 : " + dbur1 + "</li>");
		out.println("<li>dbur1 : " + dbuser + "</li>");
		out.println("<li>dbur1 : " + dbpass + "</li>");
		out.println("</ul>");
		
		out.println("<h3>Servelt Init Params</h3>");
		out.println("<p>servelt-name : " + servletNmae + "</p>");
	}

	@Override
	public void destroy() {
		// 서버 중단, 오랜 시간 서블릿 요청이 없을 때 -> 서블릿의 자원 정리
		super.destroy();
		System.out.println("Lifecycle : destory()");
	}


}
