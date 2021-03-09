package local.dit.util.forUser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginGeneratorTest {

    @Test
    void generateLoginFirst() {
        String actualFirstNameLatin = ConvertToLatinText.convert("Исаак");
        String actualLastNameLatin = ConvertToLatinText.convert("Ньютон");
        String actualLoginGen = LoginGenerator.generateLogin(actualFirstNameLatin, actualLastNameLatin);

        String expectedFN = "isaak";
        String expectedLN = "nyuton";
        String expectedLogin = "inyuton";

        assertEquals(expectedFN, actualFirstNameLatin);
        assertEquals(expectedLN, actualLastNameLatin);
        assertEquals(expectedLogin, actualLoginGen);
    }

    @Test
    void generateLoginSecond() {
        String actualFirstNameLatin = ConvertToLatinText.convert("Юлия");
        String actualLastNameLatin = ConvertToLatinText.convert("Яковлева");
        String actualLoginGen = LoginGenerator.generateLogin(actualFirstNameLatin, actualLastNameLatin);

        String expectedFN = "yuliya";
        String expectedLN = "yakovleva";
        String expectedLogin = "yuyakovleva";

        assertEquals(expectedFN, actualFirstNameLatin);
        assertEquals(expectedLN, actualLastNameLatin);
        assertEquals(expectedLogin, actualLoginGen);
    }

    @Test
    void generateLoginThird() {
        String actualFirstNameLatin = ConvertToLatinText.convert("Максим");
        String actualLastNameLatin = ConvertToLatinText.convert("Жулинов");
        String actualLoginGen = LoginGenerator.generateLogin(actualFirstNameLatin, actualLastNameLatin);

        String expectedFN = "maksim";
        String expectedLN = "zhulinov";
        String expectedLogin = "mzhulinov";

        assertEquals(expectedFN, actualFirstNameLatin);
        assertEquals(expectedLN, actualLastNameLatin);
        assertEquals(expectedLogin, actualLoginGen);
    }
}