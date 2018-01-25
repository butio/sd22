package AdminScreen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ErrorCheck.MemberRegist;

/**
 * Servlet implementation class newBandInput
 */
@WebServlet("/newBandInput")
public class newBandInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newBandInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberRegist m = new MemberRegist();

		//戻るボタンを押された時に送られてきた値を入れる
		if(request.getParameter("state") != null){
			m.setBandName((String)request.getParameter("name"));
			m.setMail((String)request.getParameter("mail"));
			m.setPass((String)request.getParameter("pass"));
			m.setTelnumber((String)request.getParameter("telnumber"));
			m.setBankNumber((String)request.getParameter("bankNumber"));
		}

		request.setAttribute("MEMBER",m);
		RequestDispatcher rd=request.getRequestDispatcher("./newband.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
