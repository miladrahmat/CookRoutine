package com.example.cookroutine.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cookroutine.data.MealCategory
import com.example.cookroutine.data.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen() {

    //Sample recipes
    val recipes = remember {
        mutableStateListOf(
            Recipe(
                title = "Avocado Toast & Poached Egg",
                description = "Sourdough bread topped with mashed avocado, chili flakes, and a soft poached egg.",
                prepTimeMinutes = 15,
                category = MealCategory.BREAKFAST
            ),
            Recipe(
                title = "Grilled Lemon Herb Chicken",
                description = "Marinated chicken breast served with roasted asparagus and garlic butter quinoa.",
                prepTimeMinutes = 30,
                category = MealCategory.DINNER
            ),
            Recipe(
                title = "Mediterranean Chickpea Salad",
                description = "Cucumber, cherry tomatoes, kalamata olives, feta, and olive oil dressing.",
                prepTimeMinutes = 10,
                category = MealCategory.LUNCH
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("CookRoutine") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val newIndex = recipes.size + 1
                    recipes.add(
                        Recipe(
                            title = "Quick Recipe #$newIndex",
                            description = "Custom quick meal added dynamically to state.",
                            prepTimeMinutes = 20,
                            category = MealCategory.DINNER
                        )
                    )
                }
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Add Recipe"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recipes, key = { it.id }) { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}