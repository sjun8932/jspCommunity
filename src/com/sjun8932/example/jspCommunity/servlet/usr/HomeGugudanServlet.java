package com.sjun8932.example.jspCommunity.servlet.usr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@web까지 치고 Ctrl+Space
@WebServlet("/usr/home/gugudan2")
public class HomeGugudanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		if (req.getParameter("dan") == null) {
			resp.getWriter().append("dan을 입력해주세요");
			return;
		}

		int dan = Integer.parseInt(req.getParameter("dan"));
		int limit = 9;

		if (req.getParameter("limit") != null) {
			limit = Integer.parseInt(req.getParameter("limit"));
		}

		req.setAttribute("dan", dan);
		req.setAttribute("limit", limit);
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/usr/home/gugudan2.jsp");
		rd.forward(req, resp);
			
	}
}
