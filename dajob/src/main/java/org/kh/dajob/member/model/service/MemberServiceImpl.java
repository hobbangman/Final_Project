package org.kh.dajob.member.model.service;

import java.util.ArrayList;

import org.kh.dajob.member.model.dao.MemberDao;
import org.kh.dajob.member.model.service.MemberService;
import org.kh.dajob.member.model.vo.Company;
import org.kh.dajob.member.model.vo.CompanyType;
import org.kh.dajob.member.model.vo.Member;
import org.kh.dajob.member.model.vo.User;
import org.kh.dajob.workboard.model.vo.WorkBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	// 의존성 주입 : Dependancy Injection
	private MemberDao memberDao;
	
	public MemberServiceImpl(){}
	
	@Override
	public Member loginMember(Member m){
		return memberDao.selectMember(m);
	}
	
	@Override
	public ArrayList<CompanyType> selectCompanyList() {
		return memberDao.selectCompanyList();
	}
	
	@Override
	public int checkIdDup(String id) {
		return memberDao.checkIdDup(id);
	}

	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(m);
	}

	@Override
	public int insertUser(User u) {
		return memberDao.insertUser(u);
	}

	@Override
	public int insertCompany(Company c) {
		return memberDao.insertCompany(c);
	}
	
	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(m);
	}

	@Override
	public int deleteMember(String id) {
		return memberDao.deleteMember(id);
	}
	
	@Override
	public ArrayList<WorkBoard> likeCompList(String memberId, int page) {
		return memberDao.likeCompList(memberId, page);
	}
}
