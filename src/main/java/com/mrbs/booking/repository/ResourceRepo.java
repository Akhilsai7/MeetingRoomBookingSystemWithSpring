package com.mrbs.booking.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrbs.booking.bean.Resource;
@Repository
public interface ResourceRepo extends JpaRepository<Resource,Integer> {


	@Query("select r.resourcename from Resource r")
	public ArrayList<String> getResource();
}
