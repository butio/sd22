package Music;

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
 * Servlet implementation class MusicCartServlet
 */
@WebServlet("/MusicCartServlet")
public class MusicCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			//文字化け対策
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			ArrayList<ArrayList<String>> musicList=new ArrayList<ArrayList<String>>();
			HttpSession session = request.getSession();

			 String album_id = request.getParameter("album_id");
			 String album_count = request.getParameter("album_count");

			 Dao dao = null;
			 ResultSet rs = null;
			 try{
					dao = new Dao();
					rs = dao.execute("SELECT album_id,album_count,music_name,price,releasedate FROM music where album_id = "+ album_id +";");
					while(rs.next()){
						ArrayList<String> rec = new ArrayList<String>();
						rec.add(rs.getString("album_id"));
						rec.add(rs.getString("album_count"));
						rec.add(rs.getString("music_name"));
						rec.add(rs.getString("price"));
						rec.add(rs.getString("releasedate"));
						musicList.add(rec);
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
			 System.out.println(musicList);
				request.setAttribute("MSL",musicList);
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);


	}

}
