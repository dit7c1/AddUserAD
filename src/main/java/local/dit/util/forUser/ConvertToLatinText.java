package local.dit.util.forUser;

import com.ibm.icu.text.Transliterator;

public class ConvertToLatinText {
    private static final Transliterator toLatinText = Transliterator.getInstance("Russian-Latin/BGN");

    public static String convert(String convertData) {
        return toLatinText.transliterate(convertData).replaceAll("[ʹ-ʺ]", "").toLowerCase();
    }
}