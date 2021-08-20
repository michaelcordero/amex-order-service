package amex.unit

import amex.model.Receipt
import org.junit.Test
import kotlin.test.assertEquals

class MathTest {
    @Test
    fun testTotalSimpleOfferForApples() {
        val receipt = Receipt(5,0)
        val expected: Double = (5 / 2) * 0.60
        val actual: Double = receipt.total()
        assertEquals(expected, actual)
    }

    @Test
    fun testTotalSimpleOfferForOranges() {
        val receipt = Receipt(0, 10)
        val expected: Double = 0 + ((((10 /3) * 2) + 10 % 3) * 0.25)
        val actual: Double = receipt.total()
        assertEquals(expected, actual)
    }

}
