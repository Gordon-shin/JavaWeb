package org.sc.servlet;



import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.Part;

import org.sc.bean.User;
import org.sc.dao.UserDao;

import java.io.File;


/**
 * Servlet implementation class UpdateAvatarServlet
 */
@WebServlet("/UpdateAvatarServlet")
@MultipartConfig
public class UpdateAvatarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAvatarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean b;
		Part part = request.getPart("avatar");
		String fileName = part.getSubmittedFileName();
		String stuId=((User)request.getSession().getAttribute("User")).getStuId();
		String password=((User)request.getSession().getAttribute("User")).getPassword();
		String stuName=((User)request.getSession().getAttribute("User")).getStuName();
	

		String avatar = "";
		if (fileName != null && !"".equals(fileName)) {
			String newFileName = UUID.randomUUID().toString() + "_" + fileName;
			String filePath = getServletContext().getRealPath("/img/upload");
			File f = new File(filePath);
			if (!(b=f.exists())) {
				f.mkdirs();
			}
			System.out.println(filePath);
			part.write(filePath + "/" + newFileName);
			System.out.println(newFileName);
			avatar = newFileName;
		}
		
		UserDao userDao = new UserDao();
		User user = new User();
		user.setPassword(password);
		user.setStuName(stuName);
		user.setAvatar(avatar);
		user.setStuId(stuId);
		Boolean c;
		c=userDao.updateimg(user);
		if (true) {
			//request.setAttribute("tip", "UpdateImages successfully, logining automatically.");
			HttpSession session = request.getSession(true);
			session.setAttribute("User", user);
			request.getRequestDispatcher("result2.jsp").forward(request, response);

		}
		
	}

}
