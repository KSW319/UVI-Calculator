
import static org.junit.Assert.*;

import org.junit.Test;

public class UVITest
{

  /**
   * Unit tests for the getValue() method.
   * test cases were based off PA1 -8.1
   */

  @Test
  public void getValue()
  {
    UVI uvi;
    
    
    //test 1
    uvi = new UVI(5.5, false);
    assertEquals(5.5, uvi.getValue(), 0);
     
    //test 2
    uvi = new UVI(0.0, false);
    assertEquals(0.0, uvi.getValue(), 0);
     
    //test 3
    uvi = new UVI(-1.0, false);
    assertEquals(0.0, uvi.getValue(), 0);
     
     //test 4
    uvi = new UVI(143.2, false);
    assertEquals(143.2, uvi.getValue(), 0);
  }
  

  /**
   * Unit tests for the toString() method.
   * test cases were based off PA1 -8.1
   * @return 
   */  
  
  @Test 
   
 public void isCalculated()
  {
    UVI uvi;
    
    //test 1
    uvi = new UVI(5.5, true);
    assertTrue(uvi.isCalculated());
     
    //test 2
    uvi = new UVI(-1.0, false);
    assertFalse(uvi.isCalculated()); 
  }
  
  
  /**
   * Unit tests for the toString() method.
   * test cases were based off PA1 -8.1
   * @return 
   */  
  
  @Test
  public void toStringTest()
  {
    UVI uvi;
    
    //test 1
    uvi = new UVI(4.0, false);
    assertEquals(" 4", uvi.toString());
    
    //test 2
    uvi = new UVI(4.2, false);
    assertEquals(" 4", uvi.toString());
    
    //test 3
    uvi = new UVI(4.5, false);
    assertEquals(" 5", uvi.toString());
    
    //test 4
    uvi = new UVI(4.6, false);
    assertEquals(" 5", uvi.toString());
    
    // test 5
    uvi = new UVI(12.0, false);
    assertEquals("12", uvi.toString());
    
    //test 6
    uvi = new UVI(12.2, false);
    assertEquals("12", uvi.toString());
    
    //test 7
    uvi = new UVI(12.5, false);
    assertEquals("13", uvi.toString());
    
    //test 8
    uvi = new UVI(12.6, false);
    assertEquals("13", uvi.toString());
    
    //test 9
    uvi = new UVI(143.0, false);
    assertEquals("NA", uvi.toString());
    
    //test 10
    uvi = new UVI(143.2, false);
    assertEquals("NA", uvi.toString());
    
    //test 11 
    uvi = new UVI(143.5, false);
    assertEquals("NA", uvi.toString());
    
    //test 12
    uvi = new UVI(143.6, false);
    assertEquals("NA", uvi.toString());
   
    // test 13
    uvi = new UVI(100.0, false);
    assertEquals("NA", uvi.toString());
   
  }


}
