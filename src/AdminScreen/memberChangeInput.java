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
 * Servlet implementation class memberChangeInput
 */
@WebServlet("/memberChangeInput")
public class memberChangeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberChangeInput() {
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
			m.setName((String)request.getParameter("name"));
			m.setNickname((String)request.getParameter("nickname"));
			m.setMail((String)request.getParameter("mail"));
			m.setPass((String)request.getParameter("pass"));
			m.setAddress((String)request.getParameter("address"));
			m.setTelnumber((String)request.getParameter("telnumber"));
			m.setCard((String)request.getParameter("card"));
		}

		request.setAttribute("MEMBER",m);
		RequestDispatcher rd=request.getRequestDispatcher("/memberChange.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
