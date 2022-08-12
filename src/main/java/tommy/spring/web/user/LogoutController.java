package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {
	@RequestMapping("/logout.do")
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		// 1. 브라우저와 연결된 세션 객체를 종료
//		HttpSession session = request.getSession(false);
		session.invalidate();
		// 2. 세션 종료 후 메인 화면으로 이동
//		ModelAndView mav = new ModelAndView();
//		//mav.setViewName("login.jsp");
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//		//return "login";
		return "login.jsp";
	}
}
