package com.smartfuturelabs.emv

import com.smartfuturelabs.emvcore.BasicDataObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class BasicDataObjectTest {

    @ParameterizedTest
    @MethodSource("stringProvider")
    fun testFormat(
        id: String,
        value: String,
        expectedCode: String,
    ) {
        val basicDataObject = BasicDataObject(id, value)
        assertEquals(expectedCode, basicDataObject.generateCode())
    }

    companion object {
        @JvmStatic
        fun stringProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("00", "a", "0001a"),
                Arguments.of("00", "12", "000212"),
                Arguments.of("00", "1234567890", "00101234567890"),
                Arguments.of("00", "123456789012", "0012123456789012"),
            )
        }
    }
}
