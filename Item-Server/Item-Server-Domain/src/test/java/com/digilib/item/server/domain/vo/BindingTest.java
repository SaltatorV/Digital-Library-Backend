package com.digilib.item.server.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BindingTest {

    @Test
    public void shouldReturnValidName() {
        //given
        var binding = Binding.SOFTCOVER;

        //when
        var name = binding.getType();

        //then
        assertEquals("Softcover", name);
    }

    @Test
    public void shouldCreateBindingFrom() {
        //given
        var name = "softcover";

        //when
        var binding = Binding.createFrom(name);

        //then
        assertEquals(Binding.SOFTCOVER, binding);
    }
}
