package com.spring.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.entity.ChuyenBay;

import com.spring.jwt.repository.ChuyenBayRepository;

@RestController
@RequestMapping("/api")
public class ChuyenBayController {
	
//	@Autowired
//	JmsProducer jmsProducer;
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@GetMapping("/findAllByGaDen/{gaDen}")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ResponseEntity<List<ChuyenBay>> findAllByGaDen(@PathVariable String gaDen){
		List<ChuyenBay> list = chuyenBayRepository.findAllByGaDen(gaDen);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findByCondition")
	public ResponseEntity<List<ChuyenBay>> findByCondition(){
		List<ChuyenBay> list = chuyenBayRepository.findByCondition(10000, 8000);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findCBByFromTo")
	public ResponseEntity<List<ChuyenBay>> findCBByFromTo(){
		return ResponseEntity.ok(chuyenBayRepository.findCBByFromTo("SGN", "BMV"));
	}
	
	
	@GetMapping("/findCBByFrom")
	public ResponseEntity<List<ChuyenBay>> findCBByFrom(){
		return ResponseEntity.ok(chuyenBayRepository.findCBByFrom("SGN"));
	}
	@GetMapping("/findChuyenMayByMB")
	public ResponseEntity<List<ChuyenBay>> findChuyenMayByMB(){
		return ResponseEntity.ok(chuyenBayRepository.findChuyenMayByMB("Airbus A320"));
	}
	@GetMapping("/findChuyenBay2Chieu")
	public ResponseEntity<List<ChuyenBay>> findChuyenBay2Chieu(){
		return ResponseEntity.ok(chuyenBayRepository.findChuyenBay2Chieu());
	}
	
	@GetMapping("/countCBFromGaDi")
	public ResponseEntity<List<Object>> countCBFromGaDi(){
		return ResponseEntity.ok(chuyenBayRepository.countCBFromGaDi());
	}
	
	@GetMapping("/totalPriceByCB")
	public ResponseEntity<List<Object>> totalPriceByCB(){
		return ResponseEntity.ok(chuyenBayRepository.totalPriceByCB());
	}
	@GetMapping("/totalCBByTime")
	public ResponseEntity<List<Object>> totalCBByTime(){
		return ResponseEntity.ok(chuyenBayRepository.totalCBByTime("12:00"));
	}
}
