package com.example.m203_jpcompose_0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m203_jpcompose_0.ui.theme.M203_JPCompose_0Theme



import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_JPCompose_0Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyForm()
                }
            }
        }
    }
}

@Composable
fun MyForm() {
    // États pour gérer les champs de texte et le clic sur le bouton
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Premier champ de texte
        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Entrez le texte 1") },
            modifier = Modifier.fillMaxWidth()
        )

        // Deuxième champ de texte
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Entrez le texte 2") },
            modifier = Modifier.fillMaxWidth()
        )

        // Bouton
        Button(
            onClick = {
                resultMessage = "Vous avez entré : $text1 et $text2"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Valider")
        }

        // Message de résultat
        if (resultMessage.isNotEmpty()) {
            Text(
                text = resultMessage,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}