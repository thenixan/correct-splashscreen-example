package org.nixan.splashscreenexample

import android.animation.Animator
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.EditText

class AuthActivity : AppCompatActivity() {

    private val authCardView by lazy { findViewById<CardView>(R.id.authCardView) }
    private val okButton by lazy { findViewById<Button>(R.id.okButton) }
    private val cancelButton by lazy { findViewById<Button>(R.id.cancelButton) }
    private val loginEditText by lazy { findViewById<EditText>(R.id.loginEditText) }
    private val passwordEditText by lazy { findViewById<EditText>(R.id.passwordEditText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        authCardView.animate()
                .setDuration(500L)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .alpha(1F)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                    override fun onAnimationStart(p0: Animator?) {
                        authCardView.alpha = 0F
                        authCardView.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        authCardView.visibility = View.VISIBLE
                    }

                })

        okButton.setOnClickListener {
            performInputChecksAndSaveUser { login, password ->
                saveUser(User(login, password))
                setResult(Activity.RESULT_OK)
                finish()
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun performInputChecksAndSaveUser(successCallback: (String, String) -> Unit) {
        if (loginEditText.text.isBlank()) {
            loginEditText.error = getText(R.string.errorEmptyLogin)
        }
        if (passwordEditText.text.isBlank()) {
            passwordEditText.error = getText(R.string.errorEmptyPassword)
        }
        if (loginEditText.text.isNotBlank() && passwordEditText.text.isNotBlank()) {
            successCallback.invoke(loginEditText.text.toString(), passwordEditText.text.toString())
        }
    }
}
