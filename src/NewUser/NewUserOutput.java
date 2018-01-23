package NewUser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ErrorCheck.MemberRegist;

/**
 * Servlet implementation class NewUserOutput
 */
@WebServlet("/NewUserOutput")
public class NewUserOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserOutput() {
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

		HttpSession session = request.getSession(true);

		//	リクエストパラメーターの取得
		MemberRegist m = new MemberRegist();
		m.setName((String)request.getParameter("name"));
		m.setNickname((String)request.getParameter("nickname"));
		m.setMail((String)request.getParameter("mail"));
		m.setPass((String)request.getParameter("pass"));
		m.setAddress((String)request.getParameter("address"));
		m.setTelnumber((String)request.getParameter("telnumber"));
		m.setCard((String)request.getParameter("card"));

		//エラーがあれば入力画面に遷移する
		String fileJsp = "/newuserResult.jsp";
		if(m.getJsp()){
			fileJsp = "/newuser.jsp";
		}

		session.setAttribute("sessionName",m.getName());
		session.setAttribute("sessionMail",m.getMail());
		session.setAttribute("sessionNickname",m.getNickname());
		session.setAttribute("sessionPass",m.getPass());
		session.setAttribute("sessionAdoress",m.getAdoress());
		session.setAttribute("sessionTelnumber",m.getTelnumber());
		session.setAttribute("sessionCard",m.getCard());

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
