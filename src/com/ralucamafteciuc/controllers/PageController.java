package com.ralucamafteciuc.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.ralucamafteciuc.beans.User;
import com.ralucamafteciuc.database.DBConnection;

@Controller
public class PageController {
	/*
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexGet(@Validated User user, Model model) {
		System.out.println("Index GET");

		if(model.containsAttribute("username")) {
			model.addAttribute("IsVisitor", "");
			return "redirect:/home";			
		} else {
			model.addAttribute("IsVisitor", "visitor");
			return "register";
		}
	}	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(@Validated User user, Model model) {
		System.out.println("Login GET");

		model.addAttribute("LoginError", "");	
		
		if(model.containsAttribute("username")) {
			model.addAttribute("IsVisitor", "");
			return "redirect:/home";
		} else {
			model.addAttribute("IsVisitor", "visitor");
			return "login";
		}	
	}	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(@Validated User user, Model model) throws IOException {
		System.out.println("Login POST");

		String username = user.getUsername();
		String password = user.getPassword();
		DBConnection dbConnection = new DBConnection();
		String path = "/";
		
		try {
			if(dbConnection.checkCredentialsForLogin(username, password, "users")) {
				model.addAttribute("LoginError", "");
				model.addAttribute("username", username);
				path = "redirect:/home";	
			} else {
				model.addAttribute("LoginError", "Try again!");
				path = "login";				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET(@Validated User user, Model model) {
		System.out.println("Register GET");
		
		if(model.containsAttribute("username")) {
			return "home";
		} else {
			return "register";
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(@Validated User user, Model model) throws IOException {
		
		System.out.println("Register POST");
		
		String username = user.getUsername();
		String email = user.getEmail();
		String password = user.getPassword();
		DBConnection dbConnection = new DBConnection();
		String path = "/";
		
		int hasEntered = 0;
		
		if (username == null || username.trim().isEmpty()) {
			model.addAttribute("UsernameRegistrationError", "Username is missing");
		} else
			try {
				if(dbConnection.checkIfUserExists("users", username)){
					model.addAttribute("UsernameRegistrationError", "Username already exists");
				} else {
					model.addAttribute("UsernameRegistrationError", "");
					hasEntered++;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		if (email == null || email.trim().isEmpty()) {
			model.addAttribute("EmailRegistrationError", "Email is missing");
		} else {
			model.addAttribute("EmailRegistrationError", "");
			hasEntered++;
		}		
		
		if (password == null || password.trim().isEmpty()) {
			model.addAttribute("PasswordRegistrationError", "Password is missing");
		} else {
			model.addAttribute("PasswordRegistrationError", "");
			hasEntered++;
		}
						
		if(hasEntered == 3) {
			try {
				dbConnection.insertExample(username, password, email, "users");
				model.addAttribute("username", username);
				model.addAttribute("IsVisitor", "");
				path = "redirect:/home";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {			
			path = "register";
		}
		
		return path;
	}
	
	@RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(@Validated User user, Model model) {
		System.out.println("Home");
		
		if(user.getUsername() != null) {
			model.addAttribute("IsVisitor", "");
			model.addAttribute("username", user.getUsername());
			model.addAttribute("ButtonPath", "/Curs7-WebApp/logout");
			model.addAttribute("ButtonText", "Logout");
		} else {
			model.addAttribute("IsVisitor", "visitor");
			model.addAttribute("ButtonPath", "/Curs7-WebApp/login");
			model.addAttribute("ButtonText", "Login");
		}
		
		return "home";
	}	
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(@Validated User user, Model model, SessionStatus status) {
		System.out.println("Logout");
		
		String username = user.getUsername();
		
		model.addAttribute("username", username);
		
		if(username != null || username != "") {
			model.addAttribute("IsVisitor", "visitor");
		}
		
		return "redirect:/";
	}		
	
	/*
	 * Course Examples
	 */
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page requested");
		model.addAttribute("userName", user.getUserName());
		
		return "user";
	}
	*/
}
