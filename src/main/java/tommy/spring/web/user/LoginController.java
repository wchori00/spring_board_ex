package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tommy.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ���� ó��");
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessError("���̵�� �ݵ�� �Է��ؾ� �մϴ�");
		}
		// 1. ����� �Է� ���� ����
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");		
		
		// 2. �����ͺ��̽� ���� ó��
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
		
//		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
//		ModelAndView mav = new ModelAndView();
		if(user != null) {
//		if(userDAO.getUser(vo) != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
//			//mav.setViewName("getBoardList.do");
//			mav.setViewName("redirect:getBoardList.do");
		}else {
//			//return "login";
			return "login.jsp";
//			//mav.setViewName("login.jsp");
//			mav.setViewName("redirect:login.jsp");
		}
//		return mav;

	}
}
