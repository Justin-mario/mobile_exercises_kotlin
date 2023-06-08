package com.example.android.execises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.execises.ui.theme.ExecisesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExecisesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageCard(painter = painterResource(
                        id = R.drawable.facebook_1686131411882_7072147725383231886),
                        contentDescription = "fried egg and fried plantain", title = "Nigerian Breakfast")
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = cardElevation(4.dp)
    ) {
        Box(modifier = Modifier
          
            .fillMaxWidth()) {
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth())

            Box(modifier = Modifier.fillMaxSize()
                .padding(12.dp)
                .background(brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                startY = 300F
                )))

            Text(text = title, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            style = TextStyle(color = Color.White, fontSize = 16.sp)
            )
        }
        
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExecisesTheme {
        ImageCard(painter = painterResource(
            id = R.drawable.facebook_1686131411882_7072147725383231886),
            contentDescription = "fried egg and fried plantain", title = "Nigerian Breakfast")
    }
}