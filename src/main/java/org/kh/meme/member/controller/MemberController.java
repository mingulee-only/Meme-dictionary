package org.kh.meme.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.meme.member.domain.Member;
import org.kh.meme.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;

	@RequestMapping(value="/member/login.me", method=RequestMethod.GET)
	public String memberLogin(HttpServletRequest request
			,@RequestParam("memberId") String memberId
			,@RequestParam("memberPw") String memberPw) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		try {
			Member loginMember = mService.loginMember(member);
			if(loginMember != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember);
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
	
	@RequestMapping(value="/member/join.me", method=RequestMethod.GET)
	public String memberJoin() {
		
		return "member/memberJoin";
	}
	
	@RequestMapping(value="/member/findId.me", method=RequestMethod.GET)
	public String memberFindIdRedirect() {
		return "member/findId";
	}
	
	@RequestMapping(value="/member/findPw.me", method=RequestMethod.GET)
	public String memberFindPwRedirect() {
		return "member/findPw";
	}
	
	@RequestMapping(value="/member/myQuiz.me", method=RequestMethod.GET)
	public String memberMyQuizRedirect() {
		return "member/mypage/myQuiz";
	}
	
	@RequestMapping(value="/member/myComment.me", method=RequestMethod.GET)
	public String memberMyCommentRedirect() {
		return "member/mypage/myComment";
	}
	
	@RequestMapping(value="/member/modifyMember.me", method=RequestMethod.GET)
	public String memberModifyMemberRedirect() {
		return "member/mypage/modifyMember";
	}
	
	@RequestMapping(value="/member/deleteMember.me", method=RequestMethod.GET)
	public String memberDeleteMemberRedirect() {
		return "member/mypage/deleteMember";
	}
	

	@RequestMapping(value="/member/logout.me", method=RequestMethod.GET)
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			return "redirect:/";
		}else {
			request.setAttribute("msg", "로그아웃 실패!");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/join.me", method=RequestMethod.POST)
	public String memberRegister(
			Model model
			, @ModelAttribute Member member) throws UnsupportedEncodingException {
		try {
			int result = mService.registerMember(member);
			if(result > 0) {
				return "redirect:/";
			}else {
				model.addAttribute("msg", "회원가입 실패");
				return "common/errorPage";
			}			
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/findId.me", method=RequestMethod.POST)
	public String memberFindId(HttpServletRequest request
			, Model model
			, @ModelAttribute Member member) {
		try {
			Member memberOne = mService.findMemberId(member);
			if(memberOne != null) {
				model.addAttribute("member", memberOne);
				return "member/findIdPrint";
			}else {
				request.setAttribute("msg", "아이디 찾기 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			request.setAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/findPw.me", method=RequestMethod.POST)
	public String memberFindPw(HttpServletRequest request
		, Model model
		, @ModelAttribute Member member) {
		try {
			Member memberOne = mService.findMemberPw(member);
			if(memberOne != null) {
				model.addAttribute("member", memberOne);
				return "member/pwReset";
			}else {
				request.setAttribute("msg", "비밀번호 찾기 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			request.setAttribute("msg", e.toString());
			return "common/errorPage";
			}
		}
	
	@RequestMapping(value="/member/pwReset.me", method=RequestMethod.POST)
	public String memberPwReset(HttpServletRequest request
		, Model model
		, @ModelAttribute Member member) {
		try {
			int result = mService.memberPwReset(member);
			if(result > 0) {
				return "member/pwResetSuccess";
			}else {
				request.setAttribute("msg", "비밀번호 재설정 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			request.setAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
}
