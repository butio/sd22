package AdminScreen;

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
 * Servlet implementation class newBandOutput
 */
@WebServlet("/newBandOutput")
public class newBandOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newBandOutput() {
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
		m.setBandName((String)request.getParameter("name"));
		m.setMail((String)request.getParameter("mail"));
		m.setPass((String)request.getParameter("pass"));
		m.setTelnumber((String)request.getParameter("telnumber"));
		m.setBankNumber((String)request.getParameter("bank"));

		//エラーがあれば入力画面に遷移する
		String fileJsp = "/newbandResult.jsp";
		if(m.getJsp()){
			fileJsp = "/newband.jsp";
		}

		session.setAttribute("sessionBandName",m.getBandName());
		session.setAttribute("sessionMail",m.getMail());
		session.setAttribute("sessionPass",m.getPass());
		session.setAttribute("sessionTelnumber",m.getTelnumber());
		session.setAttribute("sessionBankNumber",m.getBankNumber());

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
