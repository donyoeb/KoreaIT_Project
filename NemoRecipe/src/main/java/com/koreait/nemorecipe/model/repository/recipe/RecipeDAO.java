package com.koreait.nemorecipe.model.repository.recipe;

import java.util.List;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.domain.Recipe;

public interface RecipeDAO {
	
	public List selectAll(); //목록가져오기
	public void regist(Recipe recipe); 
	public Recipe select(int recipe_id);
	public void update(Recipe recipe); //회원가입
	public void delete(int recipe_id);
}
