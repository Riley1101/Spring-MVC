package bank.controller;

import bank.model.UserDao;
import bank.utils.Auth;
import bank.utils.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController{
	@Autowired
	UserDao userdao;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@CookieValue(value = "loggedInUser",required = false) String username,Model m) {
		String name = "Guest";
		if(username != null){
			name = username;
		}
		m.addAttribute("user",name);
		return "home";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(ModelMap m) {
		m.addAttribute("auth", new Auth());
		return "signin";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signInPost(@ModelAttribute("auth") Auth auth, HttpServletResponse response) {
		List<User> users= userdao.findUser(auth);
		if(users.size() == 1){
			Cookie newCookie = new Cookie("loggedInUser",users.get(0).getName());
			newCookie.setMaxAge(60*60*24);
			response.addCookie(newCookie);
			return "redirect:/";
		}
		return "not-found";
	}

	@RequestMapping(value ="/signup", method = RequestMethod.GET)
	public String signup(Model m) {
		m.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping(value ="/signup", method = RequestMethod.POST)
	public String signUp() {
		return "signup";
	}
	@RequestMapping(value ="/signout", method = RequestMethod.GET)
	public String logout(HttpServletResponse response) {
		Cookie newCookie = new Cookie("loggedInUser","");
		newCookie.setMaxAge(0);
		response.addCookie(newCookie);
		return "redirect:/";
	}

}
