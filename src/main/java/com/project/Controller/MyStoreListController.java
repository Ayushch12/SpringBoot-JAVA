package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.service.MyStoreListService;

@Controller
public class MyStoreListController {

    @Autowired
    private MyStoreListService service;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/my_books"; // Make sure this URL is correct based on your application's mapping
    }
}


