package org.game.candy.program;

public abstract class Candy implements Tradable {
    private static final String SUPER_RARE = "super rare";
    private static final String RARE = "rare";
    private static final String COMMON = "common";

    private String candyName;
    private int candyPrice;
    private int candyWeight = 1;
    // TODO private ? priceRange
    private CandyType candyType = CandyType.OTHER; // default value set
    private String candyPopularity;


    public void setCandyName(String name) {
        candyName = name;
    }

    public String getCandyName() {
        return candyName;
    }

    public int getCandyWeight() {
        return candyWeight;
    }

    public void setCandyType(CandyType type) {
        candyType = type;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyPopularity(String popularity) {
        // .equalsIgnoreCase better than .toLowerCase
        if (popularity.equalsIgnoreCase(SUPER_RARE) || popularity.equalsIgnoreCase(RARE) || popularity.equalsIgnoreCase(COMMON)) {
            candyPopularity = popularity.toLowerCase();
        } else {
            System.out.println("Please enter a correct popularity value [super rare, rare, common]");
        }
    }

/*    private void setCandyPrice() {
        // TODO use a price range method, depending on the location in and get the price of the popularity -> range -> random -> price
        candyPrice = switch (candyPopularity) {
            case SUPER_RARE -> 10;
            case RARE -> 5;
            case COMMON -> 0;
            default -> -1;
        };
    }
    public int getCandyPrice() {
        return candyPrice;
    }*/

    public void setPriceRange() {
        // TODO set and get price range for the candy to assign the candy price
    }

    // implement interface methods
    @Override
    public void setPrice() {
        candyPrice = switch (candyPopularity) {
            case SUPER_RARE -> 10;
            case RARE -> 5;
            case COMMON -> 0;
            default -> -1;
        };
    }

    @Override
    public int getPrice() {
        return candyPrice;
    }
}
