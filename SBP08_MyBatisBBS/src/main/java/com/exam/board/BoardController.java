package com.exam.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.board.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
		private BoardDao boardDao;
	
		//메인페이지
		@RequestMapping("/")
		public String root() throws Exception {
			
			return "redirect:boardList";
		}	
			//게시글 목록
			@RequestMapping("/boardList")
			public String boardList(Model model) {
				model.addAttribute("mtdBoardList",boardDao.mtdBoardList());
				return "boardList";
			}
			// 내용보기
				@RequestMapping("/boardView")
				public String boardView(HttpServletRequest req, Model model) {
					try {
						req.setCharacterEncoding("UTF-8");
						int num = Integer.parseInt(req.getParameter("num"));
						model.addAttribute("mtdBoardView",boardDao.mtdBoardView(num));
					} catch (Exception e) {
						e.getMessage();
					}
					return "boardView";
				}
				//게시글 쓰기
					@RequestMapping("/writeForm")
					public String writeForm() {
						
						return "writeForm";
					}
				// 글 저장
					@RequestMapping("/boardWrite")
					public String boardWrite(HttpServletRequest req) {
						try {
							req.setCharacterEncoding("UTF-8");
							String writer = req.getParameter("writer");
							String title = req.getParameter("title");
							String content = req.getParameter("content");
							boardDao.mtdBoardWrite(writer, title, content);
						} catch (Exception e) {
							e.getMessage();
						}
						
						
						return "redirect:boardList";
					}
						@RequestMapping("/boardDelete")
						public String boardDelet(HttpServletRequest req) {
							try {
								req.setCharacterEncoding("UTF-8");
								int num = Integer.parseInt(req.getParameter("num"));
								boardDao.mtdBoardDelete(num);
							} catch (Exception e) {
								e.getMessage();
							}
							
							return "redirect:boardList";
						}
			
}
