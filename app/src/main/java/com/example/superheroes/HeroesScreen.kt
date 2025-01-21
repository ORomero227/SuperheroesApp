package com.example.superheroes

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperHeroesTheme

@Composable
fun HeroesList(
    heroes: List<Hero>,
    contentPadding: PaddingValues
) {
    LazyColumn(contentPadding = contentPadding) {
        items(heroes) { hero ->
            HeroItem(
                hero = hero,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
                .fillMaxWidth()
        ) {
            HeroInformation(
                name = hero.nameRes,
                description = hero.descriptionRes,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.padding(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.medium)
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopCenter
                )
            }
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes name: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun HeroesScreenPreview() {
    SuperHeroesTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SuperHeroesApp()
        }
    }
}