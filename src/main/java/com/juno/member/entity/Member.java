package com.juno.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;

@NoArgsConstructor
@Getter
@Entity
@DynamicInsert
@DynamicUpdate
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 20)
	private String loginId;

	@Column(length = 50)
	private String name;

	@Email
	@Column(length = 200)
	private String email;
}
