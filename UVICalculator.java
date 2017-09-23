/**
 * A utility class for performing numerical calculations.
 * @author      Kyler Wheeler
 * @version     V.3
 *
 *
 * This work complies with the JMU Honor Code.
 */
public class UVICalculator
{
  private static final Interval VALID_RADIATION = new Interval('[',0.0,100.0,']');
  
  private static final double ALTITUDE_ADJUSTMENT = .05;
  private static final double OVERCAST_ADJUSTMENT = .50;
  private static final double SNOWCOVER_ADJUSTMENT = .10;
  private static final double A = 12.50;
  private static final double D_O = 300.00;
  private static final double P = 2.42;
  private static final double Q = -1.23;
  private static final double B = 25;
  private static final double[] MD_WEIGHTS = {28.65, 3.94,0.16,0.03,0.02};
  /**
   * This method calculates the UV index using the given equation.
   * @param radiation values being brought in
   * @return the UV index
   */
  public static UVI calculateUVI(double[] radiation)
  {
    double val;
    double total;
    val = 0;
    
    if((radiation == null) || (radiation.length != MD_WEIGHTS.length))
    {
      return null;
    }
    total = 0;
    for(int ii = 0; ii < MD_WEIGHTS.length; ii++)
    {
      val = VALID_RADIATION.closestTo(radiation[ii]);
      total += MD_WEIGHTS[ii] * val;
    }
    
    return new UVI(total/B, true);
    
  }
  /**
   * This method calculates the estimated UV index using the given equation.
   * @param ozoneThickness Given to represent the thickness of ozone
   * @param angle given angle at which the sun is hitting the panels
   * @param altitude the distance above sea level
   * @param overcast boolean stating if there is an overcast or not
   * @param snowcover boolean stating if there is snowcover or not
   * @return the estimated UV index
   */
  public static UVI estimateUVI(double ozoneThickness, double angle, double altitude, 
                          boolean overcast, boolean snowcover)
  {
    double val;
    double val2;
    UVI uvi3;
    
    
    val = A * (Math.pow(Math.cos(Math.toRadians(angle)), P)) * (Math.pow((ozoneThickness/D_O), Q));
    val2 = val + (altitude * ALTITUDE_ADJUSTMENT * val);
    
    if(overcast)
    {
      val2 = val2 - (OVERCAST_ADJUSTMENT * val);
    }
    if(snowcover)
    {
      val2 = val2 + (SNOWCOVER_ADJUSTMENT * val);
    }
    
    uvi3 = new UVI(val2,false);
    return uvi3;
    
  }
  /**
   * This method finds the maximum value in a UVI array.
   * @param data passes in a UVI array
   * @param calculated gives the true/false value
   * @return max, the maximum value in the array
   */
  public static double findMaximum(UVI[] data, boolean calculated)
  {
    Interval interval = findRange(data,calculated);
    if(interval == null)
    {
      return Double.NEGATIVE_INFINITY;
    }
    return interval.getRightEndPoint();

  }
  /**
   * This method finds the range within the interval.
   * @param data passes in the UVI array
   * @param calculated tells if true or false
   * @return range represented by low and high in the interval
   */
  public static Interval findRange(UVI[] data, boolean calculated)
  {
    boolean bool = false;
    double min = Double.POSITIVE_INFINITY;
    double max = Double.NEGATIVE_INFINITY;
    Interval range;
    range = null;
    if(data == null)
    {
      return null;
    }
    for(int ii = 0; ii < data.length; ii++)
    {
      if(data[ii] != null)
      {
        if(data[ii].isCalculated() == calculated)     
        {
          bool = true;
          if(data[ii].getValue() > max)
          {
            max = data[ii].getValue();
          }
          if(data[ii].getValue() < min)
          {
            min = data[ii].getValue();
          }
            
        }
          
      }
      if(!bool)
      {
        return null;
      }
    }
    range = new Interval(min, max);
    return range;
  }
}
