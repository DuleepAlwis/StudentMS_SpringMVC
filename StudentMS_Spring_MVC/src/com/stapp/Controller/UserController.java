
package com.stapp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserServiceImpl userService = new UserServiceImpl();
		UserEntity ue = userService.loginUser(email, password);
		
		ModelAndView mv = new ModelAndView();
		
		if(ue.getRole().equals("ADMIN")) {
			mv.setViewName("AdminMain"); 
			mv.addObject("user",ue);
		}
		return mv;
	}
}
