package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // fixture objects under test
    private SalariedEmployee salEmp;
    private SalariedEmployee salEmp2;

    @Before
    public void setUp() {
        salEmp = new SalariedEmployee("Logan", Date.valueOf("2020-02-06"), 1500.0);
        salEmp2 = new SalariedEmployee("Logan", Date.valueOf("2020-02-06"), 1500.0);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary(){
        salEmp.setName("Mary");
    }


   @Test
    public void equals_ShouldReturnFalse_sameName_differentHireDate_sameSalary() {
        salEmp2.setHireDate(Date.valueOf("2020-01-06"));
   }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_Different_Salary() {
        salEmp2.setSalary(1000.0);
        assertNotEquals(salEmp,salEmp2);
        assertFalse(salEmp.equals(salEmp2));
    }

    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame() {
        assertEquals(salEmp,salEmp2);   // does an equals check
        assertTrue(salEmp.equals(salEmp2));
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, salEmp.pay(), .001);       //expected value: salary
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, salEmp.payTaxes(), .001);     //expected value: salary (Non employee compensation 1099)
    }
}