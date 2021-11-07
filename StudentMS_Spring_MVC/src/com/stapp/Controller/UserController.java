
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
	public UserController() {
		//System.out.println("User controller");
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserServiceImpl userService = new UserServiceImpl();
		UserEntity ue = userService.loginUser(email, password);
		
		ModelAndView mv = new ModelAndView();
		
		if(ue!=null && ue.getId()>0){
			if(ue.getRole().equalsIgnoreCase("ADMIN")) {
				mv.setViewName("AdminMain"); 
				mv.addObject("user",ue);
			}
		}else {
			mv.setViewName("error");
			mv.addObject("message","User not found");
			System.out.println("User not found");
		}
		return mv;
	}
}
