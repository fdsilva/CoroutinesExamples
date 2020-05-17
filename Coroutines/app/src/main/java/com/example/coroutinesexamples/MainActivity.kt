package com.example.coroutinesexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val netwokCall = networkCall()
            withContext(Dispatchers.Main) {
                textView.text = netwokCall
                Log.d("DEBUG-TAG", "Hello from the other side ${Thread.currentThread().name}")
            }
            Log.d("DEBUG-TAG", "Coroutine say Hello from ${Thread.currentThread().name}")
        }
    }

    suspend fun networkCall() : String {
        delay(3000)
        return "[{result:}]"
    }
}
