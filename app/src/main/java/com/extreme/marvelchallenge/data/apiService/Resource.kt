package com.extreme.marvelchallenge.data.apiService

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 8:02 PM
 */
sealed class Resource<T>(
    val status: Status,
    val data: T? = null,
    val error: Error? = null
) {

    class Success<T>(data: T) : Resource<T>(status = Status.SUCCESS, data = data)
    class Loading<T> : Resource<T>(status = Status.LOADING)
    class Failure<T>(error: Error) : Resource<T>(status = Status.ERROR, error = error)
    class Complete<T> : Resource<T>(status = Status.COMPLETE)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Failure[error=${error}]"
            is Loading<T> -> "Loading"
            is Complete<T> -> "Complete"
        }
    }
}

