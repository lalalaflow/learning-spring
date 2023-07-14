package dev.lalalaflow.javainaction.practice;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

@Controller
public class CollectorPractice {

    public boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    public boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double)candidate);
        return IntStream.range(2, candidateRoot).noneMatch(i-> candidateRoot % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.range(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
    }

}
