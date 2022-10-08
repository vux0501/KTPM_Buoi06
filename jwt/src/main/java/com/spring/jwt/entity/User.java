package com.spring.jwt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_user")
@Setter
@Getter
public class User extends BaseEntity {
	private String username;
	private String password;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id" ) }, inverseJoinColumns = {
			@JoinColumn(name = "role_id",referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<>();


	
}
