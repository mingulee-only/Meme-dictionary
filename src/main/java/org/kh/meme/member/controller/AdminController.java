package org.kh.meme.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.meme.board.domain.Board;
import org.kh.meme.common.PageInfo;
import org.kh.meme.common.Pagination;
import org.kh.meme.member.domain.Member;
import org.kh.meme.member.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	
	@RequestMapping(value="/admin/adminHome.me", method=RequestMethod.GET)
	public String adminHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		
		return "admin/adminHome";
	}
	
	@RequestMapping(value="/admin/manageMember.me", method=RequestMethod.GET)
	public String manageMember(HttpServletRequest request
			,Model model
			, @RequestParam(value="page", required=false) Integer page) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getAllMemberListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		model.addAttribute("pi", pi);
		
		
		List<Member> allMemberList = aService.printAllMember(pi);
		model.addAttribute("allMemberList", allMemberList);
		
		return "admin/manageMember";
	}
	
	@RequestMapping(value="/admin/manageMeme.me", method=RequestMethod.GET)
	public String manageMeme(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		return "admin/manageMeme";
	}
	
	@RequestMapping(value="/admin/manageBoard.me", method=RequestMethod.GET)
	public String manageBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		return "admin/manageBoard";
	}
	
	@RequestMapping(value="/admin/manageBoardReported.me", method=RequestMethod.GET)
	public String manageBoardReported(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		return "admin/manageBoardReported";
	}
	
	@RequestMapping(value="/admin/manageQuiz.me", method=RequestMethod.GET)
	public String manageQuiz(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		return "admin/manageQuiz";
	}
	
	@RequestMapping(value="/admin/manageQuizReported.me", method=RequestMethod.GET)
	public String manageQuizReported(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		if(member == null) {
			return "redirect:/login.me";
		}else if(member.getmGrade().equals("M")) {
			return "admin/error";
		}
		return "admin/manageQuizReported";
	}
}
