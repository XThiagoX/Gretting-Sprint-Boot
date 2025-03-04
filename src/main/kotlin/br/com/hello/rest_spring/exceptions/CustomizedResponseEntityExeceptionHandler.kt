package br.com.hello.rest_spring.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.*
import java.util.Date
import kotlin.Exception

@ControllerAdvice
@RestController
class CustomizedResponseEntityExeceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions( ex : Exception, resquest : WebRequest):
            ResponseEntity<ExceptionResponse> {
        val execeptionResponse = ExceptionResponse (
            Date(),
            ex.message,
            resquest.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(execeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}