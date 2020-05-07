package org.myboxofrecipes.daolayer;

import java.util.List;

import org.myboxofrecipes.models.Recipe;

//import org.springframework.beans.factory.annotation.Autowired;



public class RecipeServiceImpl implements RecipeService {
	
//	@Autowired
//	private RecipeDAO recipeDao;
	private RecipeDAO recipeDao = new RecipeDAO();
	

	@Override
	public void saveOrUpdateRecipe(Recipe recipe) {
		if (recipe.getSave_type().equals("new")) {
			recipeDao.save(recipe);
		}
		else {
			recipeDao.update(recipe.getName());
		}
		
	}

	@Override
	public List getAllRecipes() {
		return recipeDao.getAll(Recipe.class);
	}

	@Override
	public Recipe getRecipe(Object recipename) {		
		return recipeDao.get(Recipe.class,recipename);	
	}

	@Override
	public Recipe removeRecipe(Object recipename) {
		return recipeDao.remove(Recipe.class, recipename);
	}

}
