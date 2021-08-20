package amex.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class Receipt @JsonCreator constructor(
    @JsonProperty(value = "apples", required = false)
    val apples: Int?,
    @JsonProperty(value = "oranges", required = false)
    val oranges: Int?) : Serializable {
    fun total(): Double {
        val applesCost: Double = apples?.times(0.60) ?: 0.0
        val orangesCost: Double = oranges?.times(0.25) ?: 0.0
        return applesCost + orangesCost
    }

    // This may not be necessary because of toString()
    fun summary(): String {
        return "============== Order Summary========== \n\n Apples: ${apples ?: 0} \n\n Oranges: ${oranges ?: 0} \n\n Total: $${total()} \n" +
                "======================================"
    }

    override fun toString(): String {
        return "Receipt(apples=$apples, oranges=$oranges)"
    }
}
