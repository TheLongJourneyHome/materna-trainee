package org.game.candy.program;

public class Player {
    // change cash, debt money from int to long, because it can get quite big!
    private long cash = 2000L;
    private long debt = 0L;
    private int inventoryMax = 100;
    private int inventoryOccupied = 0;
    private int inventorySpaceLeft = inventoryMax - inventoryOccupied;
    private Location currentLocation;
    private Candy[] candyStash;


    private int getNumberOfItems() {
        int counter = 0;
        // TODO count the item number for each candy
        for (Candy candy : candyStash) {
            counter++;
        }
        return counter;
    }

    public void travel(Location location) {
        // TODO get the Price of the location
        // location.getPrice(currentLocation, location)
        // pay off the price for going to the location
        long price = 0; // change later
        if (price > cash) {
            System.out.println("Too bad you don't have enough money to travel, go earn some money!");
        } else {
            // travel to the given location
            setCurrentLocation(location);
        }
    }

    public void buyCandy(Candy candy) {
        // if candy.price > cash -> can't buy it
        // add it to candyStash
        // but check if inventory is big enough first
    }

    public void sellCandy(Candy candy) {

    }

    public void visitBank() {
        // if location.hasBanktrue -> show this option, else you can't go to the bank...
    }


    // Getter and Setters
    public long getCash() {
        return cash;
    }

    public void setCash(long money) {
        // earn cash
        this.cash += money;
    }

    public long getLoan() {
        return debt;
    }

    public void setLoan(long money) {
        // pay off debt
        this.debt -= money;
    }

    public int getInventoryMax() {
        return inventoryMax;
    }

    public void setInventoryMax(int inventoryMax) {
        this.inventoryMax += inventoryMax;
    }

    public int getInventoryOccupied() {
        return inventoryOccupied;
    }

    public void setInventoryOccupied(int numberOfItems) {
        if (getInventoryMax() >= getNumberOfItems()) {
            this.inventoryOccupied = numberOfItems;
        } else {
            System.out.println("You don't have enough space left in your inventory.");
        }
    }

    public int getInventorySpaceLeft() {
        return inventorySpaceLeft;
    }

    // get the amount of space left in the inventory
    public void setInventorySpaceLeft() {
        this.inventorySpaceLeft = inventoryMax - getInventoryOccupied();
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Candy[] getCandyStash() {
        return candyStash;
    }

    public void setCandyStash(Candy[] candyStash) {
        this.candyStash = candyStash;
    }
}
