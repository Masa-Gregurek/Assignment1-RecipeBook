package org.wit.recipe.console.controllers

import mu.KotlinLogging
import org.wit.recipe.console.models.RecipeJSONStore
import org.wit.recipe.console.models.RecipeModel
import org.wit.recipe.console.views.RecipeView

class RecipeController {

    // val recipes = RecipeMemStore()

    val recipes = RecipeJSONStore()

    val recipeView = RecipeView ()
    val logger = KotlinLogging.logger {}

    val GREEN = "\u001b[0;32m" // GREEN
    val RESET = "\u001b[0m" // Text Reset


    init {
        logger.info { GREEN + "Launching Recipe Book App" }
        println("Recipe Book App")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> addRecipe()
                2 -> updateRecipe()
                3 -> listRecipe()
                4 -> searchRecipe()
                5 -> deleteRecipe()
                -1 -> println( GREEN+ "Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { GREEN + "Shutting Down Recipe Book App" }
    }


    fun menu() :Int { return recipeView.menu() }

    fun addRecipe(){
        var recipe1 = RecipeModel()

        if (recipeView.addRecipeData(recipe1))
            recipes.create(recipe1)
        else
            logger.info(GREEN + "Recipe Not Added")
    }

    fun listRecipe() {
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
                logger.info(GREEN + "Recipe Updated : [ $recipe1 ]")
            }
            else
                logger.info( GREEN + "Recipe Not Updated")
        }
        else
            println( GREEN + "Recipe Not Updated...")
    }

    fun deleteRecipe() {
        recipeView.listRecipes(recipes)
        var searchId = recipeView.getId()
        val recipe1 = search(searchId)

        if(recipe1 != null) {
            recipes.delete(recipe1)
            println( GREEN + "Recdipe Deleted...")
            recipeView.listRecipes(recipes)
        }
        else
            println( GREEN + "Recipe Not Deleted...")
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

