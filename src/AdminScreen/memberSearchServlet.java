package AdminScreen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ErrorCheck.MemberRegist;

/**
 * Servlet implementation class memberSearchServlet
 */
@WebServlet("/memberSearchServlet")
public class memberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberSearchServlet() {
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

		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		MemberRegist m = new MemberRegist();

		HttpSession session = request.getSession(true);

		try{

			String userName=request.getParameter("name");
			String userNickName=request.getParameter("nickName");
			String sql = "";
			String strJspName = "/memberSearchResult.jsp";

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sd22?characterEncoding=utf8","root","");

			st=con.createStatement();

				if(!userName.equals("")){
					sql="SELECT*FROM member WHERE user_name LIKE '%"+userName+ "%'";
				}else if(!userNickName.equals("")){
					sql="SELECT*FROM member WHERE user_nickname LIKE '%"+userNickName+ "%'";
				}

			rs=st.executeQuery(sql);

			while(rs.next()){
				session.setAttribute("USER_ID",(rs.getString("user_id")));
				session.setAttribute("USER_NAME",(rs.getString("user_name")));
				session.setAttribute("USER_NICKNAME",(rs.getString("user_nickname")));
				session.setAttribute("USER_MAIL",(rs.getString("user_mail")));
				session.setAttribute("USER_PASS",(rs.getString("user_pass")));
				session.setAttribute("USER_ADDRESS",(rs.getString("user_adoress")));
				session.setAttribute("USER_TELNUMBER",(rs.getString("user_telnumber")));
				session.setAttribute("USER_CARD",(rs.getString("user_card")));
			}

			request.setAttribute("MEMBER",m);
			RequestDispatcher rd=request.getRequestDispatcher(strJspName);
			rd.forward(request, response);

		}catch(NullPointerException e){
		}catch(ClassNotFoundException e){
		}catch(SQLException e){
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					//TODO:handle exception
				}
			}
			if(st!=null){
				try{
					st.close();
				}catch(SQLException e){
					//TODO:handle exception
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					//TODO:handle exception
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
