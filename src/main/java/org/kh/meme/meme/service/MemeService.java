package org.kh.meme.meme.service;

import java.util.List;

import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.PageInfo;

public interface MemeService {
	
	public int getListCount();
	public List<Meme> printAll(PageInfo pi);
	public int registerMeme(Meme meme);
	public Meme printOneByMeme (String memeName);


}
