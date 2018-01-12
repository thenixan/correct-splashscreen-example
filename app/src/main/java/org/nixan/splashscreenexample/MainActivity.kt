package org.nixan.splashscreenexample

import android.os.Bundle
import android.widget.TextView

class MainActivity : SplashedActivity() {

    private val helloText by lazy { findViewById<TextView>(R.id.helloText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUser()?.let {
            helloText.text = "Hello, ${it.login}"
        }
    }
}
