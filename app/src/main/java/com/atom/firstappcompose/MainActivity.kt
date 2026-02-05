package com.atom.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lint.kotlin.metadata.Visibility
import com.atom.firstappcompose.ui.theme.FirstAppComposeTheme
import androidx.compose.material3.IconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier=Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                       TextoConDatos()
                    }
                    }
                }
            }
        }
    }

@Composable
fun TextoConPassword(){
    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        values=password,
        onValueChange = {password=it},
        label={Text("Contraseña")},
        placeholder={Text("Tecle la contraseña aqui")},
        singleLine=true,
        modifier= Modifier.padding(100.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyBoardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

        IconButton(onClick = {passwordVisible = !passwordVisible}){
            Icon(imageVector  = image, "Mostrar Contraseña")
        }
        }


    )

}

@Composable
fun TextoSimple(){
    var texto by remember {
        mutableStateOf("")
    }
    TextField(
        value=texto,
        onValueChange = {texto=it}
    )
}
@Composable
fun TextoConDatos(){
    var texto2 by remember{
        mutableStateOf("")
    }
    TextField(
        value=texto2,
        onValueChange = {texto2=it},
        label={Text("Usuario")},
        placeholder={Text("Tecle el usuario aqui")},
        leadingIcon = {
            Icon(imageVector= Icons.Default.Person, contentDescription=null)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppComposeTheme {
        Greeting("Android")
    }
}