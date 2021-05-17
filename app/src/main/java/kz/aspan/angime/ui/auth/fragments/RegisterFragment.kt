package kz.aspan.angime.ui.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*
import kz.aspan.angime.R
import kz.aspan.angime.other.EventObserver
import kz.aspan.angime.ui.auth.AuthViewModel
import kz.aspan.angime.ui.snackbar

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToObservers()

        btnRegister.setOnClickListener {
            viewModel.register(
                etEmail.text.toString(),
                etUsername.text.toString(),
                etPassword.text.toString(),
                etRepeatPassword.text.toString()
            )
        }

        tvLogin.setOnClickListener {
            if (findNavController().previousBackStackEntry != null) {
                findNavController().popBackStack()
            } else findNavController().navigate(
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            )
        }
    }


    private fun subscribeToObservers() {
        viewModel.registerStatus.observe(
            viewLifecycleOwner, EventObserver(
                onError = {
                    registerProgressBar.isVisible = false
                    snackbar(it)
                },
                onLoading = { registerProgressBar.isVisible = true }
            ) {
                registerProgressBar.isVisible = false
                snackbar(getString(R.string.success_registration))
            }
        )
    }
}