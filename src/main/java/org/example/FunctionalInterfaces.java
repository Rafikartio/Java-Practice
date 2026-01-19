package org.example;


import java.util.function.*;

@FunctionalInterface
interface Voca <T,R>{
    R add(T a , T b);
}


public class FunctionalInterfaces {
    public static void main(String[] args)throws Exception {

        // Predicate Using anonymous class
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer> 9;
            }
        };

        // Predicate Using Lamda
        Predicate<Integer> predicate1 = i -> i>9;

        // Consumer Using anonymous class
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };


        //Consumer using lamda
        Consumer<Integer> consumer1 = i -> System.out.println(i);

        // Consumer Using Method Reference
        Consumer<Integer> consumer2 = System.out::println;

        //Function Using anonymous class
        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer+2;
            }
        };

        //Function Using lamda
        Function<Integer,Integer> function1 = i-> i+2;

        // Supplier Using anonymous class
        Supplier<Integer[]> supplier = new Supplier<Integer[]>() {
            @Override
            public Integer[] get() {
                return new Integer[8];
            }
        };

        // Supplier Using lamda
        Supplier<String[]> supplier1 = () -> new String[8];

        String[] cars = supplier1.get();
        System.out.println(cars.length);


        // UnaryOperator Using anonymous class
        UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s+" Hello";
            }
        };

        //UnaryOperator Using lamda
        UnaryOperator<Double> unaryOperator1 = (x) -> x+4.5;
        System.out.println(unaryOperator1.apply(99.5));

        //BinaryOperator Using anonymous class
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer*integer2;
            }
        } ;

        //BinaryOperator Using lamda
        BinaryOperator<Integer> binaryOperator1 = (x,y) -> x*y;

        // BiPredicate Using anonymous class
        BiPredicate<String,Integer> biPredicate = new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return integer>9;
            }
        };

        //BiPredicate Using lamda
        BiPredicate<Integer,String> biPredicate1 = (k,v) -> v.length()>0;

        // BiConsumer using lamda
        BiConsumer<String,Integer> biConsumer = (k,v) -> System.out.println(k.charAt(0));

        //BiFunction Using lamda
        BiFunction<Integer,String,Boolean> booleanBiFunction = (k,v) -> k==v.length();

        Voca<Integer,String> adder = (x,y) -> String.valueOf(x+y);
        System.out.println(adder.add(88,2));







    }
}
