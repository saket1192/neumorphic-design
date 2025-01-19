package com.saket.neumorphicdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saket.neumorphicdesign.ui.theme.NeumorphicDesignTheme
import com.saket.neumorphicview.NeumorphicView as NeuView

private val NeuBackgroundColor = Color(0xFFE0E5EC)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NeuBackgroundColor)
    ) {
        NeumorphicDesignTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = NeuBackgroundColor // This sets Scaffold's background
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    NeuView(
                        modifier = Modifier.size(200.dp),
                        backgroundColor = NeuBackgroundColor
                    ) {
                        Text(
                            text = "Hello Neumorphic!",
                            modifier = Modifier.align(Alignment.Center),
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}