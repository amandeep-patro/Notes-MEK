package com.adp.mongoexpressnotes.common.util

sealed class Resource<T> (
    message: String ? = "",
    data : T ? = null
){
    
    class Loading<T> : Resource<T>()
    class Success<T>(val data: T) : Resource<T>(data = data)
    class Error<T>(val message: String) : Resource<T>(message = message)
}