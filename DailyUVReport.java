/**
 * Used to create a report for the UVI.
 * @author      Kyler Wheeler
 * @version     V.1
 *
 *
 * This work complies with the JMU Honor Code.
 */
public class DailyUVReport
{
  private static final UVI DEFAULT_HIGH = new UVI (8.9, false);
  private static final UVI DEFAULT_LOW = new UVI (6.3, false);
  private static final double TEMPERATURE_MINIMUM = -50.0;
  private static final double TEMPERATURE_MAXIMUM = 120.0;
  private boolean overcast;
  private double temperature;
  private UVI high;
  private UVI low;
  private String range;
  
  /**
   * Constructor method used to call the setters.
   * @param low brings in the low UVI 
   * @param high brings in the high UVI
   * @param temperature brings in the temperature
   * @param overcast brings in whether there is an overcast
   */
  public DailyUVReport(UVI low, UVI high, double temperature, boolean overcast)
  {
    setOvercast(overcast);
    setTemperature(temperature);
    setConditions(low, high);
  }
  
  /**
   * Getter method used to get the highest UVI value.
   * @return highest UVI value
   */
  public UVI getHigh()
  {
    return high;
  }
  /**
   * Getter method used to get the lowest UVI value.
   * @return lowest UVI method
   */
  public UVI getLow()
  {
    return low;
  }
  /**
   * Method returns a formatted string of the range.
   * @return string of ranges
   */
  public String getRange()
  {
   
    range = String.format("UVI: %2.0f - %2.0f", this.low.getValue(), this.high.getValue());
    return range;
  }
  /**
   * Getter method used to get temperature value.
   * @return the temperature
   */
  public double getTemperature()
  {
    return temperature;
  }
  /**
   * Method used to get overcast value.
   * @return boolean representing overcast
   */
  public boolean isOvercast()
  {
    return overcast;
  }
  /**
   * Setter method used to give on overcast value.
   * @param overcast brings in whether overcast is true or not
   */
  public void setOvercast(boolean overcast)
  {
    this.overcast = overcast;
  }
  /**
   * Setter method used to validate and set temperatures.
   * @param temperature brings in temperatures
   */
  public void setTemperature(double temperature)
  {
    if(TEMPERATURE_MAXIMUM < temperature)
    {
      this.temperature = TEMPERATURE_MAXIMUM;
    }
    else if(TEMPERATURE_MINIMUM > temperature)
    {
      this.temperature = TEMPERATURE_MINIMUM;
    }
    else
    {
      this.temperature = temperature;
    }
  }
  /**
   * Setter method used to validate and set high and low conditions.
   * @param lowUVI brings in low value
   * @param highUVI brings in high value
   */
  public void setConditions(UVI lowUVI, UVI highUVI)
  {
    if(lowUVI == null)
    {
      this.low = DEFAULT_LOW;
    }
    else
    {
      this.low = lowUVI;
    }
    if(highUVI == null)
    {
      this.high = DEFAULT_HIGH;
    }
    else
    {
      this.high = highUVI;
    }
    if(low.getValue() > high.getValue())
    {
      this.low = DEFAULT_LOW;
      this.high = DEFAULT_HIGH;
    }
    
  }
}
