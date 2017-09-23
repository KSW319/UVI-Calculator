/**
 * A class for assigning the UVI value and calculated.
 * @author      Kyler Wheeler
 * @version     V.2
 *
 *
 * This work complies with the JMU Honor Code.
 */
public class UVI
{
  private static final Interval VALID = new Interval('[',0.0, Double.POSITIVE_INFINITY,')');
  private static final Interval PRINTABLE = new Interval('[',0.0, 100.0,']');
  private static final String NA = "NA";
  private double value;
  private boolean calculated;
 /**
  * Constructor is used to assign value and calculated.
  * @param value The value being passed in
  * @param calculated the boolean variable stating if true or false
  */
  public UVI(double value, boolean calculated)
  {
    
    if(VALID.contains(value))
    {
      this.value = value;
    }
    else
    {
      this.value = VALID.getLeftEndPoint();
    }
    this.calculated = calculated;
  }
 
 /**
  * Accessor method used to get the value from the constructor.
  * @return a double representation of the value
  */
  public double getValue()
  {
    return value;
  }
 /**
  * Accessor method used to return the boolean calculated.
  * @return the boolean representation of calculated
  */
  public boolean isCalculated()
  {
   
    return calculated;
  }
 /**
  * toString method used to print out the formatted values.
  * @return a String representation of value
  */
  public String toString()
  {
    if(PRINTABLE.contains(value))
    {
      return String.format("%2.0f", value);
    }
    else
    {
      return NA;
    }
    
  }
}
