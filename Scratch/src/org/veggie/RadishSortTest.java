package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //  color, size tailLength, guysOnTop
        radishes.add(new Radish("red", 2.1, 1.0, 0));
        radishes.add(new Radish("black", 1.0, 0.0, 3));
        radishes.add(new Radish("red", 2.5, 4.2, 0));
        radishes.add(new Radish("pink", 0.7, 3.2, 0));

        //  original order
        dump(radishes);
        System.out.println();

        //  natural order
        System.out.println("natural order (size)");
        radishes.sort(null);  // passing "null" means to do it by natural order
        dump(radishes);
        System.out.println();

        System.out.println("sort by color, via anonymous Comparator <Radish>");
        //radishes.sort(new RadishColorComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("guysOnTop, via RadishGuysOnTopComparator");
        // radishes.sort(new RadishGuysOnTopComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getGuysOnTop(),r2.getGuysOnTop());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("sort by tailLength, via anonymous class");
        radishes.sort(new Comparator<Radish>() {

            @Override
            public int compare(Radish r1, Radish r2) {
                return Double.compare(r1.getTailLength(),r2.getTailLength());
            }
        });
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes){
            System.out.println(radish);             //toString() auto called
        }
    }
}