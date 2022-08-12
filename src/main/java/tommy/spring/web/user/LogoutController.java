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
		System.out.println("�α׾ƿ� ó��");
		// 1. �������� ����� ���� ��ü�� ����
//		HttpSession session = request.getSession(false);
		session.invalidate();
		// 2. ���� ���� �� ���� ȭ������ �̵�
//		ModelAndView mav = new ModelAndView();
//		//mav.setViewName("login.jsp");
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//		//return "login";
		return "login.jsp";
	}
}
