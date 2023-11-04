package com.duckrace;

import java.util.Collection;

public class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(14, "Scott");
        System.out.println(racer);      //toString() auto called

        // make it "win" a few times
        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT);
        racer.win(Reward.PRIZES);
        racer.win(Reward.PRIZES);

        // we can "cheat" here, and get more rewards without actually winning
        racer.win(Reward.PRIZES);
        racer.win(Reward.PRIZES);
        System.out.println(racer);

        // to show the read only view to the underlying solution
        Collection<Reward> rewards = racer.getRewards();
        System.out.println(rewards);        //should see 4


        //two more honest wins, this updates the DuckRacer's rewards collection to now 6
        racer.win(Reward.PRIZES);
        racer.win(Reward.PRIZES);

        System.out.println(rewards);    // this will show 6

    }
}
