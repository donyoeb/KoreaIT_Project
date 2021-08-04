package com.koreait.nemorecipe.model.repository.recipe;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.nemorecipe.domain.Recipe;
import com.koreait.nemorecipe.exception.DMLException;

@Repository //root-context의 컴포넌트 스캔의 대상이 되어 자동 인스턴스 생성됨 
public class MybatisRecipeDAO implements RecipeDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//root-context의 id와 일치하는걸 자동으로 매칭해줌


	@Override
	public void regist(Recipe recipe) throws DMLException {
		sqlSessionTemplate.insert("recipe.insert", recipe);
		
	}


	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("recipe.selectAll");
	}


	@Override
	public Recipe select(int recipe_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(int recipe_id) {
		// TODO Auto-generated method stub
		
	}


}
