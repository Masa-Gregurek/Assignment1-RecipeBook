package org.wit.recipe

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

var name = ""
var shortdescription = ""
var ingredients = ""
var howtomake = ""
var cookingtime = ""
var allergens = ""


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
    name = readLine()!!

    println("Enter Short Description : ")
    shortdescription = readLine()!!

    println("Add Ingredient : ")
    ingredients = readLine()!!

    println("How do you cook the recipe : ")
    howtomake = readLine()!!

    println("What is the cooking time : ")
    cookingtime = readLine()!!

    println("Input allergens : ")
    allergens = readLine()!!

    println("You added a [$name] recipe, and described it - [$shortdescription]. You added [$ingredients] as ingredients. Cooking instructions you added are - [$howtomake]. You added [$allergens] under allergens")

}

fun updateRecipe() {
    println("You Chose Update Recipe")
}

fun listRecipes() {
    println("You Chose List All Recipes")
}