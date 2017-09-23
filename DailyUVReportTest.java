import static org.junit.Assert.*;

import org.junit.Test;

public class DailyUVReportTest
{

  @Test
public void setOvercast()
{
    
   
    UVI high = new UVI(5.0, true);
    UVI low = new UVI(3.0, true);
    DailyUVReport DP = new DailyUVReport(low, high, 50.0, true);
    assertEquals(true,DP.isOvercast());// testing overcast getter
    assertEquals(50.0, DP.getTemperature(), 0.001); // testing temperature getter
    assertEquals(3.0, DP.getLow().getValue(),.01); //testing for value assignment
    assertEquals(5.0, DP.getHigh().getValue(), .01); //testing for value assignment
    assertEquals("UVI:  3 -  5", DP.getRange());// testing the getRange (toSTring)
    
    UVI loww = new UVI(8.0, true);
    UVI highh = new UVI(3.0, true);
    DailyUVReport DPP = new DailyUVReport(loww, highh, 200.0, true);
    assertEquals(true,DP.isOvercast());// testing overcast getter
    assertEquals(120.0, DPP.getTemperature(), 0.001); // testing temperature getter w/ temperature > tempreature max
    assertEquals(6.3, DPP.getLow().getValue(), .01); //testing for value assignment w/ highh < loww
    assertEquals(8.9, DPP.getHigh().getValue(), .01); //testing for value assignment w/ highh < loww
    assertEquals("UVI:  6 -  9", DPP.getRange()); //testing the getRange (toString)
    
    UVI lowww = new UVI(10, true);
    UVI highhh = new UVI(12, true);
    DailyUVReport DPPP = new DailyUVReport(lowww, highhh, -100.0, false);
    assertEquals(false,DPPP.isOvercast());// testing overcast getter
    assertEquals(-50.0, DPPP.getTemperature(), 0.001); // testing temperature getter
    assertEquals(10, DPPP.getLow().getValue(), .01); //testing for value assignment
    assertEquals(12, DPPP.getHigh().getValue(), .01); //testing for value assignment
    assertEquals("UVI: 10 - 12", DPPP.getRange()); //testing the getRange (toString)
    
    UVI lowwww = null;
    UVI highhhh = new UVI(12, true);
    DailyUVReport DPPPP = new DailyUVReport(lowwww, highhhh, -100.0, false);
    assertEquals(false,DPPPP.isOvercast());// testing overcast getter
    assertEquals(-50.0, DPPPP.getTemperature(), 0.001); // testing temperature getter
    assertEquals(6.3, DPPPP.getLow().getValue(), .01); //testing for value assignment
    assertEquals(12, DPPPP.getHigh().getValue(), .01); //testing for value assignment
    assertEquals("UVI:  6 - 12", DPPPP.getRange()); //testing the getRange (toString)
}
}
