package amex.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Orange @JsonCreator constructor(
    @JsonProperty(value = "oranges", required = true)
    val number: Int)
