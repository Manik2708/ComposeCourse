@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    // as the name suggests it is used to modify the default properties of a widget/function
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstScreen()
                }
            }
        }
    }
}
@Composable
fun FirstScreen(){
    // the 'remember' keyword orders the compiler to remember the current state of the app
    var userName by remember {mutableStateOf("")}
    var nickname by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            TextField(value = userName, onValueChange ={text->
                userName=text
            })
            Button(onClick = {
                 nickname="Your nickname is: ${functionForString(name = userName)}"
            }) {
                Text(text = "Click Me!")
            }
            Text(text = nickname)
    })
}

fun functionForString(name: String):String{
    val array=name.toCharArray()
    var output=""
    for(i in 0..2){
        output+=array[Random.nextInt(array.size)]
    }
    return output
}