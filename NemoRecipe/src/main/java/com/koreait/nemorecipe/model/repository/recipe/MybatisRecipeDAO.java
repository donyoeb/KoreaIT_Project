package com.koreait.nemorecipe.model.repository.recipe;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.nemorecipe.domain.Checking;
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
	public List selectAllMy(int member_id) {
		return sqlSessionTemplate.selectList("recipe.selectAllMy", member_id);
	}

	@Override
	public List search(String word) {
		return sqlSessionTemplate.selectList("recipe.search", word);
	}
	
	@Override
	public Checking checkLike(Checking checking) {
		return sqlSessionTemplate.selectOne("recipe.selectCheckLike", checking);
	}

	@Override
	public void registChecking(Checking checking) {
		sqlSessionTemplate.insert("recipe.insertCheckLike", checking);
	}


	@Override
	public void updateChecking(int index) {
		sqlSessionTemplate.update("recipe.updateChecking", index);
	}


	@Override
	public void addHit(int recipe_id) {
		sqlSessionTemplate.update("recipe.addHit", recipe_id);
	}


	@Override
	public List selectAllLike() {
		return sqlSessionTemplate.selectList("recipe.selectAllLike");
	}


	@Override
	public List selectAllHit() {
		return sqlSessionTemplate.selectList("recipe.selectAllHit");
	}


	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("recipe.selectAll");
	}


	@Override
	public Recipe select(int recipe_id) {
		return sqlSessionTemplate.selectOne("recipe.select", recipe_id);
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
