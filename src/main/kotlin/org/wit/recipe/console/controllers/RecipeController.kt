package org.wit.placemark.console.controllers

import mu.KotlinLogging
import org.wit.recipe.console.models.RecipeMemStore
import org.wit.recipe.console.models.RecipeModel
import org.wit.recipe.console.views.RecipeView

class RecipeController {

    val recipes = RecipeMemStore()
    val recipeView = RecipeView ()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Recipe Book App" }
        println("Recipe Book App")
    }

    fun menu() :Int { return recipeView.menu() }

    fun addRecipe(){
        var recipe1 = RecipeModel()

        if (recipeView.addRecipeData(recipe1))
            recipes.create(recipe1)
        else
            logger.info("Recipe Not Added")
    }

    fun listRecipes() {
        recipeView.listRecipes(recipes)
    }

    fun updateRecipe() {

        recipeView.listRecipes(recipes)
        var searchId = recipeView.getId()
        val recipe1 = search(searchId)

        if(recipe1 != null) {
            if(recipeView.updateRecipeData(recipe1)) {
                recipes.update(recipe1)
                recipeView.showRecipe(recipe1)
                logger.info("Recipe Updated : [ $recipe1 ]")
            }
            else
                logger.info("Placemark Not Updated")
        }
        else
            println("Placemark Not Updated...")
    }


    fun searchRecipe() {
        val recipe1 = search(recipeView.getId())!!
        recipeView.showRecipe(recipe1)
    }

    fun search(id: Long) : RecipeModel? {
        var foundRecipe = recipes.findOne(id)
        return foundRecipe
    }

}