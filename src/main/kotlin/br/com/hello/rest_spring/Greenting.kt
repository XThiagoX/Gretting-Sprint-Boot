package br.com.hello.rest_spring

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.RepresentationModel;

data class User(
    @JsonProperty("name") val name: String?,
    @JsonProperty("lastName") val lastName: String?
)

class Greeting @JsonCreator constructor(
    @JsonProperty("user") val user : User?
) : RepresentationModel<Greeting>()