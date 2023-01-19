package com.prowings.crudoperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761726916876891935L;
	private SessionFactory factory;

	public void init() throws ServletException {
		factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String s1 = req.getParameter("eid");
		String s2 = req.getParameter("ename");
		String s3 = req.getParameter("ecity");

		int eid = Integer.parseInt(s1.trim());
		Session ses = factory.openSession();
		Employee e1 = new Employee();
		e1.setId(eid);
		e1.setName(s2);
		e1.setCity(s3);
		Transaction tx = ses.beginTransaction();
		ses.save(e1);
		tx.commit();
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Employee save successfully...</h2><br>");
		pw.println("<a href=index.jsp>Home</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		ses.close();
	}// service method

	public void destroy() {
		factory.close();
	}

}
