package org.kh.meme.rank.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.kh.meme.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RankController {
	

	@RequestMapping(value="/rank/list.do", method = RequestMethod.GET)
	public String ranklist() {
		return "rank/newlist";
	}
}
