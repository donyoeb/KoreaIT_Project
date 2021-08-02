package com.koreait.nemorecipe.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Recipe {

	private int recipe_id; //레시피번호
	private int member_id;  //유저
	private int type_id; //종류별
	private int situation_id; //상황별
	private int ingredient_id; //재료별별
	private int method_id; //방법별
	private int time_id; //조리시간
	private int level_id; //레벨
	private int serving; //인분
	
	private String recipe_img;//사진
	private String recipe_name; //레피시이름
	private String recipe_order; //조리순서
	private String recipe_ingredient; //재료
	
	private Timestamp date; //등록시간

	
}
