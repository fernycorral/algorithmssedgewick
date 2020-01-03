package cap2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class DataAbstraction {

    public static void point2DClient(int totalPoints){

        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < totalPoints ; i++) {
            double x = StdRandom.uniform(0.0,1.0);
            System.out.println(x);
            double y = StdRandom.uniform(0.0,1.0);
            Point2D point = new Point2D(x,y);
            point.draw();
            points.add(point);
        }

        double closestPairDistance = points.get(0).distanceTo(points.get(1));
        for (int i = 0; i < points.size()-1; i++) {
            double currentDistance = points.get(i).distanceTo(points.get(i+1));
            if(currentDistance < closestPairDistance                           )
                closestPairDistance = currentDistance;
        }

        System.out.println("Closest Distance = "+ closestPairDistance);
    }


    public static int[] readAllInts(String string){
        String[] words = string.split("\\s+");
        int[] res = new int[words.length];
        for (int i = 0;i < words.length;i++) {
            res[i] = Integer.parseInt(words[i]);
        }
        return res;
    }

    public static void testRational(){
        Rational firstRAddition = new Rational(5,8);
        System.out.println(firstRAddition);
        Rational secondRAddition = new Rational(7,12);
        System.out.println(secondRAddition);
        System.out.println(firstRAddition.plus(secondRAddition));

        Rational firstRSubstraction = new Rational(2,3);
        System.out.println(firstRSubstraction);
        Rational secondRSubstraction = new Rational(1,4);
        System.out.println(secondRSubstraction);
        System.out.println(firstRSubstraction.minus(secondRSubstraction));

        Rational firstRProduct = new Rational(4,9);
        System.out.println(firstRProduct);
        Rational secondRProduct = new Rational(3,4);
        System.out.println(secondRProduct);
        System.out.println(firstRProduct.times(secondRProduct));

        Rational firstRDiv = new Rational(9,16);
        System.out.println(firstRDiv);
        Rational secondRDiv = new Rational(5,8);
        System.out.println(secondRDiv);
        System.out.println(firstRDiv.dividedBy(secondRDiv));

    }

    public static void testingAccumulator(){
        Accumulator accumulator = new Accumulator();
        accumulator.addDataValue( 10);
        accumulator.addDataValue( 15);
        accumulator.addDataValue( 20);
        System.out.println(accumulator.mean());
        System.out.println(accumulator.var());
        System.out.println(accumulator.stddev());

    }


    public static void main(String[] args) {
        //point2DClient(10);
        //readAllInts("12 8  9 8 99 8");
        //testRational();
        testingAccumulator();

    }
}
