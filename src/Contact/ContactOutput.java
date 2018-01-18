package Contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ErrorCheck.MemberRegist;

/**
 * Servlet implementation class ContactOutput
 */
@WebServlet("/ContactOutput")
public class ContactOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactOutput() {
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

		//	リクエストパラメーターの取得
		MemberRegist m = new MemberRegist();
		m.setName((String)request.getParameter("name"));
		m.setMail((String)request.getParameter("mail"));
		m.getContact((String)request.getParameter("contact"));

		//エラーがあれば入力画面に遷移する
		String fileJsp = "/Output.jsp";
		if(m.getJsp()){
			fileJsp = "/Input.jsp";
		}

		request.setAttribute("MEMBER",m);
		RequestDispatcher rd=request.getRequestDispatcher(fileJsp);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
