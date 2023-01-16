package org.game.candy.program;

public class Bank {
    private long money = 0;
    private long loan = 0;
    private double interestSavings = 1.05;
    private double interestLoan = 1.10;
    private Candy[] candyStash;


/*    public void setMoney(long money) {
        this.money = money;
    }*/

    // TODO to read the values and display on the UI
    public long getMoney() {
        return money;
    }

/*    public void setLoan(long loan) {
        this.loan = loan;
    }*/

    public long getLoan() {
        return loan;
    }

    public void increaseSavings() {
        money = (long) (money * interestSavings);
    }

    public void increaseLoan() {
        loan = (long) (loan * interestLoan);
    }

    public void depositMoney(long money) {
        if (money > 0) {
            this.money += money;
        } else {
            System.out.println("Hey if you have no money to deposit, then come back later!");
        }
    }

    public long withdrawMoney(long money) {
        if (money <= this.money) {
            this.money -= money;
            return money;
        } else {
            System.out.println("There is not enough money in your account!");
            return 0L;
        }
    }

    public long loanMoney(long money) {
        if (loan == 0) {
            // TODO here: can only withdraw if there is no debt and can only withdraw max 2 digit more!
            System.out.printf("Sure you can borrow %d € %n", money);
            loan = money;
            return money;
        } else {
            System.out.println("You didn't fully pay off your last debts yet, you can't borrow more");
            return 0;
        }
    }

    public void payOffLoan(long money) {
        // when player pays back more than needed
        if ( loan - money < 0) {
            getExcessBack(Math.abs(loan - money));
            loan = 0;
        } else {
            loan -= money;
        }
    }

    // new method not-in-uml
    public long getExcessBack(long excess) {
        // TODO give the player some money back -> create player object?
        System.out.printf("You paid too much, here you get %d € back. %n", excess);
        return excess;
    }
}
