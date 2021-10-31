
package com.stapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stapp.Entity.UserEntity;

@Controller
public class UserController {

	
	
	@RequestMapping(value="/user")
	public String handler(Model model) {
		UserEntity user = new UserEntity();
		
		user.setName("Hello");
		model.addAttribute("name", user);
		return "HelloWorld";
	}
}
