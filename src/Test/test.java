package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ErrorCheck.MemberLegist;
/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String ado = request.getParameter("ado");
		String tel = request.getParameter("tel");
		String card = request.getParameter("card");
		System.out.println(name);
		MemberLegist m = new MemberLegist();
		m.setName(name);
		m.setMail(mail);
		m.setPass(pass);
		m.setAdoress(ado);
		m.setTelbumber(tel);
		m.setCard(card);
		System.out.println(m.getName());
		System.out.println(m.errorName());
		System.out.println(m.getMail());
		System.out.println(m.errorMail());
		System.out.println(m.getPass());
		System.out.println(m.errorPass());
		System.out.println(m.getAdoress());
		System.out.println(m.errorAdoress());
		System.out.println(m.getTelnumber());
		System.out.println(m.errorTelnumber());
		System.out.println(m.getCard());
		System.out.println(m.errorCard());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
