package NewUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewUserRegist
 */
@WebServlet("/NewUserRegist")
public class NewUserRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserRegist() {
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

		String name = (String)session.getAttribute("sessionName");
		String mail = (String)session.getAttribute("sessionMail");
		String nickName = (String)session.getAttribute("sessionName");
		String pass = (String)session.getAttribute("sessionPass");
		String address = (String)session.getAttribute("sessionAdoress");
		String telnumber = (String)session.getAttribute("sessionTelnumber");
		String card = (String)session.getAttribute("sessionCard");

		int cnt=0;

		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost/sd22?characterEncoding=utf8","root","");

			st=con.createStatement();

			String sqlcnt="SELECT COUNT(*) FROM member;";
			rs=st.executeQuery(sqlcnt);

			while(rs.next()){
			      cnt=rs.getInt("COUNT(*)");
			  }
			cnt += 1;

			String sql="INSERT INTO member(user_id,user_name,user_nickname,user_mail,user_pass,user_adoress,user_telnumber,user_card,division) " +
					   "VALUES('"+cnt+"','"+name+"','"+nickName+"','"+mail+"','"+pass+"','"+address+"','"+telnumber+"','"+card+"','1');";
			st.executeUpdate(sql);

			response.sendRedirect("index.html");

		}catch(ClassNotFoundException e){
			return;
		}catch(SQLException e){
			return;
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
