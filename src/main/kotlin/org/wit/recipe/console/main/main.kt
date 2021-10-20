package org.wit.recipe.console.main

import mu.KotlinLogging

import org.wit.placemark.console.controllers.RecipeController

import org.wit.recipe.console.models.RecipeMemStore
import org.wit.recipe.console.models.RecipeModel
import org.wit.recipe.console.views.RecipeView

private val logger = KotlinLogging.logger {}

val recipes = RecipeMemStore()
val recipeView = RecipeView ()
val controller = RecipeController()


fun main(args: Array<String>) {
    logger.info { "Launching Recipe Book App" }
    println("Recipe Book App")

    var input: Int

    do {
        input = recipeView.menu()
        when(input) {
            1 -> controller.addRecipe()
            2 -> controller.updateRecipe()
            3 -> controller.listRecipes()
            4 -> controller.searchRecipe()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Recipe Book Console App" }
}





