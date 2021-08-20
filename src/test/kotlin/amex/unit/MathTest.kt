package amex.unit

import amex.model.Receipt
import org.junit.Test
import kotlin.test.assertEquals

class MathTest {
    @Test
    fun testOriginalTotal() {
        val receipt = Receipt(5, 2)
        val expected: Double = (5 * 0.60) + (2* 0.25)
        val actual: Double = receipt.total()
        assertEquals(expected, actual)
    }

    @Test
    fun testTotalWithZeros() {
        val receipt = Receipt(0, 0)
        val expected: Double = (0 * 0.60) + (0* 0.25)
        val actual: Double = receipt.total()
        assertEquals(expected, actual)
    }

    @Test
    fun testTotalWithOneZero() {
        val receipt = Receipt(5, 0)
        val expected: Double = (5 * 0.60) + (0* 0.25)
        val actual: Double = receipt.total()
        assertEquals(expected, actual)
    }
}
