package org.wit.recipe.console.models

data class RecipeModel(var name: String = "",
                       var shortdescription: String = "",
                       var ingredients: String = "",
                       var howtomake: String = "",
                       var cookingtime: String = "",
                       var allergens: String = "")