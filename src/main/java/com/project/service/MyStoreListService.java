package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.MyStoreList;
import com.project.repository.MyStoreRepository;

@Service
public class MyStoreListService {
	
	@Autowired
	private MyStoreRepository mystore;
	
	public void saveMyStores(MyStoreList store) {
		mystore.save(store);
		
	}
	
	public List<MyStoreList> getAllMyBooks(){
		return mystore.findAll();
	}
	
	public void deleteById(int id) {
		mystore.deleteById(id);
	}

}
