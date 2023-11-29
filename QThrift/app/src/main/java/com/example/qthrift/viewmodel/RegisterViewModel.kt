package com.example.qthrift.viewmodel

import androidx.lifecycle.ViewModel
import com.example.qthrift.data.User
import com.example.qthrift.util.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel // to use dagger hilt, function is to inject dependencies into your classes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): ViewModel() {

    private  val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Loading())
    val register: Flow<Resource<FirebaseUser>> = _register

    //for registration
    fun createAccountWithEmailAndPassword(user: User,password: String){
        firebaseAuth.createUserWithEmailAndPassword(user.email, password) //to create new account with firebase
            //this v will get executed only if the registration was successes
            .addOnSuccessListener {
                it.user?.let {
                    _register.value = Resource.Success(it)
                }
            }.addOnFailureListener { //this will get executed when something wrong is happened
                _register.value = Resource.Error(it.message.toString())
            }
    }

}