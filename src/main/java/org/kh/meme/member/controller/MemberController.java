package org.kh.meme.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.meme.member.domain.Member;
import org.kh.meme.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;

	@RequestMapping(value="/member/login.oj", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request
			,@RequestParam("user-id") String memberId
			,@RequestParam("user-pw") String memberPw) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		try {
			Member loginMember = mService.loginMember(member);
			if(loginMember != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember);
				System.out.println(session.getId()+"로그인 완료");
				return "redirect:/";
			}else {
				request.setAttribute("msg", "로그인 실패");
				return "common/errorPage";
			}
		}catch (Exception e) {
			request.setAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/join.oj", method=RequestMethod.GET)
	public String memberJoin() {
		
		return "member/memberJoin";
	}
	
	@RequestMapping(value="/member/join.oj", method=RequestMethod.POST)
	public String memberRegister() {
		
		return "redirect:/";
	}
	
}
