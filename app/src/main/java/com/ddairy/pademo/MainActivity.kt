package com.ddairy.pademo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ddairy.pademo.ui.ClickCounter
import com.ddairy.pademo.ui.theme.PADemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PADemoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    var count by remember { mutableStateOf(0) }
                    ClickCounter(
                        clicks = count,
                        onClick = { count = count.inc() }
                    )
                }
            }
        }
    }
}