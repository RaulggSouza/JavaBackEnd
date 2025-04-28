import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> allWords = new ArrayList<>();
        TreeSet<String> uniqueWordsOrdered = new TreeSet<>();
        LinkedHashMap<String, Integer> wordsFrequency = new LinkedHashMap<>();
        StringJoiner joiner = new StringJoiner(", ");

        while (true){
            String next = scanner.nextLine();
            if (next.trim().isEmpty()){
                break;
            }
            String[] tokens = next.split("\\s+");
            for (String word : tokens) {
                allWords.add(word);
                uniqueWordsOrdered.add(word);
                if (wordsFrequency.containsKey(word)){
                    wordsFrequency.replace(word, wordsFrequency.get(word)+1);
                }else {
                    wordsFrequency.put(word, 1);
                }
            }
        }
        scanner.close();
        for (String word : allWords) {
            joiner.add(word);
        }
        System.out.println(joiner);

        StringJoiner uniqueJoiner = new StringJoiner(", ");
        for (String unique : uniqueWordsOrdered) {
            uniqueJoiner.add(unique);
        }
        System.out.println(uniqueJoiner);
        
        StringJoiner mapJoiner = new StringJoiner(", ");
        for (String keys : wordsFrequency.keySet()) {
            mapJoiner.add("Word = "+keys+ " Times = "+wordsFrequency.get(keys));
        }
        System.out.println(mapJoiner);
    }
}
