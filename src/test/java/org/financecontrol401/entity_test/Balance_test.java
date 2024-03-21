package org.financecontrol401.entity_test;

import org.financecontrol401.Entity.Balance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Balance_test {

    @Test
    public void testGetSumma() {
        Balance balance = new Balance(100.0);
        assertEquals(100.0, balance.getSumma());
    }

    @Test
    public void testSetSumma() {
        Balance balance = new Balance(100.0);
        balance.setSumma(200.0);
        assertEquals(200.0, balance.getSumma());
    }

    @Test
    public void testToString() {
        Balance balance = new Balance(150.0);
        assertEquals("Balance{Summa=150.0}", balance.toString());
    }
}
