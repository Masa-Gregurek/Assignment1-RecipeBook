package org.wit.recipe.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class RecipeMemStore : RecipeStore {

    val recipes = ArrayList<RecipeModel>()

    override fun findAll(): List<RecipeModel> {
        return recipes
    }

    override fun findOne(id: Long) : RecipeModel? {
        var foundRecipe: RecipeModel? = recipes.find { p -> p.id == id }
        return foundRecipe
    }

    override fun create(recipe: RecipeModel) {
        recipe.id = getId()
        recipes.add(recipe)
        logAll()
    }

    override fun update(recipe: RecipeModel) {
        var foundRecipe = findOne(recipe.id!!)
        if (foundRecipe != null) {
            foundRecipe.name = recipe.name
            foundRecipe.shortdescription = recipe.shortdescription
            foundRecipe.ingredients = recipe.ingredients
            foundRecipe.howtomake = recipe.howtomake
            foundRecipe.cookingtime = recipe.cookingtime
            foundRecipe.allergens = recipe.allergens
        }
    }

    override fun delete(recipe: RecipeModel) {
        recipes.remove(recipe)
    }

    internal fun logAll() {
        recipes.forEach { logger.info("${it}") }
    }
}