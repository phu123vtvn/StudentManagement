package com.ndp.controller.login;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndp.model.UserModel;
import com.ndp.service.IUserService;

@WebServlet(urlPatterns = {"/login","/logout"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view="";
		if(req.getParameter("action")!=null&&req.getParameter("action").equals("login")) {
			view = "/views/login.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
		}else if(req.getParameter("action")!=null&&req.getParameter("action").equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/login?action=login");
			
		}else {
			view="/views/admin/home.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view="";
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserModel model=userService.findOneByEmailAndPasswordAndStatus(email, password, 1);
		if(model!=null)
		{
			SessionUtil.getInstance().putValue(req, "USERMODEL", model);
			if(model.getRoleid()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin-home?type=view");
			}
			if(model.getRoleid()==2) {
				resp.sendRedirect(req.getContextPath()+"/web-home?type=view");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login?action=login");
		}
	}
}
