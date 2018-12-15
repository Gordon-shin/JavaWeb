package org.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.sc.bean.Comment;
import org.sc.bean.UserCount;
import org.sc.util.DBUtil;

public class GenderCountDao {
	public List<UserCount> queryGenderNubmer() {
		Connection connection = DBUtil.getConnection();
		String sql = "SELECT gender,count(*) From tb_users group by gender";
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<UserCount> usercounts = new ArrayList<UserCount> ();
		try {
			pStatement = connection.prepareStatement(sql);
//			pStatement.setInt(1, postId);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				UserCount usercount = new UserCount();
				usercount.setGender(rs.getString(1));
				usercount.setCount(rs.getString(2));
				usercounts.add(usercount);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pStatement, connection);
		}
		
		return usercounts;
	}
	
//	public List<Comment> queryByPostId(int postId) {
//		Connection connection = DBUtil.getConnection();
//		String sql = "SELECT * FROM tb_comments WHERE postId=?";
//		PreparedStatement pStatement = null;
//		ResultSet rs = null;
//		List<Comment> comments = new ArrayList<Comment> ();
//		try {
//			pStatement = connection.prepareStatement(sql);
//			pStatement.setInt(1, postId);
//			rs = pStatement.executeQuery();
//			
//			while(rs.next()) {
//				Comment comment = new Comment();
//				comment.setCommentId(rs.getInt(1));
//				comment.setAuthor(rs.getString(2));
//				comment.setPostId(rs.getInt(3));
//				comment.setContent(rs.getString(4));
//				comment.setPosttime(rs.getTimestamp(5));
//				comments.add(comment);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeJDBC(rs, pStatement, connection);
//		}
//		
//		return comments;
//	}

}
