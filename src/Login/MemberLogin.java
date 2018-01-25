package Login;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		 HttpSession session = request.getSession();

		 String mail = request.getParameter("mail");
		 String pass = request.getParameter("pass");

		 ArrayList<ArrayList<String>> membertbl = new ArrayList<ArrayList<String>>();
		 Dao dao = null;
		 ResultSet rs = null;
		 try{
			 dao = new Dao();
			 rs = dao.execute("SELECT * FROM member");
			 if(mail.equals(rs.getString("member.user_mail")) && pass.equals(rs.getString("member.user_pass"))){
				 session.setAttribute("user_mail", mail);
				 session.setAttribute("user_pass", pass);
				 session.setAttribute("user_nickname",rs.getString("member.user_nickname") );
			 }else {
				 String errormessage = "正しい情報を入力してください";
			 }
	}catch(Exception e){

	}finally{
		try{
			if(rs != null){
				rs.close();
			}
			dao.close();
		}
		catch(Exception e){

		}
	}
		 RequestDispatcher rd = request.getRequestDispatcher("/logincomp.html");
		 rd.forward(request, response);
}
}
