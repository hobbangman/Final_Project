package org.kh.dajob.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.dajob.member.model.service.MemberService;
import org.kh.dajob.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public void loginMember(Member m, HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8;");
		logger.info("loginMember() call...");
		PrintWriter chk = response.getWriter();

		Member member = memberService.loginMember(m);
		if(member != null){
			session.setAttribute("member", member); 
			chk.append("ok");
			chk.flush();
		} else {
			chk.append("no");
			chk.flush();
		}
		chk.close();
	}
	
	@RequestMapping("logout.do")
	public String logoutMember(HttpSession session){
		logger.info("logoutMember() call...");
		
		if(session.getAttribute("member") != null){			
			session.invalidate();
		}
		return "index";
	}
	
	@RequestMapping("enrollView.do")
	public String enrollView(){
		logger.info("enrollView() call...");
		
		return "member/enroll";
	}
	
	@RequestMapping("myinfo.do")
	public String myinfoView(){
		logger.info("myinfoView() call...");
		
		return "member/myinfo";
	}
	// 아이디 중복 체크
	@RequestMapping(value = "dupid.do", method = RequestMethod.POST)
	public void chkDupId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("chkDupId() call...");
		request.setCharacterEncoding("UTF-8");
		PrintWriter chk = response.getWriter();
		
		int result = memberService.checkIdDup(request.getParameter("userid"));
		
		if(result == 0){
			chk.append("ok");
			chk.flush();
		} else {
			chk.append("no");
			chk.flush();
		}
		chk.close();
	}
	
	@RequestMapping("userEnroll.do")
	public String userInsert(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
		logger.info("userInsert() call...");
		request.setCharacterEncoding("utf-8");
		String returnPage = null;
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String member_type_code = "U";
		String member_name = request.getParameter("member_name");
		String member_phone = request.getParameter("member_phone");
		
		StringBuilder sb = new StringBuilder();
		sb.append(request.getParameter("email1") + "@" +request.getParameter("email2"));
		String member_email = sb.toString();
		
		sb = new StringBuilder();
		sb.append(request.getParameter("post_code") + ",");
		sb.append(request.getParameter("addr1") + ",");
		sb.append(request.getParameter("addr2"));
		String member_address = sb.toString();
		System.out.println(new Member(member_id,member_password,member_type_code,
				member_name,member_email,member_phone,member_address,"default.jpg"));
		int result = memberService.insertMember(new Member(member_id,member_password,member_type_code,
				member_name,member_email,member_phone,member_address,"default.jpg"));
		if (result > 0) {
			returnPage = "index";
		} else {
			model.addAttribute("message", "회원 가입 서비스 실패!!");
			returnPage = "member/memberError";
		}
		
		return returnPage;
	}
	
	@RequestMapping("compEnroll.do")
	public String compInsert(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
		logger.info("compInsert() call...");
		request.setCharacterEncoding("utf-8");
		String returnPage = null;
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String member_type_code = "C";
		String member_name = request.getParameter("member_name");
		String member_phone = request.getParameter("member_phone");
		
		StringBuilder sb = new StringBuilder();
		sb.append(request.getParameter("email1") + "@" +request.getParameter("email2"));
		String member_email = sb.toString();
		
		sb = new StringBuilder();
		sb.append(request.getParameter("post_code") + ",");
		sb.append(request.getParameter("addr1") + ",");
		sb.append(request.getParameter("addr2"));
		String member_address = sb.toString();
		
		int result = memberService.insertMember(new Member(member_id,member_password,member_type_code,
				member_name,member_email,member_phone,member_address,"default.jpg"));
		if (result > 0) {
			returnPage = "index";
		} else {
			model.addAttribute("message", "회원 가입 서비스 실패!!");
			returnPage = "member/memberError";
		}
		
		return returnPage;
	}
	
	@RequestMapping("mupdate.do")
	public String memberUpdate(HttpServletRequest request, Model model, HttpSession session) throws UnsupportedEncodingException{
		logger.info("memberUpdate() call...");
		request.setCharacterEncoding("utf-8");
		String returnPage = null;
		
		String userId = request.getParameter("userid");		
		String userPwd = request.getParameter("userpwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		StringBuilder sb = new StringBuilder();
		sb.append(request.getParameter("post") + ",");
		sb.append(request.getParameter("address1") + ",");
		sb.append(request.getParameter("address2"));
		String address = sb.toString();
		
		int result = memberService.updateMember(new Member());
		if (result > 0) {
			session.setAttribute("member", memberService.loginMember((Member)session.getAttribute("member")));
			returnPage = "index";
		} else {
			model.addAttribute("message", "회원 정보 수정 실패!!");
			returnPage = "member/memberError";
		}
		
		return returnPage;
	}
	
	@RequestMapping("mdelete.do")
	public String memberDelete(HttpSession session, Model model){
		logger.info("memberDelete() call...");
		Member m = (Member)session.getAttribute("member");
		int result = 0;
		String returnPage = null;
		if(m != null){			
			result = memberService.deleteMember(m.getMember_id());
			if (result > 0) {
				returnPage = "index";
				session.invalidate();
			} else {
				model.addAttribute("message", "회원 탈퇴 서비스 실패!!");
				returnPage = "member/memberError";
			}
		} else {
			model.addAttribute("message", "회원 탈퇴 불가, 정상적인 접속이 아닙니다.");
			returnPage = "member/memberError";
		}
		return returnPage;
	}
}