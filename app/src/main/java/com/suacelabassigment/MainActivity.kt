package com.suacelabassigment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import backtraceio.library.BacktraceClient
import backtraceio.library.BacktraceCredentials

class MainActivity : ComponentActivity() {

    external fun crashNative()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val backtraceCredentials = BacktraceCredentials("https://submit.backtrace.io/khyatichitroda/bf97bcd2ebae3dadba85c4c722130fa10f34246cc138fda87e67fdf9b4af6f39/json")
        val backtraceClient = BacktraceClient(applicationContext, backtraceCredentials)

        backtraceClient.send("Test crash")

        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        try {
                            Log.d("NativeCrash", "Triggering native crash")
                            crashNative()
                        }catch (e: Exception){
                            backtraceClient.send(e)

                        }

                    }
                ) {
                    Text("Crash App")
                }
            }
        }
    }

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}