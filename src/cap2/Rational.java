package cap2;

public final class Rational {

    private long numerator;
    private long denominator;
    public Rational(long numerator, long denominator){

        long commonDivisor = getGCD(numerator,denominator);
        this.numerator = numerator/commonDivisor;
        this.denominator = denominator/commonDivisor;
    }

    private long getGCD(long numerator,long denominator){
        if(denominator == 0)
            return numerator;
        return getGCD(denominator,numerator%denominator);
    }

    private long getLCD(long a, long b){

            return (a * b) / getGCD(a, b);


    }

    public Rational plus(Rational b){
        long commonBase = getLCD(denominator , b.denominator);
        return new Rational(((commonBase/denominator) * numerator) + ((commonBase/b.denominator) * b.numerator),commonBase);
    }

    public Rational minus(Rational b){
        long commonBase = getLCD(denominator , b.denominator);
        return new Rational(((commonBase/denominator) * numerator) - ((commonBase/b.denominator) * b.numerator),commonBase);
    }

    public Rational times(Rational b){
        return new Rational(numerator* b.numerator,denominator*b.denominator);
    }

    public Rational dividedBy(Rational b){
        return new Rational(numerator*b.denominator,denominator* b.numerator);
    }

   public boolean equals(Object b){
        return numerator == ((Rational)b).numerator &&
        denominator == ((Rational)b).denominator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }
}
