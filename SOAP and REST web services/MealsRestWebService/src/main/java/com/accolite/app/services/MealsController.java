package com.accolite.app.services;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.accolite.app.models.*;
import com.accolite.app.dbcon.*;

@RestController
@EnableAutoConfiguration
public class MealsController {

	/*
	 * retrieving all meals
	 * get localhost:8080/meals
	 */
	@RequestMapping(value = "/meals", method=RequestMethod.GET)
	public ResponseEntity<?> getMeals()
	{
		List<Meal> meals = MealsDTO.getAllMeals();
		return new ResponseEntity<List<Meal>>(meals,HttpStatus.OK);
	}
	
	/*
	 * requesting for specific meal
     * get localhost:8080/meals/{id}
	 */
	@RequestMapping(value = "/meals/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getMeals(@PathVariable("id")int id)
	{
		Meal meal = MealsDTO.getMeal(id);
		if(meal != null)
			return new ResponseEntity<Meal>(meal,HttpStatus.OK);
		else
			return new ResponseEntity<String>("No meal with the id found",HttpStatus.BAD_REQUEST); 
	}
	
	/*
	 * creating new meal
	 * post  localhost:8080/meals
	 */
	@RequestMapping(value = "/meals", method=RequestMethod.POST)
	public ResponseEntity<?> postMeals(@RequestBody Meal meal)
	{
		String result = MealsDTO.addMeal(meal);
		if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		else
			return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);	
			
	}
	
	/*
	 * creating new meal
	 * post  localhost:8080/meals/{id}
	 */
	@RequestMapping(value = "/meals/{id}", method=RequestMethod.POST)
	public ResponseEntity<?> updateMeal(@RequestBody Meal meal, @PathVariable("id")int id)
	{
		String result = MealsDTO.updateMeal(id, meal);
		if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		else
			return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);	
	}

	/*
	 * deleting a meal
	 * delete  localhost:8080/meals/{id}
	 */
	@RequestMapping(value = "/meals/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMeal(@RequestBody Meal meal, @PathVariable("id")int id)
	{
		String result = MealsDTO.deleteMeal(id, meal);
		if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		else
			return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);	
	}
	
	
//	
//	public static void main(String[] args) {
//		
//	}

}