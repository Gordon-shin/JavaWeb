<%@page import="java.util.List"%>
<%@page import="org.sc.dao.GenderCountDao"%>

<%@page import="org.sc.bean.UserCount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserCount usercount = new UserCount();
	GenderCountDao gendercount = new GenderCountDao();
    List <UserCount> usercounts =  gendercount.queryGenderNubmer();
    for (int i = 0; i < usercounts.size(); i++) {
        out.println(usercounts.get(i).getGender());
        out.println(usercounts.get(i).getCount()+"</br>");
        
    }


%>

</body>
</html>