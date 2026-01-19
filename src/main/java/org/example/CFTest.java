package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class CFTest {

    static Map<String,Integer> wordFrequency(String str){
        Map<String,Integer> frequency = new HashMap<>();
        for(String s : str.toLowerCase().split(" ")){
            if(frequency.containsKey(s)){
                frequency.put(s,frequency.get(s)+1);
            }else{
                frequency.put(s,1);
            }
        }
        return frequency;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(3, 5, 3, 8, 5, 9, 2, 10);

        LinkedHashSet<Integer> integers = new LinkedHashSet<>(nums);

        List<Integer> nonDuplicates = new ArrayList<>(integers);
        System.out.println(nonDuplicates);

        Collections.sort(nums);
        System.out.println("Max : "+nums.get(nums.size()-1)+" Min : "+nums.get(0));


        Map<String,Integer> wordFrequency = wordFrequency("Java is easy java is powerful");
        System.out.println(wordFrequency);

        List<String> names = Arrays.asList("Rafi","Ahmed","Sahil","Mubeen","Naveen","Ali","Ali");
        names.sort(Comparator.comparingInt(String::length).thenComparing(s-> s));
        System.out.println(names);

        List<Integer> evenNums = nums.stream().filter(n-> n%2==0).toList();
        System.out.println(evenNums);

        List<String> upperCaseNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCaseNames);

        int sum  = nums.stream().map(n-> n*n).reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> withoutDuplicates = nums.stream().distinct().toList();
        System.out.println(withoutDuplicates);

        Map<String,Long> frequency = names.stream().
                collect(Collectors.groupingBy(s-> s,Collectors.counting()));
        System.out.println(frequency);
        System.out.println("Ok");

        Map<String,List<Integer>>  groupMap = nums.stream().collect(Collectors.groupingBy(n-> n%2==0? "Even" : "Odd"));
        System.out.println(groupMap);

        frequency.entrySet().stream().sorted(Comparator.comparingInt(e-> e.getValue().intValue())).forEach(System.out::println);

    }
}
