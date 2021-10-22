package org.wit.recipe.console.main

import mu.KotlinLogging

import org.wit.recipe.console.controllers.RecipeController

import org.wit.recipe.console.models.RecipeMemStore
import org.wit.recipe.console.models.RecipeModel
import org.wit.recipe.console.views.RecipeView

private val logger = KotlinLogging.logger {}

val recipes = RecipeMemStore()
val recipeView = RecipeView ()
val controller = RecipeController()


fun main(args: Array<String>) {
    RecipeController().start()
}






