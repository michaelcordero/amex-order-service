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
        val num_of_apples: Int = apples ?: 0
        val num_of_oranges: Int = oranges ?: 0
        val remainder: Int = num_of_oranges % 3
        val applesCost: Double =  (num_of_apples / 2) * 0.60
        val orangesCost: Double = (((num_of_oranges / 3) * 2) + remainder) * 0.25
        return applesCost + orangesCost
    }

    // This was not necessary, but leaving in for readability.
    fun summary(id: Int?): String {
        return "\n============== Order Summary==========\n" +
                "Id: ${id} \n" +
                "Apples: ${apples ?: 0} \n" +
                "Oranges: ${oranges ?: 0} \n" +
                "Total: $${total()} \n" +
                "======================================\n"
    }
}
