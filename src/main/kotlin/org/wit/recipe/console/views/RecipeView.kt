package org.wit.recipe.console.views


import org.wit.recipe.console.main.recipeView
import org.wit.recipe.console.main.recipes
import org.wit.recipe.console.models.RecipeJSONStore
import org.wit.recipe.console.models.RecipeModel

val GREEN = "\u001b[0;32m" // GREEN
val RESET = "\u001b[0m" // Text Reset

class RecipeView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println( GREEN + "MAIN MENU")
        println( GREEN + " 1. Add Recipe")
        println( GREEN + " 2. Update Recipe")
        println( GREEN + " 3. List All Recipe")
        println( GREEN + " 4. Search Recipe")
        println( GREEN + " 5. Delete Recipe")
        println( GREEN + "-1. Exit")
        println()
        print( GREEN + "Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listRecipes(recipes : RecipeJSONStore) {
        println( GREEN + "List All Recipes")
        println()
        recipes.logAll()
        println()
    }

    fun showRecipe(recipe : RecipeModel) {
        if(recipe != null)
            println( GREEN + "Recipe Details [ $recipe ]")
        else
            println( GREEN + "Recipe Not Found...")
    }

    fun addRecipeData(recipe : RecipeModel) : Boolean {

        println()
        print( GREEN + "Enter a Name : ")
        recipe.name = readLine()!!
        print( GREEN + "Enter a Short Description : ")
        recipe.shortdescription = readLine()!!
        print( GREEN + "Enter Ingredients : ")
        recipe.ingredients = readLine()!!
        print( GREEN + "Enter Cooking Instructions : ")
        recipe.howtomake = readLine()!!
        print( GREEN + "Enter Cooking Time : ")
        recipe.cookingtime = readLine()!!
        print( GREEN + "Enter Allergens : ")
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
            print( GREEN + "Enter a new Name for [ " + recipe.name + " ] : ")
            tempName = readLine()!!
            print( GREEN + "Enter a new Short Description for [ " + recipe.shortdescription + " ] : ")
            tempShortdescription = readLine()!!
            print( GREEN + "Enter Ingredients for [ " + recipe.ingredients + " ] : ")
            tempIngredients = readLine()!!
            print( GREEN + "Enter Cooking Instructions for [ " + recipe.howtomake + " ] : ")
            tempHowtomake = readLine()!!
            print( GREEN + "Enter a new Cooking Time for [ " + recipe.cookingtime + " ] : ")
            tempCookingtime = readLine()!!
            print( GREEN + "Enter new Allergens for [ " + recipe.allergens + " ] : ")
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
        print( GREEN + "Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}