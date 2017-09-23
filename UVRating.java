/**
 * Enumeration of different UVRating objects.
 * @author Kyler Wheeler
 * @version 1.0
 * 
 * This work complies with the JMU honor code
 */
public enum UVRating
{
  INVALID   ("No Information is available", 
      new Interval('[',Double.NEGATIVE_INFINITY,0.0,']'), "Invalid"),
  SAFE      ("No action is necessary", new Interval('[',0.0,1.0,')'), "Safe"),
  LOW       ("Wear sunscreen and/or protective clothes", new Interval('[',1.0,3.0,')'), "Low"),
  MODERATE  ("Stay in shade near midday", new Interval('[',3.0,6.0,')'), "Moderate"),
  HIGH      ("Reduce time in the sun", new Interval('[',6.0,8.0,')'), "High"),
  VERY_HIGH ("Stay indoors between 11AM and 4PM", new Interval('[',8.0,11.0,')'), "Very High"),
  EXTREME   ("Stay indoors", new Interval('[',11.0, Double.POSITIVE_INFINITY,')'), "Extreme");
  
  private final Interval interval;
  private final String action;
  private final String name;
/**
 * Constructor used to make the interval.
 * @param action gives the description of what to do
 * @param interval passes in the interval
 * @param name passes in the name of the interval
 */
  private UVRating(String action, Interval interval, String name)
  {
    this.action = action;
    this.name = name;
    this.interval = interval;
  }
/**
 * Getter method used to get the action.
 * @return String representing what actions to take
 */
  public String getAction()
  {
    return action;
  }
/**
 * Getter method used to get the name. 
 * @return name of the UVRating
 */
  public String getName()
  {
    return name;
  }


}
