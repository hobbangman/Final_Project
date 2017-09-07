package org.kh.dajob.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.kh.dajob.member.model.vo.Company;
import org.kh.dajob.member.model.vo.CompanyType;
import org.kh.dajob.member.model.vo.Member;
import org.kh.dajob.member.model.vo.User;
import org.kh.dajob.workboard.model.vo.WorkBoard;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDao(){}

	public Member selectMember(Member m) {		
		return sqlSession.selectOne("Member.selectMember", m);
	}
	
	public int checkIdDup(String userid) {
		return sqlSession.selectOne("Member.checkDupId", userid);
	}
	
	public int insertMember(Member m) {
		return sqlSession.insert("Member.insertMember", m);
	}

	public int insertUser(User u) {
		return sqlSession.insert("User.insertUser", u);
	}

	public int insertCompany(Company c) {
		return sqlSession.insert("Company.insertCompany", c);
	}
	
	public int updateMember(Member m) {
		return sqlSession.update("Member.updateMember", m);
	}
	
	public int deleteMember(String userid) {
		return sqlSession.delete("Member.deleteMember", userid);
	}

	public ArrayList<CompanyType> selectCompanyList() {
		return new ArrayList<CompanyType>(sqlSession.selectList("Company.selectComType"));
	}

	public ArrayList<WorkBoard> likeCompList(String memberId, int page) {
		int limit = 10;
		int startPage = (page - 1) * limit + 1;
		int endPage = page * limit;
		RowBounds rowBounds = new RowBounds(startPage, endPage);
		return new ArrayList<WorkBoard>(sqlSession.selectList("WorkBoard.likeCompList", memberId, rowBounds));
	}
}

