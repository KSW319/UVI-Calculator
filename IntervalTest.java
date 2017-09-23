import static org.junit.Assert.*;

import org.junit.Test;

public class IntervalTest
{

  @Test
  public void testConstructor()
  {
    Interval interval1 = new Interval('[',4.0,9.0,']');
    Interval interval2 = new Interval('[',4.0,9.0,')');
    Interval interval3 = new Interval('(',4.0,9.0,']');
    Interval interval4 = new Interval('(',4.0,9.0,')');
    
    assertEquals("[  4.0,  9.0]", interval1.toString());
    assertEquals("[  4.0,  9.0)", interval2.toString());
    assertEquals("(  4.0,  9.0]", interval3.toString());
    assertEquals("(  4.0,  9.0)", interval4.toString());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException()
  {
    Interval interval5 = new Interval('[',9.0,4.0,']');
    
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testConstruct()
  {
    Interval interval6 = null;
    Interval copyNull = new Interval(interval6);
  }
  
  @Test
  public void copyConstructor()
  {
    Interval interval7 = new Interval('(',4.0,9.0,')');
    Interval copy = new Interval(interval7);
    
  }
  
  @Test
  public void closestTo()
  {
    Interval interval8 = new Interval('[',4.0,9.0,']');
    
    assertEquals(4.0,interval8.closestTo(1.0),0);
    assertEquals(5.0,interval8.closestTo(5.0),0);
    assertEquals(9.0,interval8.closestTo(12.0),0);
    
  }
  
  @Test
  public void contains()
  {
    Interval interval9 = new Interval('[',4.0,9.0,']');
    Interval interval10 = new Interval('(',4.0,9.0,']');
    Interval interval11 = new Interval('[',4.0,9.0,')');
    Interval interval12 = new Interval('(',4.0,9.0,')');
    
    assertTrue(interval9.contains(4.0));
    assertTrue(interval9.contains(9.0));
    assertFalse(interval9.contains(3.0));
    assertFalse(interval9.contains(10.0));
    
    assertTrue(interval10.contains(5.0));
    assertTrue(interval10.contains(9.0));
    assertFalse(interval10.contains(4.0));
    assertFalse(interval10.contains(10.0));
    
    assertTrue(interval11.contains(4.0));
    assertTrue(interval11.contains(8.0));
    assertFalse(interval11.contains(3.0));
    assertFalse(interval11.contains(9.0));
    
    assertTrue(interval12.contains(5.0));
    assertTrue(interval12.contains(8.0));
    assertFalse(interval12.contains(4.0));
    assertFalse(interval12.contains(9.0));
  }
  
  @Test
  public void getTest()
  {
    Interval interval13 = new Interval('[',4.0,9.0,']');
    
    assertEquals(4.0, interval13.getLeftEndPoint(),0);
    assertEquals(9.0, interval13.getRightEndPoint(),0);
    assertTrue(interval13.isLeftEndPointIn());
    assertTrue(interval13.isRightEndPointIn());
    
  }

}
