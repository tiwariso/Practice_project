package com.example.practice_project

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_project.ui.theme.Practice_projectTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_projectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  BMI_Calculator()
                }
            }
        }
    }
}

@Composable
fun BMI_Calculator(){
   Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
       var hightInput by remember { mutableStateOf("") }
       var weightInput by remember { mutableStateOf("") }
       var bmiS by remember { mutableStateOf("") }
       fun BMI_calculate(){
           var hightValue= hightInput.toDoubleOrNull()?:0.0
           var weightValue= hightInput.toDoubleOrNull()?:0.0
           val bmi = if (hightValue > 0) {
               weightValue / (hightValue * hightValue)
           } else {
               0.0 // Avoid division by zero
           }
            bmiS= bmi.toString()
       }
       OutlinedTextField(
           value = hightInput,
           onValueChange = { hightInput = it },
           label = { Text("Enter your Height (m)") }
       )
       OutlinedTextField(
           value = weightInput,
           onValueChange = { weightInput = it },
           label = { Text("Enter your Weight (kg)") }
       )
       Row {
           Box{
               Button(onClick={BMI_calculate()}){
                   Text("Calculate BMI")
               }
           }
       }
       Text("your BMI is $bmiS")
   }
}



