package local.dit.util.forUser;

public class LoginGenerator {

    public static String generateLogin(String firstNameLatin, String lastNameLatin) {
        if (firstNameLatin.substring(0, 2).equals("ya")) {
            return firstNameLatin.substring(0, 2) + lastNameLatin;
        } else if (firstNameLatin.substring(0, 2).equals("yu")) {
            return firstNameLatin.substring(0, 2) + lastNameLatin;
        } else {
            return firstNameLatin.substring(0, 1) + lastNameLatin;
        }
    }
}