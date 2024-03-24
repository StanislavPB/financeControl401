package org.financecontrol401.vtarlovsky.entity;

public class Balance {
   private Double Summa;

    public Balance(Double summa) {
        Summa = summa;
    }

    public Double getSumma() {
        return Summa;
    }

    public void setSumma(Double summa) {
        Summa = summa;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "Summa=" + Summa +
                '}';
    }
}
