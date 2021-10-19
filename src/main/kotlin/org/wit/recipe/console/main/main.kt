package org.wit.recipe.console.main

import mu.KotlinLogging

import org.wit.recipe.console.models.RecipeModel

private val logger = KotlinLogging.logger {}

var recipe = RecipeModel()

fun main(args: Array<String>) {
    logger.info { "Launching Recipe Book App" }
    println("Recipe Book App")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addRecipe()
            2 -> updateRecipe()
            3 -> listRecipes()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Recipe Book Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Recipe")
    println(" 2. Update Recipe")
    println(" 3. List All Recipes")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addRecipe(){

    println("Add Recipe")
    println()
    print("Enter a Name : ")
    recipe.name = readLine()!!

    print("Enter Short Description : ")
    recipe.shortdescription = readLine()!!

    print("Add Ingredient : ")
    recipe.ingredients = readLine()!!

    print("How do you cook the recipe : ")
    recipe.howtomake = readLine()!!

    print("What is the cooking time : ")
    recipe.cookingtime = readLine()!!

    print("Input allergens : ")
    recipe.allergens = readLine()!!

    println("You added a [ " +recipe.name+ "] recipe, and described it - [ " +recipe.shortdescription+ "]. You added [ " +recipe.ingredients+ "] as ingredients. Cooking instructions you added are - [ " +recipe.howtomake+ "]. You added [" +recipe.allergens+ "] under allergens")

}

fun updateRecipe() {
    println("Update Recipe")
    println()
    print("Enter a new Title for [ " +recipe.name+ " ] : ")
    recipe.name = readLine()!!

    print("Enter a new Short Description for [ " +recipe.shortdescription+ " ] : ")
    recipe.shortdescription = readLine()!!

    print("Change an Ingredient [ " +recipe.ingredients+ "] : ")
    recipe.ingredients = readLine()!!

    print("Change cooking method [ " +recipe.howtomake+ "] : ")
    recipe.howtomake = readLine()!!

    print("Change the cooking time [ " +recipe.cookingtime+ "] : ")
    recipe.cookingtime = readLine()!!

    print("Input allergens [ " +recipe.allergens+ "] : ")
    recipe.allergens = readLine()!!

    println("You changed a [ " +recipe.name+ "] recipe, and changed the description to - [ " +recipe.shortdescription+ "]. You changed an [ " +recipe.ingredients+ "]. You changed cooking instruction to - [ " +recipe.howtomake+ "]. You updated [" +recipe.allergens+ "]")

}

fun listRecipes() {
    println("You Chose List All Recipes")
}