package org.myboxofrecipes.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.myboxofrecipes.daolayer.RecipeService;
import org.myboxofrecipes.daolayer.RecipeServiceImpl;
import org.myboxofrecipes.models.Recipe;

@Path("/recipes")
public class RecipeEndpoints {
	private RecipeService recipeservice = new RecipeServiceImpl();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String reachBackend() {
		return "get me my recipes nowwww.";
	}
	
	@GET
	@Path("/recipemodel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecipeModel() {
	
		Recipe recipemodel = new Recipe();
			return Response
				.status(Response.Status.ACCEPTED)
				.entity(recipemodel)
				.build();
	
	}
	
	@GET
	@Path("/getAllRecipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRecipes() {
		List<Recipe> allrecipes = recipeservice.getAllRecipes();
		return Response
				.status(Response.Status.ACCEPTED)
				.entity(allrecipes)
				.build();
		}
	
	@GET
	@Path("getme/{recipename}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecipe(
			@PathParam("recipename") String recipename) {
		Recipe recipeiwant = recipeservice.getRecipe(recipename);
		return Response
				.status(Response.Status.ACCEPTED)
				.entity(recipeiwant)
				.build();
	}
	
	@POST
	@Path("/saveRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRecipe(Recipe recipeToSave) {
		recipeservice.saveOrUpdateRecipe(recipeToSave);
		return Response
				.status(Response.Status.CREATED)
				.entity(recipeservice.getAllRecipes())
				.build();
	}
	
	@PUT
	@Path("/updateRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecipe(Recipe recipeToSave) {
		recipeservice.saveOrUpdateRecipe(recipeToSave);
		return Response
				.status(Response.Status.ACCEPTED)
				.entity(recipeToSave)
				.build();
	}
	
	@DELETE
	@Path("deleteRecipe/{recipename}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRecipe(@PathParam("recipename") String recipeToDelete){
		recipeservice.removeRecipe(recipeToDelete);
		return Response
				.status(Response.Status.OK)
				.entity(recipeToDelete)
				.build();
	}
	

}
