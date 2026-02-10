package com.atom.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atom.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        SimpleButton()
                        Spacer(modifier = Modifier.height(16.dp))
                        ButtonWithColor()
                        Spacer(modifier = Modifier.height(16.dp))
                        ButtonWithTwoColors()
                        Spacer(modifier = Modifier.height(16.dp))
                        ButtonWithIcon()
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Ejemplo Boton")
    }
}

@Composable
fun ButtonWithColor() {
    Button(
        onClick = {
            //your onclick code
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
    )
    {
        Text(text = "Button with gray background", color = Color.White)
    }
}

@Composable
fun ButtonWithTwoColors(){
    Button(onClick = { /*TODO*/ },
        colors=ButtonDefaults.buttonColors(containerColor = Color.LightGray)){
        Text(text="Mitad y",color=Color.Magenta)
        Text(text="mitad",color= Color.Green)
    }
}

@Composable
fun ButtonWithIcon(){
    Button(onClick = { /*TODO*/ }) {
        Image(
            painterResource(id=R.drawable.ic_launcher_foreground),
            contentDescription = "Cart Icon",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Add to Cart")
    }
}

