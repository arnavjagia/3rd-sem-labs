import java.util.*;

class NumericFns<T extends Number> {
    T num;
    
    NumericFns(T n) {
        num = n;
    }

    double reciprocal() {
        return 1 / num.doubleValue();
    }
    
    double fraction() {
        return num.doubleValue() - num.intValue();
    }
    
    boolean absEqual(NumericFns<?> ob) {
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) {
            return true;
        }
        return false;
    }
}

class q3NumericFns {
    public static void main(String[] args) {
        NumericFns<Integer> iOb = new NumericFns<>(6);
        NumericFns<Double> dOb = new NumericFns<>(-6.0);
        NumericFns<Long> lOb = new NumericFns<>(5L);

        System.out.println("Reciprocal of iOb: " + iOb.reciprocal());
        System.out.println("Fractional component of iOb: " + iOb.fraction());
        
        System.out.println("iOb and dOb have same absolute value: " + iOb.absEqual(dOb));
        System.out.println("iOb and lOb have same absolute value: " + iOb.absEqual(lOb));
    }
}

/* ------------------------------- SAMPLE RUN --------------------------------

Reciprocal of iOb: 0.16666666666666666
Fractional component of iOb: 0.0
iOb and dOb have same absolute value: true
iOb and lOb have same absolute value: false

*/