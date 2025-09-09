import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Typing is a great skill to improve daily",
            "Java is a powerful programming language",
            "Practice makes a person perfect in any skill",
            "Focus on accuracy before speed in typing"
        };

        Random rand = new Random();
        String target = sentences[rand.nextInt(sentences.length)];

        System.out.println("Type the following sentence:\n");
        System.out.println(target);
        System.out.println("\nPress ENTER when you're ready to start...");
        sc.nextLine();  // Wait for user to press Enter

        long startTime = System.nanoTime();

        System.out.println("\nStart typing:");
        String typed = sc.nextLine();

        long endTime = System.nanoTime();

        double elapsedSeconds = (endTime - startTime) / 1e9;

        // Count words typed correctly
        int correctChars = 0;
        int totalChars = Math.max(typed.length(), target.length());

        StringBuilder errorReport = new StringBuilder();
        int mistakes = 0;

        for (int i = 0; i < totalChars; i++) {
            char expected = (i < target.length()) ? target.charAt(i) : '-';
            char actual = (i < typed.length()) ? typed.charAt(i) : '-';
            if (expected == actual) {
                correctChars++;
            } else {
                mistakes++;
                errorReport.append("Expected: '").append(expected).append("', but got: '").append(actual).append("'\n");
            }
        }

        double wpm = (typed.length() / 5.0) / (elapsedSeconds / 60);
        double accuracy = (correctChars * 100.0) / totalChars;

        System.out.printf("\n⏱ Time Taken: %.2f seconds\n", elapsedSeconds);
        System.out.printf("📈 WPM: %.2f\n", wpm);
        System.out.printf("✅ Accuracy: %.2f%%\n", accuracy);
        System.out.println("❌ Mistakes: " + mistakes);
        System.out.println("\n📋 Mistake Details:");
        if (mistakes == 0) {
            System.out.println("No mistakes! Great job!");
        } else {
            System.out.println(errorReport.toString());
        }

        sc.close();
    }
}
