package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
Television tv = new Television();
    @Before
    public void setUp() {
        tv = new Television();
    }


    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv.setVolume(101);  // should trigger the exceptino
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);       // should trigger the exception
        }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_WhenValid_lowerBound() {    // check on the boundaries and just outside of it
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());

    }

    @Test(expected=InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_wheninValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(0);    // this should trigger the exception
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay(){
    tv.setBrand("Sony");
    assertFalse(tv);
    }

    @Test
    public void compareTo() {
        (tv.getBrand(), other.getBrand())
    }



}