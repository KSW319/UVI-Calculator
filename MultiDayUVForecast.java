import java.util.prefs.BackingStoreException;

/**
 * Used to create a multiple day report.
 * @author      Kyler Wheeler
 * @version     V.1
 *
 *
 * This work complies with the JMU Honor Code.
 */
public class MultiDayUVForecast
{
  private static final int CAPACITY = 7;
  private DailyUVReport[] reports;
  private int firstDayOfWeek;
  private int size;
  private DailyUVReport uvReport;

  /**
   * Constructor method used to make sure array has 7 spots.
   * @param firstDayOfWeek int representation of first day.
   * @throws IndexOutOfBoundsException if not in interval
   */
  public MultiDayUVForecast(int firstDayOfWeek) throws IndexOutOfBoundsException
  {
    size =0;
    if(firstDayOfWeek < 0 || firstDayOfWeek >= CAPACITY)
    {
      throw new IndexOutOfBoundsException("bad value");
    }
    reports = new DailyUVReport[CAPACITY];
    this.firstDayOfWeek = firstDayOfWeek;
    
  }
  /**
   * Method used to add a report for each day.
   * @param report the array that gives the days of the week
   * @throws BackingStoreException thrown if called more than 7 times
   */
  public void addDailyUVReport(DailyUVReport report) throws BackingStoreException
  {
    if(size >= CAPACITY)
    {
      throw new BackingStoreException("nah");
    }
    uvReport = new DailyUVReport (report.getLow(), report.getHigh(),
        report.getTemperature(), report.isOvercast());
    
    reports [(firstDayOfWeek + size) % CAPACITY] = new DailyUVReport
    (uvReport.getLow(), uvReport.getHigh(), uvReport.getTemperature(),
            uvReport.isOvercast());
    
    size++;
  }
  /**
   * Getter method used for getting the report for each day.
   * @param dow gives the day of the week
   * @throws IndexOutOfBoundsException if not in interval
   * @return uv report
   */
  public DailyUVReport getDailyUVReport(int dow) throws IndexOutOfBoundsException
  {
    if(dow < 0 || dow >= CAPACITY)
    {
      throw new IndexOutOfBoundsException("no");
    }
    else
    {
      if(reports[dow] == null)
      {
        return null;
      }
      else
      {
        return reports[dow];
      }
    }
  
  }
  /**
   * Getter method used get first day of the week. 
   * @return first day of week
   */
  public int getFirstDayOfWeek()
  {
    return firstDayOfWeek;
  }
}
