package dev.codewithram.level.easy.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MexicanWaveTest {

    @Test
    void basicTest1() {
        String[] result = new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"};
        assertArrayEquals(result, MexicanWave.wave("hello"));
    }

    @Test
    void basicTest2() {
        String[] result = new String[]{"Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS"};
        assertArrayEquals(result, MexicanWave.wave("codewars"));
    }

    @Test
    void basicTest3() {
        String[] result = new String[]{};
        assertArrayEquals(result, MexicanWave.wave(""));
    }

    @Test
    void basicTest4() {
        String[] result = new String[]{"Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS"};
        assertArrayEquals(result, MexicanWave.wave("two words"));
    }

    @Test
    void basicTest5() {
        String[] result = new String[]{" Gap ", " gAp ", " gaP "};
        assertArrayEquals(result, MexicanWave.wave(" gap "));
    }
}