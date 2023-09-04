package com.zezzi.eventzezziapp.ui.concerts.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.R
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.ui.concerts.model.Concert
import com.zezzi.eventzezziapp.ui.concerts.model.allEventsData
import com.zezzi.eventzezziapp.ui.concerts.model.favoritesData
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme

private val CardWidth = 170.dp
private val CardPadding = 16.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConcertsView(navController: NavController) {
    var favorites = favoritesData
    var allEvents = allEventsData

    Scaffold(topBar = {
        AppBar(title = "Concerts", navController = navController)
    }) {
        ConcertsGrid(navController = navController,
            favorites = favorites,
            allEvents = allEvents)
    }
}

@Composable
fun ConcertsGrid(navController: NavController,
                 favorites: List<Concert>,
                 allEvents: List<Concert>) {

    val gradient = listOf(Color.Magenta, Color.Red)
    val allEventsGradient = listOf(Color.Blue, Color.Cyan)
    val gradientWidth = with(LocalDensity.current) {
        (6 * (CardWidth + CardPadding).toPx())
    }
    Surface(modifier = Modifier.fillMaxWidth()
        .padding(10.dp)) {
        val scroll = rememberScrollState(0)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = Modifier.padding(16.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                androidx.compose.material3.Text(
                    "Your Favorites",
                    Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Start
                )
            }
            itemsIndexed(favorites) { index, concert ->
                ConcertItem(
                    concert,
                    index,
                    gradient,
                    gradientWidth,
                    scroll.value
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                androidx.compose.material3.Text(
                    "All Concerts",
                    Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Start
                )
            }
            itemsIndexed(allEvents) { index, concert ->
                ConcertItem(
                    concert,
                    index,
                    allEventsGradient,
                    gradientWidth,
                    scroll.value
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EventPreview() {
    EventZezziAppTheme {
        ConcertsView(
            navController = rememberNavController()
        )
    }
}