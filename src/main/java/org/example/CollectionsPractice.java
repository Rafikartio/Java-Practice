package org.example;




import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsPractice {
    public static  void main(String[] args) {

        List<String> names = Arrays.asList("Rafi","Bob","Ali","Naeem","Ahmed");
        names.stream().filter(s-> s.length()>4).forEach(System.out::println);

        List<Integer> nums = Arrays.asList(7,3,9,1,4,6);
       List<Integer> filteredNums=  nums.stream().map(i-> i*i).sorted().toList();

       int sum = nums.stream().reduce(Integer::sum).get();
        System.out.println(sum);

        IntSummaryStatistics statistics = nums.stream().collect(Collectors.summarizingInt(i-> i));
        System.out.println(statistics);

    }
}
