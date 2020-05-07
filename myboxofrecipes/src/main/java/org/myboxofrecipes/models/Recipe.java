package org.myboxofrecipes.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Recipe {

	@Id
	private String name;
	private String type, from_kitchen_of, method, save_type;
	private Integer serves, minutes_to_prepare;

	@OneToMany(cascade=CascadeType.ALL)
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	@ElementCollection
	private List<String> keywords = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom_kitchen_of() {
		return from_kitchen_of;
	}
	public void setFrom_kitchen_of(String from_kitchen_of) {
		this.from_kitchen_of = from_kitchen_of;
	}
	
	@Transient
	public String getSave_type() {
		return save_type;
	}
	public void setSave_type(String save_type) {
		this.save_type = save_type;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Integer getServes() {
		return serves;
	}
	public void setServes(Integer serves) {
		this.serves = serves;
	}
	public Integer getMinutes_to_prepare() {
		return minutes_to_prepare;
	}
	public void setMinutes_to_prepare(Integer minutes_to_prepare) {
		this.minutes_to_prepare = minutes_to_prepare;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
