package com.mrbs.booking.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrbs.booking.bean.LoginBean;
@Repository
public interface LoginRepo extends CrudRepository<LoginBean,String>{
	
}
