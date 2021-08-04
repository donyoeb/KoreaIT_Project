package com.koreait.nemorecipe.model.service.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.nemorecipe.domain.Recipe;
import com.koreait.nemorecipe.exception.DMLException;
import com.koreait.nemorecipe.model.repository.recipe.RecipeDAO;



@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO recipeDAO;
	

	@Override
	public List selectAll() {
		return recipeDAO.selectAll();
	}
	
	@Override
	public void regist(Recipe recipe)  throws DMLException{
		recipeDAO.regist(recipe);
	}

	@Override
	public Recipe select(int recipe_id) {
		return null;
	}

	@Override
	public void update(Recipe recipe) {
		
	}

	@Override
	public void delete(int recipe_id) {
		
	}

}
