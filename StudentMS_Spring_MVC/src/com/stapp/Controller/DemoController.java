package com.stapp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	public DemoController() {
		//System.out.println("Demo constructer");
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addNumbers(HttpServletRequest req,HttpServletResponse res) {
		System.out.println(req.getParameter("email")+" "+req.getParameter("password"));
	}
}
