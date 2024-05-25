package com.example.playkotlinmultiplatformcalculatorapp.android


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorGrid() {
    val firstValue = remember {
        mutableStateOf("0")
    }
    val operator = remember {
        mutableStateOf("?")
    }
    val secondValue = remember {
        mutableStateOf("0")
    }
    val result = remember {
        mutableStateOf("?")
    }

    val calculate = {
        when (operator.value) {
            "+" -> result.value =
                add(firstValue.value.toInt(), secondValue.value.toInt()).toString()

            "-" -> result.value =
                subtract(firstValue.value.toInt(), secondValue.value.toInt()).toString()

            "*" -> result.value =
                multiply(firstValue.value.toInt(), secondValue.value.toInt()).toString()

            "/" -> result.value =
                divide(firstValue.value.toInt(), secondValue.value.toInt()).toString()
        }
    }

    val setter = { value: String ->
        if (value == "c") {
            firstValue.value = "0"
            operator.value = "?"
            secondValue.value = "0"
            result.value = "?"
        } else if (value == "=") {
            if (operator.value != "?") {
                calculate()
            }
        } else if (value == "+" || value == "-" || value == "*" || value == "/") {
            operator.value = value
        } else if (operator.value == "?") {
            firstValue.value = if (firstValue.value == "0") value else firstValue.value + value
        } else {
            secondValue.value = if (secondValue.value == "0") value else secondValue.value + value
        }
    }

    val buttons =
        listOf("1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "c", "0", "=", "/")
    Column {
        Text(
            text = "Calculator",
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        // Calculator Display
        Row(
            // Space evenly
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Text(
                text = firstValue.value,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = operator.value,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = secondValue.value,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "=",
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = result.value,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp)
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(buttons) { button: String -> CalculatorButton(button) { setter(button) } }
        }
    }
}

@Composable
fun CalculatorButton(button: String, param: () -> Unit) {
    Button(
        onClick = {
            param()
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

// Calculator functions
fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun divide(a: Int, b: Int): Float {
    if (b == 0) {
        return 0f
    }
    return a / b.toFloat()
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Preview() {
    CalculatorGrid()
}