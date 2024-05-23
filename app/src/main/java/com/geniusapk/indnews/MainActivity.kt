package com.geniusapk.indnews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geniusapk.indnews.network.ApiProvider
import com.geniusapk.indnews.screen.AnimatedShimmer
import com.geniusapk.indnews.screen.HomeApp
import com.geniusapk.indnews.screen.NewsTabs
import com.geniusapk.indnews.screen.NewsViewModel
import com.geniusapk.indnews.ui.theme.INDNewsTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mainui

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: NewsViewModel by viewModels()
        setContent {
            INDNewsTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                mainui(viewModel)
//                Scaffold(modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
//
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Row(verticalAlignment = Alignment.CenterVertically) {
//
//                                    Spacer(modifier = Modifier.width(8.dp))
//                                    Text(
//                                        "IND News",
//                                        maxLines = 1,
//                                        overflow = TextOverflow.Ellipsis,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 20.sp
//                                    )
//                                }
//                            },
//                            actions = {
//                                IconButton(onClick = { /* do something */ }) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Settings,
//                                        contentDescription = "Localized description"
//                                    )
//                                }
//                            },
//                            scrollBehavior = scrollBehavior,
//
//
//
//                            )
//                    }
//
//
//                ) { innerPadding ->
//                    innerPadding
//
//                    Column(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxSize()
//                    ) {
//                        NewsTabs(viewModel)
//
//                        if (viewModel.res.value == null) {
//
//                            Column {
//                                repeat(10) {
//                                    AnimatedShimmer()
//                                }
//
//                            }
//
//                        } else {
//                            Column() {
//                                HomeApp(viewModel = viewModel)
//                            }
//                        }
//
//                    }
//
//
//                }
            }
        }
    }
}

