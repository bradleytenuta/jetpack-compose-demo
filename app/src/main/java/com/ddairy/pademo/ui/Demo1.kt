package com.ddairy.pademo.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.ddairy.pademo.ui.theme.PADemoTheme

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PADemoTheme {
        var count by remember { mutableStateOf(0) }
        ClickCounter(
            clicks = count,
            onClick = { count = count.inc() }
        )
    }
}