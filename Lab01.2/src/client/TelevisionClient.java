package client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {

    public static void main(String[] args) {


        // show behavior of == versus equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        // use == to show if tvA and tvB refer to same physical object
        System.out.println("tvA == tvB: " + (tvA == tvB));  // obviously false

        // use equals() to show if tvA and tvB are "equal" (details later)
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));  // this is now true
        System.out.println();

//        System.out.println(tvA.hashCode()); // 80069516
//        System.out.println(tvB.hashCode()); // 80069516
//        System.out.println();

        Set<Television> tvs = new TreeSet<>();     // change HashSet to TreeSet
        tvs.add(tvA);
        tvs.add(tvB);   // should be rejected as a duplicate
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set is: " + tvs.size());
            for (Television tv : tvs) {
                System.out.println(tv);
            }

    }

}