package org.wit.recipe.console.views

import org.wit.recipe.console.main.recipeView
import org.wit.recipe.console.main.recipes
import org.wit.recipe.console.models.RecipeMemStore
import org.wit.recipe.console.models.RecipeModel

class RecipeView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Recipe")
        println(" 2. Update Recipe")
        println(" 3. List All Recipe")
        println(" 4. Search Recipe")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listRecipes(recipes : RecipeMemStore) {
        println("List All Recipes")
        println()
        recipes.logAll()
        println()
    }

    fun showRecipe(recipe : RecipeModel) {
        if(recipe != null)
            println("Recipe Details [ $recipe ]")
        else
            println("Recipe Not Found...")
    }

    fun addRecipeData(recipe : RecipeModel) : Boolean {

        println()
        print("Enter a Name : ")
        recipe.name = readLine()!!
        print("Enter a Short Description : ")
        recipe.shortdescription = readLine()!!
        print("Enter Ingredients : ")
        recipe.ingredients = readLine()!!
        print("Enter Cooking Instructions : ")
        recipe.howtomake = readLine()!!
        print("Enter Cooking Time : ")
        recipe.cookingtime = readLine()!!
        print("Enter Allergens : ")
        recipe.allergens = readLine()!!


        return recipe.name.isNotEmpty() && recipe.shortdescription.isNotEmpty() && recipe.ingredients.isNotEmpty() && recipe.howtomake.isNotEmpty() && recipe.cookingtime.isNotEmpty() && recipe.allergens.isNotEmpty()
    }

    fun updateRecipeData(recipe : RecipeModel) : Boolean {

        var tempName: String?
        var tempShortdescription: String?
        var tempIngredients: String?
        var tempHowtomake: String?
        var tempCookingtime: String?
        var tempAllergens: String?

        if (recipe != null) {
            print("Enter a new Name for [ " + recipe.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Short Description for [ " + recipe.shortdescription + " ] : ")
            tempShortdescription = readLine()!!
            print("Enter Ingredients for [ " + recipe.ingredients + " ] : ")
            tempIngredients = readLine()!!
            print("Enter Cooking Instructions for [ " + recipe.howtomake + " ] : ")
            tempHowtomake = readLine()!!
            print("Enter a new Cooking Time for [ " + recipe.cookingtime + " ] : ")
            tempCookingtime = readLine()!!
            print("Enter new Allergens for [ " + recipe.allergens + " ] : ")
            tempAllergens = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempShortdescription.isNullOrEmpty() && !tempIngredients.isNullOrEmpty() && !tempHowtomake.isNullOrEmpty() && !tempCookingtime.isNullOrEmpty() && !tempAllergens.isNullOrEmpty()) {
                recipe.name = tempName
                recipe.shortdescription = tempShortdescription
                recipe.ingredients = tempIngredients
                recipe.howtomake = tempHowtomake
                recipe.cookingtime = tempCookingtime
                recipe.allergens = tempAllergens
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}