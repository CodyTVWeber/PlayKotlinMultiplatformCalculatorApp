package com.example.playkotlinmultiplatformcalculatorapp.android


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorGrid() {
    val buttons =
        listOf("1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0", "=", "/")
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
    ) {
        items(buttons) { button -> CalculatorButton(button) }
    }
}

@Composable
fun CalculatorButton(button: String) {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, button, Toast.LENGTH_SHORT).show()
    },
        modifier = Modifier.padding(4.dp),
        border = BorderStroke(3.dp, Color.LightGray),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            )
    ) {
            Text(
                text = button,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
            )
    }
}
