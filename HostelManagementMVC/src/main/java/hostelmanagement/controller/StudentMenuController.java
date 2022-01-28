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
 * Servlet implementation class StudentMenuController
 */
@WebServlet("/StudentMenuController")
public class StudentMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMenuController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int stu_no = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("student", UserDAO.getStudentByStu_no(stu_no));
		request.setAttribute("collegeApplication", HostelManagementDAO.getCollegeApplicationByStu_no(stu_no));
		RequestDispatcher view = request.getRequestDispatcher("student/menu_student.jsp");
		view.forward(request, response);
	}
}
