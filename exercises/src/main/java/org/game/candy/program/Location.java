package org.game.candy.program;

public abstract class Location {
    private static final String POSITION_IN_EU = "eu";
    private static final String POSITION_IN_AMERICA = "america";
    private static final String POSITION_IN_ASIA = "asia";

    private String locationName;
    private String position;
    private int travelPrice;
    protected boolean hasBank = false;


    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setPosition(String position) {
        if (position.equalsIgnoreCase(POSITION_IN_EU) || position.equalsIgnoreCase(POSITION_IN_ASIA) || position.equalsIgnoreCase(POSITION_IN_AMERICA)) {
            this.position = position.toLowerCase();
        } else {
            System.out.println("Enter a valid position [eu, asia, america]");
        }
    }

    public String getPosition() {
        return position;
    }

    public void setTravelPrice(int travelPrice) {
        this.travelPrice = travelPrice;
    }

    public int getTravelPrice() {
        return travelPrice;
    }

    public String getDistance(String position1, String position2) {
        String result;
        // when the position is the same
        if (position1.equalsIgnoreCase(position2)) {
            result = "close";
        } else if (position1.equalsIgnoreCase(POSITION_IN_EU)) {
            switch (position2.toLowerCase()) {
                case POSITION_IN_ASIA -> result = "eu to asia";
                case POSITION_IN_AMERICA -> result = "eu to america";
                default -> result = "";
            }
        } else if (position1.equalsIgnoreCase(POSITION_IN_AMERICA)) {
            switch (position2.toLowerCase()) {
                case POSITION_IN_ASIA -> result = "america to asia";
                case POSITION_IN_EU -> result = "america to eu";
                default -> result = "";
            }
        } else {
//            position1.equalsIgnoreCase(POSITION_IN_AMERICA)
            switch (position2.toLowerCase()) {
                case POSITION_IN_AMERICA -> result = "asia to america";
                case POSITION_IN_EU -> result = "asia to eu";
                default -> result = "";
            }
        }

        // TODO create a table with prices for the distance: close (eu to eu), eu to asia (very far), eu to america (far), america to asia (far)
        return result;
    }

    public boolean hasBank() {
        return hasBank;
    }

/*    public void setBank() {
        System.out.println("You can find your bank only in Germany");
    }*/
}
