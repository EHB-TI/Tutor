package Entity;

import java.util.Arrays;
import java.util.Collections;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class PwGenerator {
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final String capital = letters.toUpperCase();
    private static final String numbers = "0123456789";
    private static final String characters = "!@#$%&*()_+-=[]?";
    private static final int passwordSize = 15;

    private static final String password= capital +numbers+characters+letters;


    private static final String password_shuffle=shuffleString(password);
    private static SecureRandom random =new SecureRandom();

    public static String generateRandomPassword(){
        //Construct a string builder with an initial capacity of 13
        StringBuilder sb = new StringBuilder(passwordSize);
        for (int i = 0; i < passwordSize; i++) {

            int randomCharAt = random.nextInt(password_shuffle.length());
            char randomChar = password_shuffle.charAt(randomCharAt);
            sb.append(randomChar);

        }
        return sb.toString();
    }

    public static String shuffleString(String password) {
        //Transform a password in an array
        List<String> letters=Arrays.asList(password.split(""));
        //Shuffle values in array
        Collections.shuffle(letters);

        //Join the array in a string
        return letters.stream().collect(Collectors.joining());
    }
}
