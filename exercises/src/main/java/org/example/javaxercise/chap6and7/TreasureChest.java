package org.example.javaxercise.chap6and7;

// Fabrikmethoden / factory pattern - 6.5.7 Wither Methods!!!
// private constructor
// 1.4.3
public class TreasureChest {
    public final int goldDoubloonWeight;
    public final int gemstoneWeight;


    // Setter
    private TreasureChest( int goldDoubloonWeight, int gemstoneWeight ) {
        if ( goldDoubloonWeight < 0 || gemstoneWeight < 0 )
            throw new IllegalArgumentException( "Weight can't be negative" );
        this.goldDoubloonWeight = goldDoubloonWeight;
        this.gemstoneWeight     = gemstoneWeight;
    }

    public static TreasureChest newInstance() {
        return new TreasureChest( 0, 0 );
    }

    public static TreasureChest newInstanceWithGoldDoubloonWeight( int weight ) {
        return new TreasureChest( weight, 0 );
    }

    public static TreasureChest newInstanceWithGemstonesWeight( int weight ) {
        return new TreasureChest( 0, weight );
    }

    public static TreasureChest newInstanceWithGoldDoubloonAndGemstonesWeight(
            int goldDoubloonWeight, int gemstonesWeight ) {
        return new TreasureChest( goldDoubloonWeight, gemstonesWeight );
    }
    // Wo wäre hier das Problem mit einem üblichen Konstruktor?
        // To change state variables, you can generally use wither methods .These methods are similar to setters, except that they don’t changeany state of the current object but instead result in a new object withthe changed state
        // normal constructor would change the values for every object of type TreasureChest instead of creating new ones
}
