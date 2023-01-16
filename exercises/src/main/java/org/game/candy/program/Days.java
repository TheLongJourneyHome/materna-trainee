package org.game.candy.program;

public class Days {
    private static final int MAX_DAYS = 30;
    private int currentDays = 0;
    private int daysLeft = MAX_DAYS - currentDays;


    public int getMaxTimeLimit() {
        return MAX_DAYS;
    }

    // after a day passes, call bank methods to update savings / loan
    public void oneDayPassed() {
        currentDays++;
        updateWithInterest();
    }

    public int getTimeLeft() {
        daysLeft = MAX_DAYS - currentDays;
        return daysLeft;
    }

    // call bank method to update interest later
    public void updateWithInterest() {
        Bank bankObject = new Bank();
        bankObject.increaseSavings();
        bankObject.increaseLoan();
    }

    public void endGame() {
        // TODO end the game and calc the final score of players debt and savings
        // debt and loan of player and bank synchronizes!... actually only bank value needed!
        // call the general function method in the end, after player presses a button, to quit the game!

    }
}
