package org.myboxofrecipes.daolayer;

import java.util.List;

import org.myboxofrecipes.models.Recipe;

public interface RecipeService<E, K> {
	public void saveOrUpdateRecipe(Recipe recipe);
	public List<E> getAllRecipes();
	public Recipe getRecipe(K recipename);
	public Recipe removeRecipe(K recipename);	
}
