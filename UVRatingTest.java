import static org.junit.Assert.*;

import org.junit.Test;

public class UVRatingTest
{

  @Test
  public void testUVRating()
  {
    assertSame("valueOf(INVALID)", UVRating.INVALID, UVRating.valueOf("INVALID"));
    assertSame("valueOf(SAFE)", UVRating.SAFE, UVRating.valueOf("SAFE"));
    assertSame("valueOf(LOW)", UVRating.LOW, UVRating.valueOf("LOW"));
    assertSame("valueOf(MODERATE)", UVRating.MODERATE, UVRating.valueOf("MODERATE"));
    assertSame("valueOf(HIGH)", UVRating.HIGH, UVRating.valueOf("HIGH"));
    assertSame("valueOf(VERY_HIGH)", UVRating.VERY_HIGH, UVRating.valueOf("VERY_HIGH"));
    assertSame("valueOf(EXTREME)", UVRating.EXTREME, UVRating.valueOf("EXTREME"));
    
  }
  
  @Test
  public void testGetAction()
  {
    assertEquals("No Information is available", INVALID.toString());
  }
  
  @Test
  public void testGetName()
  {
    assertEquals("INVALID", UVRating.INVALID.toString());
    assertEquals("SAFE", UVRating.SAFE.toString());
    assertEquals("LOW", UVRating.LOW.toString());
    assertEquals("MODERATE", UVRating.MODERATE.toString());
    assertEquals("HIGH", UVRating.HIGH.toString());
    assertEquals("VERY_HIGH", UVRating.VERY_HIGH.toString());
    assertEquals("EXTREME", UVRating.LOW.toString());
    
  }

}
