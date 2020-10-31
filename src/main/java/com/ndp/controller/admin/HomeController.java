package com.ndp.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndp.model.ClassModel;
import com.ndp.model.StudentModel;
import com.ndp.service.IClassService;
import com.ndp.service.IStudentService;

@WebServlet(urlPatterns = { "/admin-home", "/admin-student","/web-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IStudentService studentService;

	@Inject
	private IClassService classService;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		if (request.getParameter("type").equals(null)) {
			view = "/views/admin/home.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("liststudent", studentService.findAll());
			rd.forward(request, response);
		} else if (request.getParameter("type").equals("view")) {
			view = "/views/admin/home.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("liststudent", studentService.findAll());
			rd.forward(request, response);
		} else if (request.getParameter("type").equals("edit")) {
			if (request.getParameter("id") != null) {
				long id = Long.parseLong(request.getParameter("id"));
				view = "/views/admin/student/edit.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				request.setAttribute("student", studentService.findOne(id));
				request.setAttribute("listClass", classService.findAll());
				rd.forward(request, response);
			}
		} else if(request.getParameter("type").equals("delete")){
			studentService.delete(Long.parseLong(request.getParameter("id")));
			request.setAttribute("listClass", classService.findAll());
			response.sendRedirect(request.getContextPath()+"/admin-student?type=view");
		}else {
			request.setAttribute("listClass", classService.findAll());
			view = "/views/admin/student/edit.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StudentModel student=null;
		String student_name = request.getParameter("name");
		String student_birth = request.getParameter("birth");
		String student_gender = request.getParameter("gender");
		String student_address = request.getParameter("address");
		ClassModel cl = new ClassModel();
		cl.setClass_code(Long.parseLong(request.getParameter("class")));
		
		if(request.getParameter("id").isEmpty())
		{
			student=new StudentModel(student_name, student_birth, student_gender, student_address, cl);
			studentService.insert(student);
			response.sendRedirect(request.getContextPath()+"/admin-student?type=view");
		}else {
			long student_code = Long.parseLong(request.getParameter("id"));
			student = new StudentModel(student_code, student_name, student_birth, student_gender,
					student_address, cl);
			studentService.update(student);
			response.sendRedirect(request.getContextPath()+"/admin-student?type=view");
		}
		request.setAttribute("liststudent", studentService.findAll());
	}
}
