package org.nixan.splashscreenexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by nixan on 12.01.2018.
 */

private const val ACTIVITY_AUTH = 1000

abstract class SplashedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!isAuthenticated()) {
            startActivityForResult(Intent(this, AuthActivity::class.java), ACTIVITY_AUTH)
        }
        setTheme(R.style.AppTheme_Base)
        super.onCreate(savedInstanceState)
    }

    private fun isAuthenticated(): Boolean {
        return getUser() != null
    }

    private fun onAuthenticatedCallback(resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_CANCELED -> finish()
            Activity.RESULT_OK -> recreate()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            ACTIVITY_AUTH -> onAuthenticatedCallback(resultCode, data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}