package com.atom.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atom.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Colum(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ){
                        SimpleButton()
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleButton(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Ejemplo Boton")
    }
}

