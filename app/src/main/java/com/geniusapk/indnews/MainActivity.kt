package com.geniusapk.indnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import com.geniusapk.indnews.screen.NewsViewModel
import com.geniusapk.indnews.ui.theme.INDNewsTheme
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

