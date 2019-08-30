package com.mrbs.booking.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrbs.booking.bean.MeetingRoom;
@Repository
public interface MeetingRoomRepo extends JpaRepository<MeetingRoom,Integer> {

	@Query("select m.meetingroomname from MeetingRoom m")
	public ArrayList<String> getMeetingRoom();
}
