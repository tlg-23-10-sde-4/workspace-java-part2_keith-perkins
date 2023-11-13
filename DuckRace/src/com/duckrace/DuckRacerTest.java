package com.duckrace;

import java.util.Collection;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(14, "Scott");
        System.out.println(racer);

        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT_CARD);

        // to show the read only view to the underlying collection
        Collection<Reward> rewards = racer.getRewards();

        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);

    }
}