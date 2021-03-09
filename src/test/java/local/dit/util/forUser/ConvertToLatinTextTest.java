package local.dit.util.forUser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertToLatinTextTest {

    @Test
    void convertFirst() {
        String actual = ConvertToLatinText.convert("Якимчук");
        String expected = "yakimchuk";
        assertEquals(expected, actual);
    }

    @Test
    void convertSecond() {
        String actual = ConvertToLatinText.convert("Юлия");
        String expected = "yuliya";
        assertEquals(expected, actual);
    }

    @Test
    void convertThird() {
        String actual = ConvertToLatinText.convert("Жирафенко");
        String expected = "zhirafenko";
        assertEquals(expected, actual);
    }

    @Test
    void convertFourth() {
        String actual = ConvertToLatinText.convert("Пыдык");
        String expected = "pydyk";
        assertEquals(expected, actual);
    }

    @Test
    void convertFifth() {
        String actual = ConvertToLatinText.convert("Приходько");
        String expected = "prikhodko";
        assertEquals(expected, actual);
    }
}