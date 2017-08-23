package member.model.dao;

import java.sql.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao(){}

	public Member checkIdDup(String userid) {
		Member member = null;
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
			member = session.selectOne("Member.memberInfo", userid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return member;
	}
	
	public Member selectMember(Member m) {
		Member member = null;
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
			member = session.selectOne("Member.loginCheck", m);
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return member;
	}

	public int insertMember(Member m) {
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
			result = session.insert("Member.insertMember", m);
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

	public int updateMember(Member m) {
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
			result = session.update("Member.updateMember", m);
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

	public int deleteMember(String userid) {
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
			result = session.delete("Member.deleteMember", userid);
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