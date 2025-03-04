package br.com.hello.rest_spring

import org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    companion object {
        private const val template: String = "hello, %s!"
    }

    private val counter = AtomicLong()

    @GetMapping( value = ["/greeting/{name}/{lastName}"])
    fun greeting(
        @PathVariable(value = "name") name: String?,
        @PathVariable(value = "lastName") lastName: String?
    ): HttpEntity<Greeting> {

        var user = User(name, lastName)
        val greeting = Greeting(user)

        val controllerMethod = methodOn(GreetingController::class.java).greeting(name, lastName)
        greeting.add(linkTo<GreetingController> { }.withSelfRel())

        return ResponseEntity(greeting, HttpStatus.OK)
    }

}