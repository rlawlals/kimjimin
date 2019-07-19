package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.repository.MemoDao;

public class WriteController implements Controller {
	private MemoDao memoDao = new MemoDao();

	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equals("GET")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/view/write.jsp");

			return mv;
		} else if (req.getMethod().equals("POST")) {
//			write.jsp에서 작성된 content를 받아옴
			String content = req.getParameter("content");
//			데이터베이스에 전달
			memoDao.write(content);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/");
			return mv;
		}
		return null;
	}

}
