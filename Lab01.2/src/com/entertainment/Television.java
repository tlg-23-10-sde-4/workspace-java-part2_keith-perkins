package com.entertainment;

import java.util.Objects;

/*
 *  to be "consistent with equals", whatever fields we use for equals() and hashcode(),
 *  we MUST use those same fields for that natural order.
 *
 *  That means we'll switch to a pmary sort key "brand", and when tied on "brand",
 *  we break the tie via secondary sort key 'volume'.
 */

public class Television implements Comparable <Television> {

    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();      // instantiated internally

    public Television() {
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();      // delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);      // delegate to contained Tuner object
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Television other) {
        return (this.getBrand().compareTo(other.getBrand()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;

        return volume == that.volume && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, volume);
    }

    //    @Override
//    public int hashCode() {
    /*
     * This is a poorly written hash function, because it easily yields "hash collisions."
     * A hash collision is when "different" objects have the same hash code (just by coincidence).
     * Given our poor initial has function below, "Sony" 50 and "LG" 52 both have hash codes
     * of 54, as does "Samsung" 47. These are "different" objects per the equals() method, but have
     * the same has code.
     */
    // return getBrand().length() + getVolume();
    // Instead, we rely on Objects.hash() to give us a "scientifically correct" has function.
//        return Objects.hash(getBrand(), getVolume());
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        boolean result = false;
//
//        // proceed only if 'obj' is really referencing a Television object
//        if (obj instanceof Television) {
//            // safely downcast 'obj' to more specific reference Television
//            Television other = (Television) obj;
//
//            // do the checks: business equality is defined by brand, volume being the same
//            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
//                    this.getVolume() == other.getVolume();
//        }
//        return result;
//    }

    @Override
    public int compareTo (Television other) {
            int result = this.getBrand().compareTo(other.getBrand());

            if (result ==0) { //tied on brand, i.e. they have the same brand
                result = Integer.compare(this.getVolume(), other.getVolume());
            }
            return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() +
                ", currentChannel=" + getCurrentChannel() + "]";
    }
}