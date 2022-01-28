package hostelmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostelmanagement.dao.HostelManagementDAO;
import user.dao.UserDAO;

/**
 * Servlet implementation class CollegeApplicationStatusStudentController
 */
@WebServlet("/CollegeApplicationStatusStudentController")
public class CollegeApplicationStatusStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CollegeApplicationStatusStudentController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("student", UserDAO.getStudentByStu_no((int) request.getSession().getAttribute("currentSessionUser")));
		request.setAttribute("collegeApplication", HostelManagementDAO.getCollegeApplicationByStu_no((int) request.getSession().getAttribute("currentSessionUser")));
		request.setAttribute("college", HostelManagementDAO.getCollegeByStu_no((int) request.getSession().getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("student/hostel_status.jsp");
		view.forward(request, response);
	}

}
