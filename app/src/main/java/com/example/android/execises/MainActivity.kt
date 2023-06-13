package com.example.android.execises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

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
                    SnackBarApp()

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

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300F
                    )
                ))

            Text(text = title, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            style = TextStyle(color = Color.White, fontSize = 16.sp)
            )
        }
        
    }

}
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackBarApp(modifier: Modifier = Modifier){

    val snackBarHostState = remember {
        SnackbarHostState()
    }
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier.fillMaxSize(),

    ) {it
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
        ) {
            TextField(
                value = textFieldState,
                label = {
                        Text(text = "Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))

           
            Button(onClick = {
                scope.launch {
                    snackBarHostState.showSnackbar(" Hello $textFieldState")
                }


            }) {
                Text(text = "Greet Me")

            }
            Box() {
                SnackbarHost(hostState = snackBarHostState)
            }

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

@Preview(showBackground = true)
@Composable
fun SnackBarPreview() {
    ExecisesTheme {
        SnackBarApp()
    }
}