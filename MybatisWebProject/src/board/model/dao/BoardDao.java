package board.model.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.vo.Board;

public class BoardDao {
	public BoardDao() {}

	public int getListCount() {
		int listCount = 0;
		SqlSession session = null;
		/* ibatis 는 mybatis의 전버전 */
		
		try {
			// 마이바티스 config 파일의 내용을 읽어서,
			// db 연결하고, statement 객체 생성 처리와
			// 동일한 의미를 가진 코드임
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			// 매퍼 파일 안에 작성된 쿼리문 실행시키고 결과 받음
			listCount = session.selectOne("Board.listCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		// 페이지 단위로 게시글 목록 조회용 메소드
		ArrayList<Board> list = null;
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		//BoardPage bp = new BoardPage(startRow, endRow);
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			RowBounds row = new RowBounds(startRow-1, endRow);
			System.out.println("startRow = "+startRow+" : "+row.getOffset());
			System.out.println("limit = "+endRow+" : "+row.getLimit());
			list = new ArrayList<Board>(session.selectList("Board.selectAll", null, row));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return list;
	}

	public ArrayList<Board> selectList() {
		// 페이지 단위로 게시글 목록 조회용 메소드
		ArrayList<Board> list = null;
		SqlSession session = null;
		/* ibatis 는 mybatis의 전버전 */
		
		try {
			// 마이바티스 config 파일의 내용을 읽어서,
			// db 연결하고, statement 객체 생성 처리와
			// 동일한 의미를 가진 코드임
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			list = new ArrayList<Board>(session.selectList("Board.selectTop5"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public Board selectBoard(int boardNum) {
		Board board = null;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			board = session.selectOne("Board.selectOne", boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return board;
	}

	public int insertBoard(Board b) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.insert("Board.insertBoard", b);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return result;
	}


	public void addReadCount(int boardNum) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.update("Board.addReadCount", boardNum);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public int deleteBoard(int boardNum) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.delete("Board.deleteBoard", boardNum);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public int insertReply(Board originBoard, Board replyBoard) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			// Board Level 에 따라 실행할 쿼리 변경
			result = session.insert("Board.insertReplyLevel", replyBoard);
			/*if(replyBoard.getBoardLevel() == 1){
				result = session.insert("Board.insertReplyLevel1", replyBoard);
			} if(replyBoard.getBoardLevel() == 2){
				result = session.insert("Board.insertReplyLevel2", replyBoard);
			}*/
			
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		
		return result;
	}

	public int updateReplySeq(Board replyBoard) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.update("Board.updateReplySeq", replyBoard);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	public int updateBoardReply(Board b) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.update("Board.updateBoardReply", b);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public int updateBoard(Board b) {
		int result = 0;
		SqlSession session = null;

		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(
					"mybatis/mybatis-config.xml")).openSession(false);
			
			result = session.update("Board.updateBoard", b);
			if(result > 0){
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

}