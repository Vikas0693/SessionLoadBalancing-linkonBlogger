package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/app/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("username")==null || request.getParameter("password")==null) {
			System.out.println("username and password not received at backened.");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("Username and password not passed.");
		}
		else
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("username received = "+username+" password = "+password);
			if(username.equals(password)) {
				HttpSession session = request.getSession(false);
				
				if(session!=null && !session.isNew()) {
					session.invalidate();
				}
				session=request.getSession(true);
				session.setAttribute("username", username);
				response.setStatus(HttpServletResponse.SC_OK);
				//response.sendRedirect("/SessionCheck.jsp");
			}
			else
			{
				System.out.println("Not valid Credentials.");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				out.println("Enter valid creds.");
			}
		}
	}

}
