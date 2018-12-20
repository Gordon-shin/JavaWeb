package org.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sc.bean.PostCount;
import org.sc.bean.UserCount;
import org.sc.dao.GenderCountDao;
import org.sc.dao.PostDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class adminPostServlet
 */
@WebServlet("/adminPostServlet")
public class adminPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PostDao postDao = new PostDao();
		List<PostCount> postCounts = postDao.queryPostCounts();
		JSONObject json = new JSONObject();
		JSONArray arrayauthor =new JSONArray();
		JSONArray arraycount = new JSONArray();
	     for (int i = 0; i < postCounts.size(); i++) { 
	        arrayauthor.add(postCounts.get(i).getAuthor());
	        arraycount.add(postCounts.get(i).getCount());
	       }
	     json.put("author", arrayauthor) ;
	     json.put("count", arraycount);
	     PrintWriter out = response.getWriter();
	     out.print(json);
	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
