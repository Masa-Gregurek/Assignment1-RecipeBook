package org.wit.recipe

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}


fun main(args: Array<String>) {
    logger.info { "Launching Recipe Book App" }
    println("Recipe Book App")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> println("You Chose Add Recipe")
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