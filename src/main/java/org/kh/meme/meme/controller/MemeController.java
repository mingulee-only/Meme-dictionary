package org.kh.meme.meme.controller;

import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
	
	@RequestMapping(value="/meme/detailView", method=RequestMethod.GET)
	public String memeDerailView() {	
		return "meme/memeDetailView";
	}
	
	

}
