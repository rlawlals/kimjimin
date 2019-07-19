package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.MemoDto;
import spring.repository.MemoDao;

public class ListController implements Controller{
	
	private MemoDao memoDao = new MemoDao() ;
	
	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/list.jsp");
		
//		dao를 통해 리스트를 출력
		List<MemoDto> list = memoDao.list();
		
//		페이지로 list 값을 전달
		mv.addObject("list", list);
		
		return mv;
	}
	

}
