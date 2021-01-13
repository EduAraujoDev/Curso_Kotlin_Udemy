package exercises

import org.junit.Assert
import org.junit.Test

class ReverseStringTest {

    @Test
    fun reverseUseSB() {
        Assert.assertEquals("bs niltok", reverseUsingSB("kotlin sb"))
    }

    @Test
    fun reverseUseLoop() {
        Assert.assertEquals("pool niltok", reverseUsingLoop("kotlin loop"))
    }
}