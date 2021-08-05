package com.koreait.nemorecipe.model.repository.recipe;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.koreait.nemorecipe.domain.Checking;
import com.koreait.nemorecipe.domain.Recipe;

public interface RecipeDAO {
	
	public List selectAll(); //목록가져오기
	public void regist(Recipe recipe); 
	public Recipe select(int recipe_id);
	public void update(Recipe recipe); //회원가입
	public void delete(int recipe_id);
	public List selectAllLike(); //좋아요순
	public List selectAllHit(); //조회수순
	public void addHit(int recipe_id); //조회수 증가
	public List search(String word); //검색
	public List selectAllMy(int member_id); //내가 쓴 글 조회
	public Checking checkLike(Checking checking); //좋아요 여부 확인
	public void registChecking(Checking checking);
	public void updateChecking(int index);
}
