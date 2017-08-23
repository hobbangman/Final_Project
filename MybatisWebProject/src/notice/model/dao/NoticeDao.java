package notice.model.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao(){}
	
	public ArrayList<Notice> selectList(){
		ArrayList<Notice> list = null;
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
			list = new ArrayList<Notice>(session.selectList("Notice.selectAll"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public Notice selectOne(int noticeNo){
		Notice notice = null;
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
			notice = session.selectOne("Notice.selectOne", noticeNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return notice;
	}
	
	public ArrayList<Notice> selectTitle(
			String keyword){		
		ArrayList<Notice> list = null;
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
			list = new ArrayList<Notice>(session.selectList("Notice.selectTitle",keyword));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public int insertNotice(Notice n){
		int result = 0;
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
			result = session.insert("Notice.insertNotice", n);
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
	
	public int updateNotice(Notice n){
		int result = 0;
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
			result = session.update("Notice.updateNotice", n);
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
	
	public int deleteNotice(int noticeNo){
		int result = 0;
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
			result = session.delete("Notice.deleteNotice", noticeNo);
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







