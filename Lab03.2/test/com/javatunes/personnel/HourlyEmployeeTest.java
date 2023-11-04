package com.javatunes.personnel;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {
    private HourlyEmployee hrEmp;

    @Before
    public void init() {
        hrEmp = new HourlyEmployee("Jamie", Date.valueOf("1987-01-24"), 25.0, 30.0);
    }

    @Test
    public void testPay() {
        assertEquals(750.0, hrEmp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(200.0, hrEmp.payTaxes(), .001);
    }

}