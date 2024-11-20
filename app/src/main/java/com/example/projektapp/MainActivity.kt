package com.example.projektapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projektapp.ui.theme.ProjektAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    // State för att hålla reda på om dialogen ska visas
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hur klarar man tentan?")

        // Knapp som öppnar dialogen
        Button(onClick = { showDialog = true }) {
            Text("Facit")
        }
    }

    // Visa dialogen om showDialog är true
    if (showDialog) {
        AlertDialogExample(
            onDismissRequest = { showDialog = false },
            onConfirmation = { showDialog = false },
            dialogTitle = "Facit",
            dialogText = "Kurslitteraturen"
        )
    }
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = dialogTitle) },
        text = { Text(text = dialogText) },
        confirmButton = {
            TextButton(onClick = { onConfirmation() }) {
                Text("Tack...")
            }
        }
    )
}
