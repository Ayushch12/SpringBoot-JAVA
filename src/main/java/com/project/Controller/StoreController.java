package com.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoreController {

	@GetMapping("/")
	public String home () {
		return "home";
		
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return"bookRegister";
	}
	
	@GetMapping("/available_books")
	public String getAllBook() {
		return"bookList";
	}
	
	
}

