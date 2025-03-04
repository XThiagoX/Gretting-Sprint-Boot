package br.com.hello.rest_spring.exceptions

import java.util.Date

class ExceptionResponse (
    val timeStemp : Date,
    val message : String?,
    val details : String
)