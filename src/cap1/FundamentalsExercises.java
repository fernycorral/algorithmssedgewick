package cap1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FundamentalsExercises {

    public void first(){
        System.out.println("****** first exercise ******");
        System.out.println((0+15)/2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true  && false || true && true);
    }

    public void second(){
        System.out.println("****** second exercise ******");
        System.out.print("Result is int: " );
        System.out.println((1 + 2.236) / 2);
        System.out.print("Result is int: " );
        System.out.println(1 + 2+ 3+ 4.0);
        System.out.print("Result is true: " );
        System.out.println(4.1 >= 4);
        System.out.print("Result is 33: " );
        System.out.println(1 +2 + "3");
    }

    public void third(){
        System.out.println("****** third exercise ******");
        System.out.println("Write First Number");
        int firstN = StdIn.readInt();
        System.out.println("Write Second Number");
        int secondN = StdIn.readInt();
        System.out.println("Write Third Number");
        int thirdN = StdIn.readInt();

        if(firstN == secondN && firstN == thirdN)
            System.out.println("equal");
        else
            System.out.println("Not Equal");
    }

    public void fourth(){
        System.out.println("****** Fourth exercise ******");
        System.out.println("Letter a wont compile");
        System.out.println("letter b wont compile");
        System.out.println("Letter c will compile");
        System.out.println("Letter d will compile");

    }

    public void fifth(double x, double y){
        System.out.println("****** fifth exercise ******");
        if(x > 0 && x <1) {
            if (y > 0 && y < 1)
                System.out.println(true);
        }else
            System.out.println(false);
    }

    public void sixth(){
        System.out.println("****** sixth exercise ******");
        int f = 0;
        int g = 1;

        for (int i = 0; i < 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public void seventh(){
        System.out.println("****** seventh exercise ******");
        double t = 9.0;
        while(Math.abs(t - 9.0 / t) > .001){
            t = (9.0/t + t)/2.0;
        }
        System.out.printf("%.5f\n",t);
         int sum = 0;
        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);

        sum = 0;
        for (int i = 1; i < 1000 ; i*=2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public void eight(){
        System.out.println("****** eight exercise ******");
        System.out.println('a');
        System.out.println('a' + 'b');
        System.out.println((char)('a' + 4));
    }

    public void nineth(int N){
        System.out.println("****** nineth exercise ******");
        String binaryRepresentation = Integer.toBinaryString(N);
        System.out.println(binaryRepresentation);

        binaryRepresentation = "";
        for (int i = N; i > 0 ; i/=2) {
            binaryRepresentation = i%2 + binaryRepresentation;
        }
        System.out.println(binaryRepresentation);
    }

    public void tenth(){
        System.out.println("****** 10 exercise ******");
        boolean[][] myArr = new boolean[2][2];
        myArr[0][0] = true;
        myArr[0][1] = true;
        myArr[1][1] = true;
        myArr[1][0] = true;

        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                StdOut.println((myArr[i][j]? "*":"_") + "row: " + i + " column: " + j);
            }

        }

    }

    public void twelve(){
        System.out.println("****** 12 exercise ******");

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    public void thirteen(){
        System.out.println("****** 13 exercise ******");
        int[][] myArr = new int [2][3];
        myArr[0][0] = 1;
        myArr[0][1] = 2;
        myArr[0][2] = 3;
        myArr[1][0] = 4;
        myArr[1][1] = 5;
        myArr[1][2] = 6;


        int[][] arrayTransposition = new int[myArr[0].length][myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                arrayTransposition[j][i] = myArr[i][j];
            }
        }

        System.out.println("Transposition is : ");
        for (int i = 0; i < arrayTransposition.length; i++) {
            for (int j = 0; j < arrayTransposition[i].length; j++) {
                System.out.print(arrayTransposition[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void lg(int number){

    }

    public static int[] histogram(int[] myArr, int m){
        System.out.println("****** 15 Histogram exercise ******");
        int[] resArray = new int[m];
        for (int i = 0; i < resArray.length; i++) {
            for (int j = 0; j < myArr.length; j++) {
                if(myArr[j] == i){
                    resArray[i] = resArray[i] += 1;
                }
            }
        }
        for (int i = 0; i < resArray.length; i++) {
            System.out.println(resArray[i]);
        }
        return resArray;
    }

    public String exR1(int n){
        if(n<=0) return "";

        return exR1(n-3) + n + exR1(n-2) + n;
    }

    static long[]computedValues;
    public static long F(int N){
        if(N==0)
            return 0;
        if(N==1){
            computedValues[N] = 1;
            return  1;
        }
        long val = computedValues[N-1] + computedValues[N-2];
        computedValues[N] = val;
        return  val;
        //return F(N-2) + F(N-1);
    }

    public static int ln(int n){
        if(n == 1)
            return 1;

        return n + ln(n-1);
    }

    public void printTable(){
        System.out.println("****** 21 Table exercise ******");
        System.out.println("please Add Name a 2 numbers separate by empty space");
        String val = StdIn.readLine();
        System.out.println("Name\tIntegers\tResDividingNumbers");
        int res = Integer.parseInt(val.split(" ")[1]) / Integer.parseInt(val.split(" ")[2]);
        System.out.printf("%s\t%s\t%d",val.split(" ")[0],val.split(" ")[1] + " " + val.split(" ")[2] ,res);
    }

    public static int twentytwoBinarySearch(int key, int[]a, int lo, int hi,String trackDeep){
        if(lo > hi) return -1;
        System.out.println(trackDeep + a[lo] + " " + a[hi]);
        trackDeep+=" ";
        int mid = lo + (hi - lo) /2;
        if(key < a[mid]) return twentytwoBinarySearch(key,a,lo,mid -1,trackDeep);
        else if(key > a[mid]) return twentytwoBinarySearch(key, a,mid +1, hi,trackDeep);
        else return mid;

    }

    public static int gcd(int p, int q){

    }
    public static void main(String[] args) {
        FundamentalsExercises fundamentalsExercises = new FundamentalsExercises();
        fundamentalsExercises.first();
        fundamentalsExercises.second();
       // fundamentalsExercises.third();
        fundamentalsExercises.fourth();
        fundamentalsExercises.fifth(.1,.2);
        fundamentalsExercises.sixth();
        fundamentalsExercises.seventh();
        fundamentalsExercises.eight();
        fundamentalsExercises.nineth(4);
        fundamentalsExercises.tenth();
        fundamentalsExercises.twelve();
        fundamentalsExercises.thirteen();
        int[] testArray = new int[5];
        testArray[0] = 1;
        testArray[1] = 1;
        testArray[2] = 2;
        testArray[3] = 1;
        testArray[4] = 0;
        histogram(testArray,3);
        System.out.println("****** 16  exercise ******");
        System.out.println(fundamentalsExercises.exR1(6));
        System.out.println("****** 19 Fibonacci  exercise ******");
        computedValues = new long[90];
        for(int n = 0; n < 90; n++)
            System.out.println(n + " " + F(n));
        System.out.println("****** 20 Factorial exercise ******");
        System.out.println(ln(5));
       // fundamentalsExercises.printTable();
        int[] orderedArray = {1,3,5,7,9,10,15,18,20};
        System.out.println("****** 22 Binary search with deep track");
        System.out.println(orderedArray[twentytwoBinarySearch(5,orderedArray,0,orderedArray.length-1,"")]);

    }
}//7778742049 49
