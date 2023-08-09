

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Store;
import com.project.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository bRepo;
	
	public void save(Store b) {
		bRepo.save(b);
	}
	
	public List<Store> getAllBook(){
		return bRepo.findAll();
	}
	
	public Store getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}