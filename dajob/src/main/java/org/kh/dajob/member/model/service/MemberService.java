package org.kh.dajob.member.model.service;

import org.kh.dajob.member.model.vo.Company;
import org.kh.dajob.member.model.vo.Member;
import org.kh.dajob.member.model.vo.User;

public interface MemberService {
	Member loginMember(Member m);
	
	int checkIdDup(String id);
	
	int insertMember(Member m);
	
	int insertUser(User u);
	
	int insertCompany(Company c);

	int updateMember(Member m);

	int deleteMember(String id);
}
