package com.example.qthrift.data

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagePath: String = ""
){
    //empty constructor for firebase services
    constructor(): this("", "", "", "")
}
