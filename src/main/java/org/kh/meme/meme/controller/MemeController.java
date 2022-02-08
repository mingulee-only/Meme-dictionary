package org.kh.meme.meme.controller;

import java.util.List;

import org.kh.meme.common.Pagination;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.PageInfo;
import org.kh.meme.meme.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MemeController {

	@Autowired 
	private MemeService mService;
	
	@RequestMapping(value="/meme/registerView", method=RequestMethod.GET)
	public String memeWriteView() {
		
		return "meme/memeRegisterForm";
	}

	@RequestMapping(value = "/meme/register", method = RequestMethod.GET)
	public String memeRegister(Model model, @ModelAttribute Meme meme) {
		try {
			int result = mService.registerMeme(meme);
			if (result > 0) {
				System.out.println("등록성공");
				return "redirect:/";

			} else {
				System.out.println("등록 실패");
				return "redirect:/";

			}

		} catch (Exception e) {
			System.out.println("실패");
			return "redirect:/";

		}

	}
	
	@RequestMapping(value="/meme/list", method=RequestMethod.GET)
	public String memeListView(Model model
			,@RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = mService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount); 
		List<Meme>mList = mService.printAll(pi);
		try {
			if(!mList.isEmpty()) {
				model.addAttribute("mList",mList);
				model.addAttribute("pi", pi);
				return "meme/memeListView";				
			}else {
				System.out.println("전체조회실패");
				return "redirect:/";
			}
			
		}catch(Exception e) {
			System.out.println("실패");
			return "redirect:/";
			
		}
	}
	
	
	@RequestMapping(value = "/meme/detail", method = RequestMethod.GET)
	public String memeDetailView(
			Model model
			, @RequestParam(value="memeName") String memeName) {
		
		Meme meme = mService.printOneByMeme(memeName);
		if(meme !=null) {
			//조회수 증가
			mService.memeCountUpdate(meme.getMemeNo());
			
			model.addAttribute("meme", meme);
			return "meme/memeDetailView";
		}else {
			System.out.println("조회 실패");
			return "redirect:/";
		}
	}
	
	

}
