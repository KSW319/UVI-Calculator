/**
 * Used to create an interval.
 * @author      Kyler Wheeler
 * @version     V.1 2/18/2016
 *
 *
 * This work complies with the JMU Honor Code.
 */
public class Interval
{
  private static final String DEFAULT_FORMAT = "%5.1f";
  private boolean leftClosed;
  private boolean rightClosed;
  private double left;
  private double right;
  /**
   * Constructor used to set up the interval.
   * @param leftSymbol gets the symbol for the left
   * @param left gets left value
   * @param right gets right value
   * @param rightSymbol gets the symbol for the tight
   */
  public Interval(char leftSymbol, double left, double right, char rightSymbol) 
  {
    if(left > right)
    {
      throw new IllegalArgumentException("bad");
    }
    
    if(leftSymbol == '[')
    {
      leftClosed = true;
    }
    if(rightSymbol == ']')
    {
      rightClosed = true;
    }
    this.left = left;
    this.right = right;
  }
  /**
   * Override constructor used to create open interval.
   * @param left gives left value
   * @param right gives right value
   */
  public Interval(double left, double right)
  {
    this('(',left,right,')');
  }
  /**
   * Copy constructor used to copy the interval.
   * @param other gives left and right
   * @throws IllegalArgumentException if no memory allocated for interval
   */
  public Interval(Interval other) throws IllegalArgumentException
  {
    if(other == null)
    {
      throw new IllegalArgumentException("bad val");
    }
    this.left = other.left;
    this.right = other.right;
    this.leftClosed = other.leftClosed;
    this.rightClosed = other.rightClosed;
    
  }
  /**
   * method used to give the closest number to the left/right values.
   * @param number gives value
   * @return a double representing left/right
   */
  public double closestTo(double number)
  {
    if(number >= left && number <= right)
    {
      return number;
    }
    if(number < left)
    {
      return left;
    }
    else
    {
      return right;
    }
  }
  /**
   * method used to check if values are contained in the interval.
   * @param number representing the value in the interval
   * @return true if contained false if not
   */
  public boolean contains(double number)
  {
    return (leftClosed && number >= left && number < right
        ||number <= right && rightClosed && number > left 
        ||number > left && number < right);
  }
  /**
   * Getter method used to get the left end point.
   * @return double representing left end point
   */
  public double getLeftEndPoint()
  {
    return left;
  }
  /**
   * Getter method used to get the right end point.
   * @return double representing right end point
   */
  public double getRightEndPoint()
  {
    return right;
  }
  /**
   * Getter method used to see if left end point is included.
   * @return true if included false if not
   */
  public boolean isLeftEndPointIn()
  {
    return leftClosed;
  }
  /**
   * Getter method used to see if right end point is included.
   * @return true if included false if not
   */
  public boolean isRightEndPointIn()
  {
    return rightClosed;
  }
  /**
   * method used to print out the interval.
   * @param format used to see if bracket or parenthesis
   * @return string of interval
   */
  public String toString(String format)
  {
    String s = "";
    if(leftClosed)
    {
      s += '[';
    }
    else
    {
      s += '(';
    }
    s += String.format(format, left)+ ',' + String.format(format, right);
    if(rightClosed)
    {
      s += ']';
    }
    else
    {
      s += ')';
    }
    return s;
  }
  /**
   * method used to give the string a certain format.
   * @return formatted stringget
   */
  public String toString()
  {
    return toString(DEFAULT_FORMAT);
  }
}
