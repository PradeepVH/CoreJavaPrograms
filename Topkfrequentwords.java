import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Topkfrequentwords {

    public static void main(String[] args) {
        //method1();
       // method2();
        //leetCodeSolution1();
        //leetCodeSolution2();
        leetCodeSolution3();
    }

    private static void leetCodeSolution3() {
        //Min Heap
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2; // top 2
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> h = new PriorityQueue<>(
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2));

        for (String word : cnt.keySet()) {
            h.offer(word);
            if (h.size() > k)
                h.poll();
        }

        List<String> res = new ArrayList<>();
        while (!h.isEmpty())
            res.add(h.poll());
        Collections.reverse(res);
        res.forEach(v -> System.out.println(v));
    }

    private static void leetCodeSolution2() {
        //Max Heap
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2; // top 2
        class Word implements Comparable<Word> {
            private String word;
            private int count;

            public Word(String word, int count) {
                this.word = word;
                this.count = count;
            }

            public int compareTo(Word other) {
                if (this.count == other.count) {
                    return this.word.compareTo(other.word);
                }
                return other.count - this.count;
            }
        }

            Map<String, Integer> cnt = new HashMap<>();
            for (String word : words) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }

            List<Word> candidates = new ArrayList<>();
            for (Entry<String, Integer> entry : cnt.entrySet()) {
                candidates.add(new Word(entry.getKey(), entry.getValue()));
            }

            Queue<Word> h = new PriorityQueue<>(candidates);
            List<String> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                res.add(h.poll().word);
            }
            res.forEach(v -> System.out.println(v));

    }

    private static void leetCodeSolution1() {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2; // top 2
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(cnt.keySet());
        Collections.sort(candidates,
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w1.compareTo(w2) : cnt.get(w2) - cnt.get(w1));

        List<String> topKFrequentords = candidates.subList(0, k);
        topKFrequentords.forEach(v -> System.out.println(v));
    }

    private static void method2() {

        List<String> terms = Arrays.asList(
                "Coding is great",
                "Search Engine are great",
                "Google is a nice search engine",
                "Bing is also a nice engine");
        TopOccurrence topOccurrence = new TopOccurrence(2);
        terms.parallelStream() //Utilizes multi-core hardware
                .flatMap(s -> Arrays.asList(s.split(" ")).stream())
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum)) // Big O(n)
                .forEach((s, integer) -> topOccurrence.add(new WordCount(s, integer)));
        System.out.println(topOccurrence);
    }
    static class TopOccurrence {
        private final PriorityQueue<WordCount> minHeap;
        private final int maxSize;
        public TopOccurrence(int maxSize) {
            this.maxSize = maxSize;
            this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt(wc -> wc.count));
// This constructs a min heap (when order of elements is natural i.e. ascending order).
// We are using Natural order for integers (wc.count)
// In order to create a max-heap, we just need to provide reversed comparator i.e. that sorts in descending order,as shown below
// this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt((WordCount wc) -> wc.count).reversed());
        }
        public void add(WordCount data) {
            if (minHeap.size() < maxSize) { // size() is Big O(1)
                minHeap.offer(data); // Big O(log(k)) where k is the number of top occurrences required
            } else if (minHeap.peek().count < data.count) { // peek() is Big O(1)
                minHeap.poll(); // Big O(log(k))
                minHeap.offer(data); // Big O(log(k))
            }
        }
        @Override
        public String toString() {
            return "TopOccurrence{" + "minHeap=" + minHeap + ", maxSize=" + maxSize + '}';
        }
    }
    static class WordCount {
        protected final String word;
        protected final int count;
        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
        @Override
        public String toString() {
            return "{" + "word='" + word + '\'' + ", count=" + count + '}'+"\r\n";
        }
    }

    private static void method1() {
        List<String> terms = Arrays.asList(
                "Coding is great",
                "Search Engine are great",
                "Google is a nice search engine",
                "Bing is also a nice engine");
        ConcurrentMap<String, Integer> wordFreq = terms
                .parallelStream() //Utilizes multi-core hardware
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum)); // Big O(n)

        OptionalInt max = wordFreq
                .values()
                .parallelStream()
                .mapToInt(Integer::valueOf)
                .max();

        if (max.isPresent()) {
            String[] freq = new String[max.getAsInt()];
            wordFreq.forEach((s, integer) -> {
                if (freq[integer - 1] == null) {
                    freq[integer - 1] = s;
                } else {
                    freq[integer - 1] = freq[integer - 1] + "," + s;
                }
            });
            for (int i = max.getAsInt() - 1; i >= 0; i--) {
                System.out.println((i + 1) + " --> " + freq[i]);
            }
        }
    }
}