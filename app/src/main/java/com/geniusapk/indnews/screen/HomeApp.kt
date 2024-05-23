package com.geniusapk.indnews.screen

import android.text.format.DateUtils
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import java.time.Instant


@Composable
fun HomeApp(viewModel: NewsViewModel, modifier: Modifier = Modifier) {

   // val res = viewModel.res.value?.articles!!
    val res = viewModel.res.value?.articles ?: emptyList()



        LazyColumn(
            modifier = modifier
                .padding()
                .fillMaxSize()
        ) {


            items(res) { article ->
                eachCard(
                    title = article.title,
                    url = article.urlToImage,
                    description = article.description,
                    content = article.content,
                    articleUrl = article.url,
                    date = article.publishedAt
                )
            }


        }


}

@Composable
fun eachCard(
    title: String,
    url: String?,
    description: String?,
    content: String?,
    articleUrl: String?,
    date: String? = null
) {
    var showDialog by remember { mutableStateOf(false) }
    val urlHandler = LocalUriHandler.current



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showDialog = true }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp)
        ) {
            if (url != null) {
                SubcomposeAsyncImage(
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    loading = {
                        imageani()
                    },
                    error = {
                        Text(text = "Error loading image")
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                date?.let {
                    TimeAgo(timestamp = it)
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {


                    urlHandler.openUri(articleUrl!!)

                }) {
                    Text("Read More")
                }
            },
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (url != null) {

                        AsyncImage(
                            model = url,
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp).clip(RoundedCornerShape(10.dp))
                        )

                    }

                    if (description != null) {
                        Text(
                            text = "Description:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = description,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    if (content != null) {
                        Text(
                            text = "Content:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = content,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        )
    }
}

// this is for time ago , because we are gatting row time from srver we can't use it
@Composable
fun TimeAgo(timestamp: String) {
    val timeAgo = remember(timestamp) {
        val instant = Instant.parse(timestamp)
        val now = System.currentTimeMillis()
        val time = instant.toEpochMilli()
        val relativeTime = DateUtils.getRelativeTimeSpanString(
            time,
            now,
            DateUtils.MINUTE_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        ).toString()
        relativeTime

    }

    Text(
        text = timeAgo,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,

            color = MaterialTheme.colorScheme.secondary,

            ),
    )
}