package org.wit.recipe.console.controllers

import mu.KotlinLogging
import org.wit.recipe.console.models.RecipeJSONStore
import org.wit.recipe.console.models.RecipeMemStore
import org.wit.recipe.console.models.RecipeModel
import org.wit.recipe.console.views.RecipeView

class RecipeController {

    // val recipes = RecipeMemStore()

    val recipes = RecipeJSONStore()

    val recipeView = RecipeView ()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Recipe Book App" }
        println("Recipe Book App")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Recipe Book App" }
    }


    fun menu() :Int { return recipeView.menu() }

    fun add(){
        var recipe1 = RecipeModel()

        if (recipeView.addRecipeData(recipe1))
            recipes.create(recipe1)
        else
            logger.info("Recipe Not Added")
    }

    fun list() {
        recipeView.listRecipes(recipes)
    }

    fun update() {

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
                logger.info("Recipe Not Updated")
        }
        else
            println("Recipe Not Updated...")
    }

    fun delete() {
        recipeView.listRecipes(recipes)
        var searchId = recipeView.getId()
        val recipe1 = search(searchId)

        if(recipe1 != null) {
            recipes.delete(recipe1)
            println("Recdipe Deleted...")
            recipeView.listRecipes(recipes)
        }
        else
            println("Recipe Not Deleted...")
    }


    fun search() {
        val recipe1 = search(recipeView.getId())!!
        recipeView.showRecipe(recipe1)
    }

    fun search(id: Long) : RecipeModel? {
        var foundRecipe = recipes.findOne(id)
        return foundRecipe
    }

    fun dummyData() {
        recipes.create(RecipeModel(name = "Bolognese", shortdescription = "Cheesy goodness", ingredients = "carrots, onions, mince beef, tomato paste", howtomake = "Saute onions, add beef, pour tomato paste", cookingtime = "40", allergens = "Celery"))
        recipes.create(RecipeModel(name= "Carbonara", shortdescription = "Creamy delight", ingredients = "pancetta, spaghetti, butter", howtomake = "Cook pancetta, pour cooked spaghetti onto pancetta", cookingtime = "20", allergens = "Dairy"))
        recipes.create(RecipeModel(name = "Tomato Soup", shortdescription = "Rich flavours", ingredients = "fresh tomatoes, tomato paste, basil, garlic", howtomake = "Cook fresh tomatoes, squish them when they're cooked, add tomato paste and garlic.", cookingtime = "60", allergens = "Basil"))
    }
}

