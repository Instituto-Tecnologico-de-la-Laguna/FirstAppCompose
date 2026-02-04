package com.atom.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atom.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxWidth()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Row(Modifier.padding(32.dp)) {
                            Greeting(
                                name = "Android"
                            )
                        }
                        Row {
                            SimpleText()
                        }
                        Spacer(modifier = Modifier.padding(20.dp)   )
                        Row(){
                            LabelAndPlaceHolder()
                        }
                        Spacer(modifier = Modifier.padding(20.dp)   )
                        Row(){
                            TextFieldWithInputType()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        onValueChange = { it ->
            text = it
        }
    )
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Composable
fun SimpleText()
{
    var texto by remember{ mutableStateOf(TextFieldValue("")) }
    TextField(value=texto, onValueChange = { nuevoTexto -> texto=nuevoTexto})
}

@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppComposeTheme {
        Greeting("Android")
    }
}
