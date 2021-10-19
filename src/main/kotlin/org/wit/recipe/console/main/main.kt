package org.wit.recipe.console.main

import mu.KotlinLogging

import org.wit.recipe.console.models.RecipeModel

private val logger = KotlinLogging.logger {}

val recipes = ArrayList<RecipeModel>()

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
            4 -> searchRecipe()
            -99 -> dummyData()
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
    println("4. Search Recipes")
    println("-1. Exit")
    println()
    print("Enter an option : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addRecipe(){

    var recipe1 = RecipeModel()

    println("Add Recipe")
    println()
    print("Enter a Name : ")
    recipe1.name = readLine()!!

    print("Enter Short Description : ")
    recipe1.shortdescription = readLine()!!

    print("Add Ingredient : ")
    recipe1.ingredients = readLine()!!

    print("How do you cook the recipe : ")
    recipe1.howtomake = readLine()!!

    print("What is the cooking time : ")
    recipe1.cookingtime = readLine()!!

    print("Input allergens : ")
    recipe1.allergens = readLine()!!

    if (recipe1.name.isNotEmpty() && recipe1.shortdescription.isNotEmpty() && recipe1.ingredients.isNotEmpty() && recipe1.howtomake.isNotEmpty() && recipe1.cookingtime.isNotEmpty() && recipe1.allergens.isNotEmpty()) {
        recipes.add(recipe1.copy())
        logger.info("Recipe Added : [ $recipe1 ]")
    }
    else
        logger.info("Recipe Not Added")

}

fun updateRecipe() {
    println("Update Recipe")
    println()
    listRecipes()
    var searchId = getId()
    val recipe1 = search(searchId)

    if(recipe1 != null) {
        print("Enter a new Name for [ " + recipe1.name + " ] : ")
        recipe1.name = readLine()!!
        print("Enter a new  Short Description for [ " + recipe1.shortdescription + " ] : ")
        recipe1.shortdescription = readLine()!!
        println(
            "You updated [ " + recipe1.name + " ] for name " +
                    "and [ " + recipe1.shortdescription + " ] for short description." + "You changed [ " + recipe1.ingredients + " ] in ingredients" + "You changed [ " + recipe1.howtomake + " ] in cooking instructions" + "You changed [ " + recipe1.cookingtime + " ] in cooking time" + "You changed [ " + recipe1.allergens + " ] in allergens."
        )
    }
    else
        println("Recipe Not Updated...")
}

fun listRecipes() {
    println("List All Recipes")
    println()
    recipes.forEach { logger.info("${it}") }
    println()
}

fun searchRecipe() {

    var searchId = getId()
    val recipe1 = search(searchId)

    if(recipe1 != null)
        println("Recipe Details [ $recipe1 ]")
    else
        println("Recipe Not Found...")
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

fun search(id: Long) : RecipeModel? {
    var foundRecipe: RecipeModel? = recipes.find { p -> p.id == id }
    return foundRecipe
}


fun dummyData() {
    recipes.add(RecipeModel(1, "Bolognese", "Cheesy delight"))
    recipes.add(RecipeModel(2, "Carbonara", "Creamy"))
    recipes.add(RecipeModel(3, "Tortillas", "Spicy"))
}