package br.com.erudio.exceptions

import java.util.Date

class ExceptionResponse(
    val timeStamp: Date,
    val message: String? = "An internal error occurred",
    val details: String
)
