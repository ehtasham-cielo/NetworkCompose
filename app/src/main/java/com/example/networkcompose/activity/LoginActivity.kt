package com.example.networkcompose.activity

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.cielonetwork.data.model.LoginRequest
import com.example.networkcompose.compose.ProgressDialog
import com.example.cielonetwork.network.ApiInterface
import com.example.cielonetwork.repository.ApiRepository
import com.example.cielonetwork.utils.NetworkState
import com.example.networkcompose.ui.theme.NetworkComposeTheme
import com.example.networkcompose.utils.showToast
import com.example.networkcompose.vm.LoginViewModel
import com.example.networkcompose.vm.LoginViewModelFactory

class LoginActivity : ComponentActivity() {

    private lateinit var viewModel: LoginViewModel
    private val networkState by lazy { NetworkState(this.application) }
    private val apiInterface by lazy { ApiInterface.Instance }
    private val apiRepository by lazy { ApiRepository( apiInterface ) }
    private val viewModelFactory by lazy { LoginViewModelFactory(apiRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[LoginViewModel::class.java]
        listeners()
        setContent {
            NetworkComposeTheme {
                if (viewModel.progressDialogVisibility) {
                    ProgressDialog { viewModel.progressDialogVisibility = it }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextField(
                            value = viewModel.email,
                            onValueChange = { viewModel.email = it },
                            label = {
                                Text(text = "Enter Email")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        TextField(
                            value = viewModel.password,
                            onValueChange = { viewModel.password = it},
                            label = {
                                Text(text = "Enter Password")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = PasswordVisualTransformation()
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = {
                                if(!validation())
                                    return@Button
                                val user = LoginRequest.User(
                                    userId = viewModel.email,
                                    password = viewModel.password,
                                    mobileDeviceId = "8f5d0fc27a906dd5",
                                    deviceTokenId = "",
                                    appType = "Android",
                                    appVersion = "1.0",
                                    timeZone = "123",
                                    mobileDeviceName = "Samsung",
                                    deviceType = "ISO",
                                    ipAddress = "23232",
                                )
                                val loginRequest = LoginRequest(
                                    user
                                )
                                if(viewModel.isNetworkAvailable) {
                                    viewModel.progressDialogVisibility = true
                                    viewModel.login(loginRequest)
                                        .observe(this@LoginActivity) { response ->
                                            viewModel.progressDialogVisibility = false
                                            when (response) {
                                                is com.example.cielonetwork.utils.Resource.Success -> {
                                                    response.data?.message?.let { showToast(it) }
                                                }
                                                is com.example.cielonetwork.utils.Resource.Error -> {
                                                    response.message?.let { showToast(it) }
                                                }
                                            }
                                        }
                                }else{
                                    showToast("No Active Internet Connection")
                                }
                            }
                        ) {
                            Text(text = "Login")
                        }

                    }
                }
            }
        }
    }

    private fun listeners() {
        viewModel.apply {
            networkState.observe(this@LoginActivity){ isNetworkAvailable = it }
        }
    }


    private fun validation(): Boolean{
        viewModel.apply {
            if(email.isEmpty()){
                showToast("Email is required")
                return false
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                showToast("Invalid Email")
                return false
            }
            if(password.isEmpty()){
                showToast("Password is required")
                return false
            }
            if(password.length < 7){
                showToast("Password must contain at least 8 Characters")
                return false
            }
        }
       return true
    }
}
