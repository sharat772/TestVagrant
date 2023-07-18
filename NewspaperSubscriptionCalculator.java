import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewspaperSubscriptionCalculator {

    private static Map<String, double[]> newspaperData = new HashMap<>();

    public static void main(String[] args) {
        newspaperData.put("TOI", new double[]{3, 3, 3, 3, 3, 5, 6});
        newspaperData.put("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4});
        newspaperData.put("ET", new double[]{4, 4, 4, 4, 4, 4, 10});
        newspaperData.put("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5});
        newspaperData.put("HT", new double[]{2, 2, 2, 2, 2, 4, 4});
        double budget = 40; 
        int numSubscriptions = 2; 
        double budget2 = 35;
        List<List<String>> combinations = getCombination(newspaperData, numSubscriptions, budget);
        System.out.println("Possible combinations of " + numSubscriptions + " subscriptions within the "+ budget);
        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
        List<List<String>> combinations2 = getCombination(newspaperData, numSubscriptions, budget2);
        System.out.println("Possible combinations of " + numSubscriptions + " subscriptions within the "+ budget2);
        for (List<String> combination : combinations2) {
            System.out.println(combination);
        }
    }

    public static List<List<String>> getCombination(Map<String, double[]> newspaperData, int numSubscriptions, double budget) {
        Set<List<String>> combinations = new HashSet<>(); // Using HashSet to remove duplicates

        for (Map.Entry<String, double[]> entry1 : newspaperData.entrySet()) {
            for (Map.Entry<String, double[]> entry2 : newspaperData.entrySet()) {
                if (!entry1.getKey().equals(entry2.getKey())) {
                    double totalExpense1 = calculateTotalExpense(entry1.getValue(), numSubscriptions);
                    double totalExpense2 = calculateTotalExpense(entry2.getValue(), numSubscriptions);
                    double combinedTotal = totalExpense1 + totalExpense2;
                    if (combinedTotal <= budget) {
                        List<String> combination = new ArrayList<>();
                        combination.add(entry1.getKey());
                        combination.add(entry2.getKey());
                        combinations.add(combination);
                    }
                }
            }
        }

        return new ArrayList<>(combinations); 
    }

    private static double calculateTotalExpense(double[] prices, int numSubscriptions) {
        double total = 0;
        for (int i = 0; i < numSubscriptions && i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }
}
