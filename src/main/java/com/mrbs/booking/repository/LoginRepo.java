package com.mrbs.booking.repository;


import org.springframework.data.repository.CrudRepository;

import com.mrbs.booking.bean.LoginBean;

public interface LoginRepo extends CrudRepository<LoginBean,String>{

}
