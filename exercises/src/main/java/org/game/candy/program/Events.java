package org.game.candy.program;

import org.game.candy.program.candies.Milka;

public class Events {
    // TODO finish Event methods
    public long moneyStolen() {
        // replace 10 with current cash of the player
        return (long) (Math.random() * 10);
    }

    public Candy findRandomCandy() {
        // replace Milka with a random Candy object that can be any of the Candies
        return new Milka();
    }

    public Candy hungryForRandomCandy() {
        // random candy that will removed from players candyStash and a different mesage for each candy will appear
        return new Milka();
    }

    public int findBigBag() {
        // increase inventory size by 50, fixed size
        return 50;
    }

    public long luckyDay() {
        return 10_000L;
    }

    public void nothingHappens() {
        // do nothing later, console log not needed either!
        System.out.println("Nothing happened...");
    }
}
