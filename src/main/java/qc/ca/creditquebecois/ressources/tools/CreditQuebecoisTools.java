package qc.ca.creditquebecois.ressources.tools;

import java.util.Random;

public class CreditQuebecoisTools {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
