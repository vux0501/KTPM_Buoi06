package com.spring.jwt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chuyenbay")
@Data
@NoArgsConstructor
public class ChuyenBay {
	@Id
	@Column(columnDefinition = "varchar(5)", nullable = false)
	private String maCB;
	@Column(columnDefinition = "varchar(50)", nullable = true)
	private String gaDi;
	@Column(columnDefinition = "varchar(50)", nullable = true)
	private String gaDen;
	private int doDai;
	@Column(columnDefinition = "time")
	private Date gioDi;
	@Column(columnDefinition = "time")
	private Date gioDen;
	private int chiPhi;
}

