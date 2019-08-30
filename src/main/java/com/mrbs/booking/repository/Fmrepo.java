package com.mrbs.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mrbs.booking.bean.LoginBean;

public interface Fmrepo extends JpaRepository<LoginBean, String>{

}
