package com.geniusapk.indnews.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsTabs(viewModel: NewsViewModel) {
    val tabs = listOf("General", "Tech", "Sports" , "Business" , "Entertainment" , "Science")
    var selectedTabIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(selectedTabIndex = selectedTabIndex,
        //modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
        edgePadding = 16.dp,


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
                        "Entertainment" -> "entertainment"
                        "Science" -> "science"
                        else -> null
                    }
                    viewModel.updateCategory(category)
                },
                text = { Text(title) }
            )

        }
    }
}