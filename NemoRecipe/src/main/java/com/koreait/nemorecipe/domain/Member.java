package com.koreait.nemorecipe.domain;

import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String user_id;
	private String user_pass;
	private String user_nickname;
	private String signup;
}
