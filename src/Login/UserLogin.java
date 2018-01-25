package Login;

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

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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

		try{
			String _mail=request.getParameter("mail");
			String _pass=request.getParameter("pass");
			int er=0;
			int Classification=0;

			String strJspName = "";

			HttpSession session = request.getSession(true);

			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sd22?characterEncoding=utf8","root","");

			st=con.createStatement();

			String sql="SELECT*FROM member WHERE user_mail='"+_mail+"'and user_pass='"+_pass+"';";
			rs=st.executeQuery(sql);

			if (rs.next() == true){
				sql="SELECT user_nickname,division FROM member WHERE user_mail='"+_mail+"';";
				rs=st.executeQuery(sql);

				while(rs.next()){
					 	 session.setAttribute("ID",(rs.getString("user_id")));
						 session.setAttribute("NICKNAME",(rs.getString("user_nickname")));
					     Classification = rs.getInt("division");
				}

				if(Classification == 1){
					strJspName = "/index.html";
				}else if(Classification == 2){
					strJspName = "/admin.jsp";
				}else {
				strJspName  = "/error.jsp";
				}

			}

			request.setAttribute("ERORR",er);
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
