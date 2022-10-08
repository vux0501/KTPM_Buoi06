package com.spring.jwt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jwt.entity.ChuyenBay;


@Repository
@Transactional
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String>{
//	4
	List<ChuyenBay> findAllByGaDen(String gaDen);
	@Query(nativeQuery = true, value = "select * from chuyenbay where do_dai < ?1 and do_dai > ?2")
	List<ChuyenBay> findByCondition(int cond1, int cond2);
//	5
	@Query(nativeQuery = true, value = "select * from chuyenbay where ga_di = ?1 and ga_den = ?2")
	List<ChuyenBay> findCBByFromTo(String from, String to);
//	6
	@Query(nativeQuery = true, value = "select * from chuyenbay where ga_di = ?1 ")
	List<ChuyenBay> findCBByFrom(String from);
	
// 	14
	@Query(nativeQuery = true, value = "select * from chuyenbay where do_dai < (select tambay from maybay where loai = ?1 )")
	List<ChuyenBay> findChuyenMayByMB (String loaiMb);
	
//	17
	@Query(nativeQuery = true, value="select cb_di.* from chuyenbay as cb_di, chuyenbay as cb_ve WHERE cb_di.ga_di = cb_ve.ga_den and cb_di.ga_den = cb_ve.ga_di")
	List<ChuyenBay> findChuyenBay2Chieu();
	
//	18
	@Query(nativeQuery = true, value="select chuyenbay.ga_di ,count(*) from chuyenbay group by(chuyenbay.ga_di)")
	List<Object> countCBFromGaDi();
//	19
	@Query(nativeQuery = true, value="select ga_di, SUM(chi_phi) as total from chuyenbay group by(ga_di)")
	List<Object> totalPriceByCB();
//	20
	@Query(nativeQuery = true, value="select ga_di, COUNT(*) from chuyenbay where gio_di < ?1 group by(ga_di)")
//	time: 12:00
	List<Object> totalCBByTime(String time);
}
