package bank.controller;
import bank.model.UserDao;
import bank.utils.AccountTransaction;
import bank.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		model.addAttribute("title","Users List");
		List<User> list = userDao.getUsers();
		model.addAttribute("users",list);
		return "users";
	}
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String postUser(@ModelAttribute("user") User user) {
		int res = userDao.saveUser(user);
		if(res == 1){
			return "redirect:/users";
		}
		else{
			return "redirect:/not-found";
		}
	}
	@RequestMapping(value = "/not-found", method = RequestMethod.GET)
	public String notFound() {
		return "not-found";
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public String transaction(ModelMap m,@CookieValue(value="loggedInUser",required = false) String loggedUser) {
		m.addAttribute("transaction",new AccountTransaction());
		if(loggedUser == null){
			return "redirect:/signin";
		}
		return "transaction";
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public String transactionPost(
			@ModelAttribute("transaction") AccountTransaction accountTransaction
	) {
		int res = userDao.makeTransaction(accountTransaction);
		if(res == 0 ){
			return "redirect:/not-found";
		}
		return  "redirect:/users";
	}
}
