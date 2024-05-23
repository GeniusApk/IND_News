package com.geniusapk.indnews.screen

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun NewsTabs(viewModel: NewsViewModel) {
    val tabs = listOf("General", "Tech", "Sports" , "Business")
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(selectedTabIndex = selectedTabIndex,


        ) {

        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    val category = when (title) {
                        "Tech" -> "technology"
                        "Sports" -> "sports"
                        "Business" -> "business"
                        else -> null
                    }
                    viewModel.updateCategory(category)
                },
                text = { Text(title) }
            )

        }
    }
}