package org.example;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.bean.TestEnum;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUnitMethod_isInput_0_0_Test {

    @Test
    public void givenInputString_whenIsInput_thenTrue() {
        // Given
        GeneratorUnitMethod generator = new GeneratorUnitMethod();
        String input = "input";
        // When
        Boolean result = generator.isInput(input);
        // Then
        assertTrue(result);
    }

    @Test
    public void givenNonInputString_whenIsInput_thenFalse() {
        // Given
        GeneratorUnitMethod generator = new GeneratorUnitMethod();
        String nonInput = "nonInput";
        // When
        Boolean result = generator.isInput(nonInput);
        // Then
        assertFalse(result);
    }
}
