package g000.g30.p39combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allCombinations = new LinkedList<>();

        recursiveCombination(candidates, new LinkedList<>(), 0, target, allCombinations,
                             new HashSet<>());

        return allCombinations;

    }

    void recursiveCombination(final int[] candidates,
                              final List<Integer> current,
                              final int currentSum,
                              final int target,
                              final List<List<Integer>> results,
                              final Set<List<Integer>> alreadyCalculated) {
        System.out.println("current = " + String.join(",", current.stream().map(i -> String.valueOf(i)).collect(
            Collectors.toList())));
        if (alreadyCalculated.contains(current)) {
            return;
        }
        List<Integer> currentCopy = new ArrayList<>(current);
        // Todo evitar listas duplicadas (e.g. histograma?)
        alreadyCalculated.add(currentCopy);
        if (currentSum == target) {
            results.add(currentCopy);
            return;
        } else if(currentSum > target) {
            return;
        }

        for(int c : candidates) {
            current.add(c);
            recursiveCombination(candidates, current, currentSum + c, target, results,
                                 alreadyCalculated);
            current.remove(current.size() - 1);
        }
    }
}
