package com.javatunes.billing;

public class TaxCalculatorFactory {

    //prevent instantiation from outside, this is an all static class.

    private TaxCalculatorFactory() {
    }


    /*
     *TODO:  Consider implementing a "cache" of TaxCalculator objects.
     *
     * Consider implementing a "cache" of TaxCalculator objects
     *
     * If I have not previously created the object (e.g. USAtax), then
     * I'll create it here (with "new"), add it to my cache, and then return it
     *
     * However, if my cache already contains it, then I just fetch it
     * from the cache and return it - no need to create another one
     *
     * HINT:  you could use a simple Map<Location, TGaxCalculator> for the cache.
     * It would be a 3-row Map, each row has Location | TaxCalculator
     */


    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}
