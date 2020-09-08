package com.sivaram.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String... args) {
        streamFromArrays();
        streamFromCollections();
        streamFromStreamOf();
        streamsUsingBuilder();
        streamsUsingInfinetIterator();
        streamFromGenerator();
        filterExample();
        filterWithPredicateExample();
        mapExample();
        mapObjectExample();
        flatMapRequirement();
        sortingUsingStreams();
        usingReverseOrder();
        usingObjects();
        chainingOjects();
        gettingDistinctObjects();
        streamCollectTo();
        reduce();
        reduceTwo();
        streamMinAndMax();
    }

    private static void streamsUsingInfinetIterator() {
        System.out.println("Printing streams using infinite  iterator");
        Stream.<Integer>iterate(Integer.valueOf(1), i -> Integer.valueOf(i.intValue() + i.intValue()))
                .limit(5L)
                .forEach(System.out::println);
    }

    private static void streamsUsingBuilder() {
        System.out.println("Printing stream using builder");
        Stream.Builder<String> streamBuilder = Stream.builder();
        Stream<String> stringStream = streamBuilder.add("Housten 1").add("Hudson").add("Jenkins").build();
        stringStream.forEach(System.out::println);
    }

    private static void streamFromStreamOf() {
        System.out.println("Printing streams using StreamOf");
        String[] array = { "Cat", "Bat", "Dog" };
        Stream.<String>of(array).forEach(System.out::println);
    }

    private static void streamFromCollections() {
        String[] array = { "Hat", "Coat", "Glasses" };
        List<String> listOfObjects = Arrays.asList(array);
        listOfObjects.stream().forEach(System.out::println);
    }

    private static void streamFromArrays() {
        String[] stringArray = new String[3];
        stringArray[0] = "One";
        stringArray[1] = "Two";
        stringArray[2] = "Three";
        Arrays.<String>stream(stringArray).forEach(System.out::println);
    }

    private static void streamFromGenerator() {
        System.out.println("Stream From generator");
        Stream.generate(Math::random)
                .limit(10L)
                .forEach(System.out::println);
    }

    private static void filterExample() {
        System.out.println("Filter example");
        Stream.<Integer>iterate(Integer.valueOf(0), n -> Integer.valueOf(n.intValue() + 1))
                .limit(10L)
                .filter(n -> (n.intValue() % 2 == 0))
                .forEach(System.out::println);
    }

    private static void filterWithPredicateExample() {
        Predicate<Integer> evenNumberFilter = n -> (n.intValue() % 2 == 0);
        System.out.println("Filter example with predicate");
        Stream.<Integer>iterate(Integer.valueOf(0), n -> Integer.valueOf(n.intValue() + 1))
                .limit(10L)
                .filter(evenNumberFilter)
                .forEach(System.out::println);
    }

    private static void mapExample() {
        System.out.println("Map example");
        String[] names = { "a", "b", "c" };
        Arrays.<String>stream(names)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void mapObjectExample() {
        System.out.println("Map example");
        List<StudentEntity> entityList = new ArrayList<>();
        entityList.add(new StudentEntity("John", "Doe",

                Integer.valueOf(22), "Some value", "Another value"));
        entityList.add(new StudentEntity("Jane", "Doe",

                Integer.valueOf(22), "Confidential Value", "Some other confidential value"));
        entityList.stream().map(new StudentMapper()).forEach(System.out::println);
    }

    private static void flatMapRequirement() {
        System.out.println("Why flat map is needed ?");
        Integer[][] twoDarray = { { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) }, { Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(9) } };
        Stream.<Integer[]>of(twoDarray)
                .flatMap(x -> Arrays.stream(x))
                .filter(i -> (i.intValue() > 4))
                .forEach(System.out::println);
    }

    private static void sortingUsingStreams() {
        System.out.println("Printing streams ");
        Integer[] array = { Integer.valueOf(1), Integer.valueOf(99), Integer.valueOf(23), Integer.valueOf(77), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(897) };
        Stream.<Integer>of(array).sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static void usingReverseOrder() {
        System.out.println("Printing streams reverse order");
        Integer[] array = { Integer.valueOf(1), Integer.valueOf(99), Integer.valueOf(23), Integer.valueOf(77), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(897) };
        Stream.<Integer>of(array).sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void usingObjects() {
        System.out.println("Printing sorted objects ");
        List<StudentEntity> entityList = new ArrayList<>();
        entityList.add(new StudentEntity("Jane", "Doe",

                Integer.valueOf(29), "Confidential Value", "Some other confidential value"));
        entityList.add(new StudentEntity("John", "Doe",

                Integer.valueOf(22), "Some value", "Another value"));
        entityList.stream()
                .sorted(Comparator.comparingInt(StudentEntity::getAge))
                .forEach(System.out::println);
    }

    private static void chainingOjects() {
        System.out.println("Printing sorted objects ");
        List<StudentEntity> entityList = new ArrayList<>();
        entityList.add(new StudentEntity("Jane", "Doe",

                Integer.valueOf(29), "Confidential Value", "Some other confidential value"));
        entityList.add(new StudentEntity("John", "Doe",

                Integer.valueOf(28), "Some value", "Another value"));
        entityList.add(new StudentEntity("Jack", "Dove",

                Integer.valueOf(29), "Some value", "Another value"));
        entityList.stream()
                .sorted(Comparator.comparingInt(StudentEntity::getAge)
                        .thenComparing(StudentEntity::getFirstName))
                .forEach(System.out::println);
    }

    private static void gettingDistinctObjects() {
        System.out.println("Getting to distinct objects");
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("B");
        names.add("A");
        names.add("C");
        names.add("K");
        names.add("P");
        names.add("Z");
        names.add("A");
        names.add("Y");
        names.add("K");
        names.add("P");
        names.add("Z");
        names.stream().distinct().forEach(System.out::println);
    }

    private static void streamCollectTo() {
        System.out.println("Collect to ");
        List<Integer> intList = (List<Integer>)Stream.<Integer>iterate(Integer.valueOf(0), i -> Integer.valueOf(i.intValue() + 1)).limit(100L).filter(x -> (x.intValue() % 2 == 0)).collect(Collectors.toList());
        System.out.println(intList);
    }

    private static void streamMinAndMax() {
        Integer[] array = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3422), Integer.valueOf(767868), Integer.valueOf(232), Integer.valueOf(87878) };
        List<Integer> list = Arrays.asList(array);
        Integer min = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Min value is " + min);
        Integer max = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("maximum number is" + max);
    }

    private static void reduceTwo() {
        System.out.println("Reduce");
        Integer[] array = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) };
        List<Integer> list = Arrays.asList(array);
        Integer total = list.stream().reduce(Integer.valueOf(0), (sum, x) -> Integer.valueOf(sum.intValue() + x.intValue()));
        System.out.println("Total is " + total);
    }

    private static void reduce() {
        System.out.println("Reduce");
        Integer[] array = { Integer.valueOf(1), Integer.valueOf(88), Integer.valueOf(8937), Integer.valueOf(8989), Integer.valueOf(232322) };
        List<Integer> list = Arrays.asList(array);
        Integer total = list.stream().filter(n -> (n.intValue() % 2 == 0)).reduce(Integer.valueOf(0), (sum, x) -> Integer.valueOf(sum.intValue() + x.intValue()));
        System.out.println("Total is " + total);
    }
}
