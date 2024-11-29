package com.example.polinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var userInput by remember { mutableStateOf("") }
    var welcomeText by remember { mutableStateOf("Добро пожаловать в наше приложение!") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = welcomeText,
                style = MaterialTheme.typography.headlineMedium // Выберите подходящий стиль
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Введите текст") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                welcomeText = "Вы ввели: $userInput"
            }) {
                Text("Отправить")
            }
            // Убрали строку, отвечающую за вывод нижнего текста
        }
    }
}

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyAppTheme {
        MainScreen()
    }
}