
package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>  {

}