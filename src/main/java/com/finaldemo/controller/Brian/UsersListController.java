package com.finaldemo.controller.Brian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.BrainService;

@Controller
public class UsersListController {
	@Autowired
	private BrainService Service; // 連接Service 調用insertMessage

	@GetMapping("/memberManagement")
	public String memberManagement(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Users> page = Service.findByPage(pageNumber);
		Users newMsg = new Users();
		model.addAttribute("users", newMsg);
		model.addAttribute("page", page);
		return "Brian/memberManagement";
	}
	
	@InitBinder
    public void InitBinder(WebDataBinder binder) {
        //前端传入的时间格式必须是"yyyy-MM-dd"效果!
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
	}

	@PostMapping("/postUser")
	public String postUser(@ModelAttribute Users msg, Model model)  {
			
		Service.insertUsers(msg);

		return "redirect:/memberManagement";
	}
	
//	@GetMapping("/BrianfindById")
//	public String findAnUserById(@RequestParam(name = "id") Integer id, Model model) {
//		Users brianOneMember = Service.BrianfindById(id);
//		model.addAttribute("brianOneMember", brianOneMember);
//
//		return "redirect:/postUser";
//
//	}

}
