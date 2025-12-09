package com.tutorial.advanced;

import java.util.*;
import java.util.stream.*;

/**
 * Stream API Demo
 * 
 * This class demonstrates:
 * - Stream creation
 * - Intermediate operations (filter, map, flatMap, distinct, sorted, etc.)
 * - Terminal operations (collect, reduce, forEach, findFirst, etc.)
 * - Stream pipelines
 * - Parallel streams
 * - Stream performance considerations
 */
public class StreamAPI {
    
    public static void main(String[] args) {
        System.out.println("=== Stream API Demo ===");
        System.out.println();
        
        // 1. Stream Creation
        demonstrateStreamCreation();
        
        // 2. Intermediate Operations
        demonstrateIntermediateOperations();
        
        // 3. Terminal Operations
        demonstrateTerminalOperations();
        
        // 4. Stream Pipelines
        demonstrateStreamPipelines();
        
        // 5. Parallel Streams
        demonstrateParallelStreams();
        
        // 6. Stream Performance
        demonstrateStreamPerformance();
        
        // 7. Advanced Stream Operations
        demonstrateAdvancedStreamOperations();
    }
    
    /**
     * Demonstrates different ways to create streams
     */
    private static void demonstrateStreamCreation() {
        System.out.println("1. Stream Creation:");
        System.out.println("==================");
        
        // From Collection
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
        Stream<String> stream1 = list.stream();
        System.out.println("Stream from list: " + stream1.collect(Collectors.toList()));
        
        // From Array
        String[] array = {"one", "two", "three", "four"};
        Stream<String> stream2 = Arrays.stream(array);
        System.out.println("Stream from array: " + stream2.collect(Collectors.toList()));
        
        // Using Stream.of()
        Stream<String> stream3 = Stream.of("alpha", "beta", "gamma", "delta");
        System.out.println("Stream using Stream.of(): " + stream3.collect(Collectors.toList()));
        
        // Empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty stream: " + emptyStream.collect(Collectors.toList()));
        
        // Infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        System.out.println("Infinite stream (first 5): " + 
            infiniteStream.limit(5).collect(Collectors.toList()));
        
        // Stream from random numbers
        Stream<Double> randomStream = Stream.generate(Math::random);
        System.out.println("Random stream (first 3): " + 
            randomStream.limit(3).collect(Collectors.toList()));
        
        // Stream from range
        IntStream rangeStream = IntStream.range(1, 6);
        System.out.println("Range stream: " + 
            rangeStream.boxed().collect(Collectors.toList()));
        
