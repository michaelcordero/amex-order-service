package amex.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Apple @JsonCreator constructor(
    @JsonProperty(value = "apples", required = true)
    val number: Int)
