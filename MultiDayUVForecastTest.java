import static org.junit.Assert.*;

import java.util.prefs.BackingStoreException;

import org.junit.Test;

public class MultiDayUVForecastTest
{
  UVI low = new UVI(6,true);
  UVI high = new UVI(7,true);
  
  DailyUVReport sunday = new DailyUVReport(low,high,67,false);
  DailyUVReport monday = new DailyUVReport(low,high,68,false);
  DailyUVReport tuesday = new DailyUVReport(low,high,69,false);
  DailyUVReport wednesday = new DailyUVReport(low,high,70,false);
  DailyUVReport thursday = new DailyUVReport(low,high,71,false);
  DailyUVReport friday = new DailyUVReport(low,high,72,false);
  DailyUVReport saturday = new DailyUVReport(low,high,73,false);

  @Test
  public void testConstructor()
  {
    MultiDayUVForecast week = new MultiDayUVForecast(3);
    assertEquals(3, week.getFirstDayOfWeek());
    
    week = new MultiDayUVForecast(6);
    assertEquals(6, week.getFirstDayOfWeek());
    
    week = new MultiDayUVForecast(0);
    assertEquals(0, week.getFirstDayOfWeek());
  }
  
  @Test (expected = IndexOutOfBoundsException.class)
  public void testConstructorExceptions()
  {
    MultiDayUVForecast week;
    week = new MultiDayUVForecast(-1);
  }
  
  @Test
  public void testAddDailyUVReport()
  {
    MultiDayUVForecast week = new MultiDayUVForecast(3);
    
    try
    {
      week.addDailyUVReport(wednesday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    assertNotEquals((week.getDailyUVReport(3)).getRange(), wednesday.getRange());
    
    try
    {
      week.addDailyUVReport(thursday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    assertNotEquals((week.getDailyUVReport(4)).getLow(), thursday.getLow());
    
    try
    {
      week.addDailyUVReport(friday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    assertNotEquals((week.getDailyUVReport(5)).getLow(), friday.getLow());
    
    try
    {
      week.addDailyUVReport(saturday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    assertNotEquals((week.getDailyUVReport(6)).getLow(), saturday.getLow());
    
    try
    {
      week.addDailyUVReport(sunday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
      assertEquals(4, week.getFirstDayOfWeek());
    }
    
    try
    {
      week.addDailyUVReport(monday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
      assertEquals(4, week.getFirstDayOfWeek());
    }
    
    try
    {
      week.addDailyUVReport(tuesday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
      assertEquals(4, week.getFirstDayOfWeek());
    }
  }
  
  @Test
  public void testGetter()
  {
    MultiDayUVForecast week = new MultiDayUVForecast(3);
    
    try
    {
      week.addDailyUVReport(wednesday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    assertEquals(wednesday.getRange(),(week.getDailyUVReport(3)).getRange());
  }
  
  @Test (expected = IndexOutOfBoundsException.class)
  public void testExceptions2()
  {
  MultiDayUVForecast week = new MultiDayUVForecast(3);
    
    try
    {
      week.addDailyUVReport(wednesday);
    }
    catch(BackingStoreException e)
    {
      e.printStackTrace();
    }
    week.getDailyUVReport(-1);
  }
  
  @Test
  public void getterNull()
  {
    MultiDayUVForecast week = new MultiDayUVForecast(3);
    assertNull(week.getDailyUVReport(2));
  }
}
