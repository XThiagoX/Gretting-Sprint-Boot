package br.com.hello.rest_spring

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.RepresentationModel;

class Greeting @JsonCreator constructor(
    @JsonProperty("name") val name: String?,
    @JsonProperty("lastName") val lastName: String?
) : RepresentationModel<Greeting>()