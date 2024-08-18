package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.affirmation.data.DataSource
import com.example.affirmation.model.Affirmation
import com.example.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationTheme {
                Scaffold(modifier = Modifier.fillMaxSize().statusBarsPadding()) { innerPadding ->
                    AffirmationApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier) {
    AffirmationList(affirmationList = DataSource.affirmations)
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation = affirmation, modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
fun AffirmationCard(modifier: Modifier = Modifier, affirmation: Affirmation) {
    Card(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = affirmation.image),
            contentDescription = stringResource(id = affirmation.title),
            modifier = modifier
                .fillMaxWidth()
                .height(194.dp), contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = affirmation.title),
            modifier = modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}