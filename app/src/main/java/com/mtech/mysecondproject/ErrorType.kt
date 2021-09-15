package com.mtech.mysecondproject

enum class ErrorType {
    DIALOG,
    SNACKBAR
}

data class CommonError(val msg: String?, val errorType: ErrorType = ErrorType.SNACKBAR)