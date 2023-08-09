

package com.project.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.MyStoreList;
import com.project.entity.Store;
import com.project.service.MyStoreListService;
import com.project.service.StoreService;
import org.springframework.ui.Model;



//import ch.qos.logback.core.model.Model;

import java.util.*;

@Controller
public class StoreController {
	
	
	@Autowired
	private StoreService service;
	
	
    @Autowired
    private MyStoreListService myStoreService;
    
    
	@GetMapping("/")
	public String home () {
		return "home";
		
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return"bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Store>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","store",list);
	}
	
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Store s) {
		service.save(s);
		return "redirect:/available_books";
	}
	

	
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyStoreList>list=myStoreService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id ) {
		Store s=service.getBookById(id);
		MyStoreList ms=new MyStoreList(s.getId(),s.getName(), s.getAuthor(), s.getPrice() );
		myStoreService.saveMyStores(ms);
		return "redirect:/my_books ";
	}
	

	/*
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Store s=service.getBookById(id);
		model.addAttribute("store",s);
		return "bookEdit";
		*/
	
	@RequestMapping("/editStore/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
	    Store s = service.getBookById(id);
	    model.addAttribute("store", s);
	    return "bookEdit";
	}

	@RequestMapping("/deleteStore/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
	
	
}



