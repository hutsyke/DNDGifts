package com.hutsy.core.domain.util

typealias EmptyResult = Result<Unit, Error>

sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>

    data class Error<out E : com.hutsy.core.domain.util.Error>(val error: E) : Result<Nothing, E>
}

fun <D, E : Error, R> Result<D, E>.map(func: (D) -> R): Result<R, E> {
    return when (this) {
        is Result.Success -> Result.Success(func(data))
        is Result.Error -> Result.Error(error)
    }
}

fun <D, E : Error> Result<D, E>.asEmptyResult(): EmptyResult {
    return map { }
}

fun <D, E : Error> Result<D, E>.onSuccess(func: (D) -> Unit) {
    if (this is Result.Success) {
        func(data)
    }
}

fun <D, E : Error> Result<D, E>.onError(func: (E) -> Unit) {
    if (this is Result.Error) {
        func(error)
    }
}