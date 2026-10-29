package com.example.cookroutine.data

import java.util.UUID

enum class MealCategory(val displayName: String) {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack")
}

data class Recipe(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val prepTimeMinutes: Int,
    val category: MealCategory
)