package org.nixan.splashscreenexample

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class ShareActivity : SplashedActivity() {

    private val helloText by lazy { findViewById<TextView>(R.id.helloText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUser()?.let {
            helloText.text = "${it.login}\n${intent.getStringExtra(Intent.EXTRA_TEXT)}"
        }
    }
}
