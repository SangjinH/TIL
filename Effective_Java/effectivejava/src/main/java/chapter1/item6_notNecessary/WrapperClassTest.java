package chapter1.item6_notNecessary;

public class WrapperClassTest {

    private static long checkTimeWithWrapperClass() {
        long startTime = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) sum += i;
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    private static long checkTimeWithPrimitiveClass() {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) sum += i;
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
//        long primitiveTime = checkTimeWithPrimitiveClass();
//        System.out.println("primitiveTime = " + primitiveTime);
//
//        long wrapperTime = checkTimeWithWrapperClass();
//        System.out.println("wrapperTime = " + wrapperTime);


        int i = 0;
        int j = 0;

        System.out.println("i++ = " + i++);
        System.out.println("++j = " + ++j);
    }
}
