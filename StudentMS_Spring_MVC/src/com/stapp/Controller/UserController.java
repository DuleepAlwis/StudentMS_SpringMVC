
package com.stapp.Controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stapp.Entity.UserEntity;
import com.stapp.serviceImpl.UserServiceImpl;

@Controller
public class UserController {

	/* private UserServiceImpl userService = new UserServiceImpl(); */
	
//	@RequestMapping(value="/user")
//	public String handler(Model model) {
//		UserEntity user = new UserEntity();
//		
//		user.setName("Hello");
//		model.addAttribute("name", user);
//		return "HelloWorld";
//	}
//	
	
   

	public UserController() {
		//System.out.println("User controller");
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getRootPage(HttpServletRequest req,HttpServletResponse res) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserServiceImpl userService = new UserServiceImpl();
		UserEntity ue = userService.loginUser(email, password);
		
		ModelAndView mv = new ModelAndView();
		
		if(ue!=null && ue.getId()>0){
			if(ue.getRole().equalsIgnoreCase("ADMIN")) {
				mv.setViewName("AdminMain"); 
				session.setAttribute("user", ue);
				
			}
		}else {
			mv.setViewName("error");
			mv.addObject("message","User not found");
			System.out.println("User not found");
		}
		return mv;
	}
	
	@RequestMapping(value="/password_forgot", method=RequestMethod.GET)
	public ModelAndView passwordForgot(HttpServletRequest req,HttpServletResponse res) {
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("passwordReset");
		return mv;
	}
	
	@RequestMapping(value="/send_code",method=RequestMethod.GET)
	public @ResponseBody String resetPassword(HttpServletRequest req,HttpServletResponse res) {
		
		String email = req.getParameter("email");
	
		return "Done";
	}
}
