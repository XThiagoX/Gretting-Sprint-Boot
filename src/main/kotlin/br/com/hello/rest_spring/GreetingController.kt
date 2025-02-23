package br.com.hello.rest_spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    companion object {
        private const val template : String = "hello, %s!"
    }
    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam( value = "thiago", defaultValue = "Word") value: String ): Greenting{
        return Greenting(counter.incrementAndGet(), template.format(value))
    }
}