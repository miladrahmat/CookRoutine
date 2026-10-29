package com.example.cookroutine.ui

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cookroutine.data.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
   ElevatedCard(
       modifier = modifier.fillMaxWidth(),
       elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
   ) {
       Column(
           modifier = Modifier.fillMaxWidth(),
           verticalArrangement = Arrangement.spacedBy(8.dp)
       ) {
           Row(
               modifier = Modifier.padding(16.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Text(
                   text = recipe.title,
                   style = MaterialTheme.typography.titleMedium
               )

               Surface(
                   shape = MaterialTheme.shapes.small,
                   color = MaterialTheme.colorScheme.secondaryContainer
               ) {
                   Text(
                       text = recipe.category.displayName,
                       style = MaterialTheme.typography.labelSmall,
                       color = MaterialTheme.colorScheme.onSecondaryContainer,
                       modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                   )
               }
           }
           Text(
               text = recipe.description,
               style = MaterialTheme.typography.bodyMedium,
               color = MaterialTheme.colorScheme.onSurfaceVariant
           )

           Text(
               text = "⏱ ${recipe.prepTimeMinutes} mins",
               style = MaterialTheme.typography.labelMedium,
               color = MaterialTheme.colorScheme.primary
           )
       }
   }
}