package com.stego.saw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stego.saw.ui.theme.HtbsawTheme
import java.io.File

class MainActivity : ComponentActivity() {

    external fun a(str: String?, str2: String?): String?

    companion object {
        init {
            System.loadLibrary("default")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HtbsawTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ttest(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Ttest(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var result by remember { mutableStateOf("Waiting for result...") }
    var fleg by remember { mutableStateOf("Waiting for fleg") }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            result = MainActivity().a(context.applicationInfo.dataDir + File.separator,"fl0ating").toString()
            val file = File(context.applicationInfo.dataDir + File.separator+"h")
            fleg = if (file.exists()) file.readText() else "File not found"

        }) { Text(text="test") }
        Text(text = result)
        Text(text = fleg)
    }

}
