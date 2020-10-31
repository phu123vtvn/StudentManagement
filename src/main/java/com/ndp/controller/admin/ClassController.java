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
import com.ndp.model.MajorsModel;
import com.ndp.service.IClassService;
import com.ndp.service.IMajorsService;
import com.ndp.service.IStudentService;

@WebServlet(urlPatterns = { "/admin-class", "/web-class"})
public class ClassController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClassService classService;
	
	@Inject
	private IStudentService studentService;
	
	@Inject
	private IMajorsService majorsService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";
		
		if (req.getParameter("type").equals("view")) {
			view = "/views/admin/class/list.jsp";
			req.setAttribute("listclass", classService.findAll());
		} else if (req.getParameter("type").equals("listStudent")) {
			view = "/views/admin/class/list_student.jsp";
			long id=Long.parseLong(req.getParameter("id"));
			req.setAttribute("liststudent", studentService.findStudentByClassCode(id));
		} else if (req.getParameter("type").equals("edit")) {
			if (req.getParameter("id") != null) {
				view = "/views/admin/class/edit_class.jsp";
				long id=Long.parseLong(req.getParameter("id"));
				req.setAttribute("listclass", classService.findOne(id));
				req.setAttribute("listmajors", majorsService.findAll());
			}
		} else {
			view = "/views/admin/class/edit_class.jsp";
			req.setAttribute("listmajors", majorsService.findAll());
		}
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ClassModel cl=new ClassModel();
		cl.setClass_name(req.getParameter("name"));
		MajorsModel majors=new MajorsModel();
		majors.setMajors_code(Long.parseLong(req.getParameter("majors")));
		cl.setClass_majors(majors);
		if(req.getParameter("id").isEmpty())
		{
			classService.insert(cl);
			resp.sendRedirect(req.getContextPath()+"/admin-class?type=view");
		}else {
			cl.setClass_code(Long.parseLong(req.getParameter("id")));
			classService.update(cl);
			resp.sendRedirect(req.getContextPath()+"/admin-class?type=view");
		}
		req.setAttribute("listclass", classService.findAll());
	}

}
