package org.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sc.bean.UserCount;
import org.sc.dao.GenderCountDao;

/**
 * Servlet implementation class Gender
 */
@WebServlet("/Gender")
public class Gender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fnumber="a";
		String  mnumber="b";
   	GenderCountDao gendercount = new GenderCountDao();
   	
       List <UserCount> usercounts =  gendercount.queryGenderNubmer();
               // cc= (usercounts.get(0).getGender()).equals(("w".toString()));
                String x=usercounts.get(0).getGender();
                System.out.println(x);
       for (int i = 0; i < usercounts.size(); i++) {
           if((usercounts.get(i).getGender()).equals("f"))
           {
           	fnumber = usercounts.get(i).getCount();
            System.out.println(fnumber);
           }
           else if((usercounts.get(i).getGender()).equals("m")){
           mnumber = usercounts.get(i).getCount();
           System.out.println(mnumber);		           	
           }
           
       }
     PrintWriter mout = response.getWriter();
     PrintWriter fout = response.getWriter();
     fout.write(fnumber);
     mout.write(mnumber);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
