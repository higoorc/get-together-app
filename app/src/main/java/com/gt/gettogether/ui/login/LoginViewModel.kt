package com.gt.gettogether.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.AuthUI
import com.gt.gettogether.R

class LoginViewModel() : ViewModel() {

    // Sign in with FirebaseUI, see docs for more details:
    // https://firebase.google.com/docs/auth/android/firebaseui
    fun createSignInUI(): Intent =
        AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setLogo(R.mipmap.ic_launcher)
            .setAvailableProviders(
                listOf(
                    AuthUI.IdpConfig.EmailBuilder().build(),
                    AuthUI.IdpConfig.GoogleBuilder().build(),
                )
            )
            .build()



}