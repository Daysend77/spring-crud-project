package demo.controller;

import demo.model.Role;
import demo.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.model.User;
import demo.service.UserServiceImpl;

import java.util.List;


@Controller
public class MyController {

@Autowired
private UserServiceImpl userService;

@Autowired
private RoleServiceImpl roleService;


	@GetMapping("/")
	public String indexAction() {
		return "index";
	}


@GetMapping("/add-user")
	public String addUserAction(Model model) {
		User user = new User();
        List<Role> roles = roleService.findAllRoles();
		model.addAttribute("user", user);
 		model.addAttribute("roles", roles);
		return "add-user";
	}


	@GetMapping("/users")
	public String usersAction(Model model) {
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "users";
	}


	@PostMapping("/save")
	public String save(String name, int role) {
		userService.saveUser(name, role);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editUserAction(@PathVariable String id, Model model) {
		int userId = Integer.parseInt(id);
		User user = userService.findUserById(userId);
		List<Role> roles = roleService.findAllRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		return "edit";
	}


	@PostMapping("/update-user/{id}")
	public String updateUserAction(@PathVariable String id, String name, int role) {
		int userId = Integer.parseInt(id);
		userService.updateUser(userId, name, role);
		return "redirect:/users";
	}



	@GetMapping("/delete-user/{id}")
	public String deleteUserAction(@PathVariable String id) {
		int userId = Integer.parseInt(id);
		userService.deleteUser(userId);
		return "redirect:/users";
	}
}