package g000.g30.p30substringwithconcat;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    private class PotentialSolution {
        int currentIdx;
        char[] current;
        Set<char[]> words;
        int startIndex;

        public PotentialSolution(int currentIdx, char[] current, Set<char[]> words, int startIndex) {
            this.currentIdx = currentIdx;
            this.current = current;
            this.words = words;
            this.startIndex = startIndex;
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int totalSize = 0;
        char[] sc = s.toCharArray();
        Set<char[]> wordChars =  new HashSet<char[]>();
        for(String w : words) {
            wordChars.add(w.toCharArray());
            totalSize += w.length();
        }
        List<Integer> solutions = new ArrayList<Integer>();
        Set<PotentialSolution> potentialSolutions = new HashSet<PotentialSolution>();
        for(int i = 0 ; i < sc.length ; i++) {
            {	// Check validity of currently considered potential solutions
                Set<PotentialSolution> toRemove = new HashSet<PotentialSolution>();
                for(PotentialSolution currentSolution : potentialSolutions) {
                    if(currentSolution.currentIdx >= currentSolution.current.length) {
                        currentSolution.current = null;
                    } else if(sc[i] == currentSolution.current[currentSolution.currentIdx]) {
                        currentSolution.currentIdx++;
                    } else {
                        toRemove.add(currentSolution);
                    }

                }
                potentialSolutions.removeAll(toRemove);
            }
            { // Add new potential solutions when a word is finished
                Set<PotentialSolution> toRemove = new HashSet<PotentialSolution>();
                Set<PotentialSolution> toAdd = new HashSet<PotentialSolution>();
                for(PotentialSolution currentSolution : potentialSolutions) {
                    if(currentSolution.current == null) {
                        toRemove.add(currentSolution);
                        if(currentSolution.words.size() == 0) {
                            solutions.add(currentSolution.startIndex);
                        } else {
                            for(char[] w : currentSolution.words) {
                                if(w[0] == sc[i]) {
                                    Set<char[]> removedWords = new HashSet<char[]>(currentSolution.words);
                                    removedWords.remove(w);
                                    toAdd.add(new PotentialSolution(1,w,removedWords,currentSolution.startIndex));
                                }
                            }
                        }
                    }
                }
                potentialSolutions.removeAll(toRemove);
                potentialSolutions.addAll(toAdd);
            }
            if(i + totalSize < sc.length) { // Add new potential solutions from a fresh intend
                for(char[] w : wordChars) {
                    if(w[0] == sc[i]) {
                        Set<char[]> removedWords = new HashSet<char[]>(wordChars);
                        removedWords.remove(w);
                        potentialSolutions.add(new PotentialSolution(1,w,removedWords,i));
                    }
                }
            }
        }
        return solutions;
    }

}