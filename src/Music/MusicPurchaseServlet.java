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
 * Servlet implementation class MusicPurchaseServlet
 */
@WebServlet("/MusicPurchaseServlet")
public class MusicPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicPurchaseServlet() {
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

		ArrayList<ArrayList<String>> purchaseList=new ArrayList<ArrayList<String>>();
		HttpSession session = request.getSession();

		 Dao dao = null;
		 ResultSet rs = null;
		 try{
				dao = new Dao();
				rs = dao.execute("SELECT purchase.purchase_no, total, music.music_name, music.price, releasedate FROM purchase " +
						"INNER JOIN details ON purchase.purchase_no = details.purchase_no " +
						"INNER JOIN music ON music.album_id = details.album_id && music.album_count = details.album_count " +
						"WHERE user_id = "+session.getAttribute("ID") +";");
				while(rs.next()){
					ArrayList<String> rec = new ArrayList<String>();
					rec.add(rs.getString("purchase_no"));
					rec.add(rs.getString("music_name"));
					rec.add(rs.getString("price"));
					rec.add(rs.getString("releasedate"));
					purchaseList.add(rec);
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
		 System.out.println(purchaseList);
			request.setAttribute("PCL",purchaseList);
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
