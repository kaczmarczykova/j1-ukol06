package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    //Tato metoda testuje pripady, kdy ma svatek jen jedno jmeno
    @Test
    void vyhledatDataSJednimSvatkem() throws IOException {
        //TODO implementovat test metody vyhledatSvatkyKeDni

        SvatkySluzba ss = new SvatkySluzba();
        var test1Name = ss.vyhledatSvatkyKeDni(MonthDay.of(12, 31));
        assertTrue(test1Name.contains("Silvestr") && test1Name.size() == 1);

        test1Name = ss.vyhledatSvatkyKeDni(MonthDay.of(12, 30));
        assertTrue(test1Name.contains("David") && test1Name.size() == 1);
    }

    //Tato metoda testuje pripady, kdy ma svatek vice jmen
    @Test
    void vyhledatDataSViceSvatky() throws IOException {
        SvatkySluzba ss = new SvatkySluzba();
        var test2Name = ss.vyhledatSvatkyKeDni(MonthDay.of(1, 2));
        assertTrue(test2Name.contains("Vasil") && test2Name.contains("Karina") && test2Name.size() == 2);
    }

    @Test
    void vyhledatDataBezSvatku() throws IOException {
        SvatkySluzba ss = new SvatkySluzba();
        var test0Name = ss.vyhledatSvatkyKeDni(MonthDay.of(1, 1));
        assertTrue(test0Name.size() == 0);
    }

}
