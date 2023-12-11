import java.util.*;

public class WeightedStrings {

    public static int calculateWeight(char ch) {
        return ch - 'a' + 1;
    }

    public static String[] checkQueries(String str, int[] queries) {
        List<String> result = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();

        int cumulativeWeight = 0;
        for (char c : str.toCharArray()) {
            int charWeight = calculateWeight(c);
            cumulativeWeight += charWeight;
            weights.add(cumulativeWeight);

            int count = 1;
            while (weights.contains(cumulativeWeight) && count < str.length()) {
                cumulativeWeight += charWeight;
                weights.add(cumulativeWeight);
                count++;
            }
        }

        for (int query : queries) {
            result.add(weights.contains(query) ? "Yes" : "No");
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String inputString = "abbcccd";
        int[] queries = {1, 3, 9, 8};

        String[] result = checkQueries(inputString, queries);
        System.out.println("Output: " + Arrays.toString(result));
    }
}