        System.out.println();
    }
    
    /**
     * Demonstrates intermediate operations
     */
    private static void demonstrateIntermediateOperations() {
        System.out.println("2. Intermediate Operations:");
        System.out.println("==========================");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original numbers: " + numbers);
        
        // Filter
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Map
        List<String> numberStrings = numbers.stream()
            .map(n -> "Number: " + n)
            .collect(Collectors.toList());
        System.out.println("Number strings: " + numberStrings);
        
        // FlatMap
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattened = nestedList.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattened);
        
        // Distinct
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        List<Integer> unique = duplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique numbers: " + unique);
        
        // Sorted
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        List<String> sorted = words.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted words: " + sorted);
        
        // Sorted with custom comparator
        List<String> sortedByLength = words.stream()
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);
        
        // Limit
        List<Integer> limited = numbers.stream()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("Limited to 5: " + limited);
        
        // Skip
        List<Integer> skipped = numbers.stream()
            .skip(3)
            .collect(Collectors.toList());
        System.out.println("Skipped first 3: " + skipped);
        
        // Peek (for debugging)
        List<Integer> peeked = numbers.stream()
            .peek(n -> System.out.println("Processing: " + n))
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        System.out.println("Peeked and filtered: " + peeked);
        
        System.out.println();
    }
    
    /**
     * Demonstrates terminal operations
     */
    private static void demonstrateTerminalOperations() {
        System.out.println("3. Terminal Operations:");
        System.out.println("======================");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original numbers: " + numbers);
        
        // Collect
        List<Integer> collected = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Collected even numbers: " + collected);
        
        // Collect to Set
        Set<Integer> set = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toSet());
        System.out.println("Collected to set: " + set);
        
        // Collect to Map
        Map<Integer, String> map = numbers.stream()
            .collect(Collectors.toMap(
                n -> n,
                n -> "Value: " + n
            ));
        System.out.println("Collected to map: " + map);
        
        // Reduce
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // Reduce with identity and accumulator
        int product = numbers.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
        
        // Reduce with optional
        Optional<Integer> max = numbers.stream()
            .reduce(Integer::max);
        max.ifPresent(m -> System.out.println("Max: " + m));
        
        // ForEach
        System.out.println("Printing numbers:");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.println("  " + n));
        
        // FindFirst
        Optional<Integer> firstEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findFirst();
        firstEven.ifPresent(n -> System.out.println("First even: " + n));
        
        // FindAny
        Optional<Integer> anyEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findAny();
        anyEven.ifPresent(n -> System.out.println("Any even: " + n));
        
        // AnyMatch
        boolean hasEven = numbers.stream()
            .anyMatch(n -> n % 2 == 0);
        System.out.println("Has even numbers: " + hasEven);
        
        // AllMatch
        boolean allPositive = numbers.stream()
            .allMatch(n -> n > 0);
        System.out.println("All positive: " + allPositive);
        
        // NoneMatch
        boolean noneNegative = numbers.stream()
            .noneMatch(n -> n < 0);
        System.out.println("None negative: " + noneNegative);
        
        // Count
        long count = numbers.stream()
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Count of even numbers: " + count);
        
        System.out.println();
    }
    
    /**
     * Demonstrates stream pipelines
     */
    private static void demonstrateStreamPipelines() {
        System.out.println("4. Stream Pipelines:");
        System.out.println("===================");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineer"),
            new Person("Bob", 30, "Manager"),
            new Person("Charlie", 35, "Engineer"),
            new Person("David", 28, "Designer"),
            new Person("Eve", 32, "Manager"),
            new Person("Frank", 27, "Engineer")
        );
        
        System.out.println("All people: " + people);
        
        // Complex pipeline
        List<String> result = people.stream()
            .filter(person -> person.getAge() > 25)           // Filter by age
            .filter(person -> "Engineer".equals(person.getJob())) // Filter by job
            .map(Person::getName)                             // Extract names
            .map(String::toUpperCase)                         // Convert to uppercase
            .sorted()                                         // Sort alphabetically
            .collect(Collectors.toList());                    // Collect to list
        
        System.out.println("Engineers over 25 (uppercase, sorted): " + result);
        
        // Pipeline with grouping
        Map<String, List<Person>> groupedByJob = people.stream()
            .filter(person -> person.getAge() > 25)
            .collect(Collectors.groupingBy(Person::getJob));
        
        System.out.println("People over 25 grouped by job: " + groupedByJob);
        
        // Pipeline with statistics
        IntSummaryStatistics stats = people.stream()
            .filter(person -> "Engineer".equals(person.getJob()))
            .mapToInt(Person::getAge)
            .summaryStatistics();
        
        System.out.println("Engineer age statistics: " + stats);
        
        System.out.println();
    }
    
    /**
     * Demonstrates parallel streams
     */
    private static void demonstrateParallelStreams() {
        System.out.println("5. Parallel Streams:");
        System.out.println("===================");
        
        List<Integer> numbers = IntStream.rangeClosed(1, 1000000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential stream
        long startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
            .mapToLong(Integer::longValue)
            .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Sequential sum: " + sequentialSum + " (Time: " + sequentialTime + "ms)");
        
        // Parallel stream
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
        long parallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Parallel sum: " + parallelSum + " (Time: " + parallelTime + "ms)");
        
        // Parallel stream with custom thread pool
        startTime = System.currentTimeMillis();
        long customParallelSum = numbers.stream()
            .parallel()
            .mapToLong(Integer::longValue)
            .sum();
        long customParallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Custom parallel sum: " + customParallelSum + " (Time: " + customParallelTime + "ms)");
        
        // Parallel stream with complex operations
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<String> parallelProcessed = words.parallelStream()
            .map(String::toUpperCase)
            .map(s -> s + "!")
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println("Parallel processed words: " + parallelProcessed);
        
        System.out.println();
    }
    
    /**
     * Demonstrates stream performance considerations
     */
    private static void demonstrateStreamPerformance() {
        System.out.println("6. Stream Performance:");
        System.out.println("=====================");
        
        List<Integer> numbers = IntStream.rangeClosed(1, 100000)
            .boxed()
            .collect(Collectors.toList());
        
        // Performance comparison: Stream vs traditional loop
        long startTime = System.currentTimeMillis();
        long streamSum = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToLong(Integer::longValue)
            .sum();
        long streamTime = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        long loopSum = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                loopSum += number;
            }
        }
        long loopTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Stream sum: " + streamSum + " (Time: " + streamTime + "ms)");
        System.out.println("Loop sum: " + loopSum + " (Time: " + loopTime + "ms)");
        
        // Performance with different operations
        startTime = System.currentTimeMillis();
        List<Integer> streamResult = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .filter(n -> n > 100)
            .collect(Collectors.toList());
        long streamOpTime = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        List<Integer> loopResult = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                int doubled = number * 2;
                if (doubled > 100) {
                    loopResult.add(doubled);
                }
            }
        }
        long loopOpTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Stream operations: " + streamResult.size() + " items (Time: " + streamOpTime + "ms)");
        System.out.println("Loop operations: " + loopResult.size() + " items (Time: " + loopOpTime + "ms)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced stream operations
     */
    private static void demonstrateAdvancedStreamOperations() {
        System.out.println("7. Advanced Stream Operations:");
        System.out.println("=============================");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineer"),
            new Person("Bob", 30, "Manager"),
            new Person("Charlie", 35, "Engineer"),
            new Person("David", 28, "Designer"),
            new Person("Eve", 32, "Manager"),
            new Person("Frank", 27, "Engineer")
        );
        
        // Grouping and counting
        Map<String, Long> jobCounts = people.stream()
            .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
        System.out.println("Job counts: " + jobCounts);
        
        // Grouping and averaging
        Map<String, Double> averageAgeByJob = people.stream()
            .collect(Collectors.groupingBy(Person::getJob, Collectors.averagingInt(Person::getAge)));
        System.out.println("Average age by job: " + averageAgeByJob);
        
        // Partitioning
        Map<Boolean, List<Person>> partitioned = people.stream()
            .collect(Collectors.partitioningBy(person -> person.getAge() > 30));
        System.out.println("Partitioned by age > 30: " + partitioned);
        
        // Joining
        String joinedNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined names: " + joinedNames);
        
        // Reducing with custom accumulator
        Optional<Person> oldestPerson = people.stream()
            .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        oldestPerson.ifPresent(person -> 
            System.out.println("Oldest person: " + person.getName()));
        
        // Collecting to custom collection
        TreeSet<String> sortedNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Sorted names in TreeSet: " + sortedNames);
        
        // Custom collector
        String customResult = people.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> "Total people: " + list.size()
            ));
        System.out.println("Custom result: " + customResult);
        
        System.out.println();
    }
}
