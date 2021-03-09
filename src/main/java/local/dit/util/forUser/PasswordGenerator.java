package local.dit.util.forUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PasswordGenerator {

    public static String generatePassword(String firstNameLatin, String lastNameLatin) {
        String firstChLastName = lastNameLatin.substring(0, 1);
        String firstChFirstName = firstNameLatin.substring(0, 1);
        Date dateNow = new Date();
        String dayNow = new SimpleDateFormat("dd").format(dateNow);
        String monthNow = new SimpleDateFormat("MM").format(dateNow);
        String symbol = "";
        switch (monthNow) {
            case "01":
                symbol = "0!";
                break;
            case "02":
                symbol = "0@";
                break;
            case "03":
                symbol = "0#";
                break;
            case "04":
                symbol = "0$";
                break;
            case "05":
                symbol = "0%";
                break;
            case "06":
                symbol = "0^";
                break;
            case "07":
                symbol = "0&";
                break;
            case "08":
                symbol = "0*";
                break;
            case "09":
                symbol = "0(";
                break;
            case "10":
                symbol = "1)";
                break;
            case "11":
                symbol = "1_";
                break;
            case "12":
                symbol = "1+";
                break;
        }
        monthNow = new StringBuffer(monthNow).reverse().toString();
        return firstChFirstName + firstChLastName + dayNow + monthNow + symbol;
    }
}