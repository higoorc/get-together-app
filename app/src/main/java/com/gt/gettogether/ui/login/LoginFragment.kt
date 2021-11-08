package com.gt.gettogether.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.gt.gettogether.R
import com.gt.gettogether.databinding.LoginLayoutBinding
import timber.log.Timber

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()
    private lateinit var binding: LoginLayoutBinding

    private val signIn: ActivityResultLauncher<Intent> =
        registerForActivityResult(FirebaseAuthUIActivityResultContract(), this::onSignInResult)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_layout,
            container,
            false
        )

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        if (Firebase.auth.currentUser == null) {
            val signInIntent = viewModel.createSignInUI()
            signIn.launch(signInIntent)
        } else {
            navigateToMeetings()
        }
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            Timber.d( "Sign in successful!")
            navigateToMeetings()
        } else {
            displayErrorToast(result)
        }
    }

    private fun displayErrorToast(result: FirebaseAuthUIAuthenticationResult) {
        Toast.makeText(
            requireContext(),
            "There was an error signing in",
            Toast.LENGTH_LONG
        ).show()

        val response = result.idpResponse
        if (response == null) {
            Timber.w("Sign in canceled")
        } else {
            Timber.w("Sign in error ${response.error}")
        }
    }

    private fun navigateToMeetings() {
        val directions = LoginFragmentDirections.goToMeetings()
        findNavController().navigate(directions)
    }

}