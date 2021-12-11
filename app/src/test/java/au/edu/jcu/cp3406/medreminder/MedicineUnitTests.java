package au.edu.jcu.cp3406.medreminder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MedicineUnitTests {
    @Test
    public void testOutputType1() {
        Medicine medicine = new Medicine("hypertension", 2, "tablets", "AM");
        assertEquals("2 hypertension tablets", medicine.getString(medicine.getType()));
    }

    @Test
    public void testOutputType2() {
        Medicine medicine = new Medicine("diabetes", 1, "tablets", "AM");
        assertEquals("1 diabetes tablet", medicine.getString(medicine.getType()));
    }

    @Test
    public void testOutputType3() {
        Medicine medicine = new Medicine("TCM", 30, "liquid", "PM");
        assertEquals("TCM 30ml", medicine.getString(medicine.getType()));
    }

    @Test
    public void testDateFormat() {
        Medicine medicine = new Medicine();
        assertEquals("Saturday, 11 December 2021", medicine.getDateToday());
    }
}