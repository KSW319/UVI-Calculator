import static org.junit.Assert.*;

import org.junit.Test;

public class UVICalculatorTest
{

  @Test
  public void calculateUVI()
  {
    new UVICalculator();
    
    double[] array1 = {4.0,26.0,30,17.0,2.0};
    assertEquals(" 9",(UVICalculator.calculateUVI(array1).toString()));
    
    double[] array2 ={0,0,0,0,0};
    assertEquals(" 0",(UVICalculator.calculateUVI(array2).toString()));
    
    double[] array3 = {4.0,26.0,30,100.0,2.0};
    assertEquals(" 9",(UVICalculator.calculateUVI(array3).toString()));
    
    double[] array4 = {4.0,26.0,30,200.0,2.0};
    assertEquals(" 9",(UVICalculator.calculateUVI(array4).toString()));
    
    double[] array5 = {3.4,0.0,17.0,17.0,2.0};
    assertEquals(" 4",(UVICalculator.calculateUVI(array5).toString()));
    
    double[] array6 = {3.4,-10.0,17.0,17.0,2.0};
    assertEquals(" 4",(UVICalculator.calculateUVI(array6).toString()));
    
    double[] array7 = null;
    assertNull((UVICalculator.calculateUVI(null)));
    
    double[] array8 = {1.0};
    assertNull((UVICalculator.calculateUVI(array8)));
  }
  
  @Test
  public void estimateUVI()
  {
    UVI uvi;
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.4, true, true);
    assertEquals(" 4",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.4, true, false);
    assertEquals(" 3",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.4, false, true);
    assertEquals(" 7",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.4, false, false);
    assertEquals(" 6",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.0, true, true);
    assertEquals(" 4",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.0, true, false);
    assertEquals(" 3",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.0, false, true);
    assertEquals(" 7",uvi.toString());
    
    uvi = UVICalculator.estimateUVI(400.0, 30.0, 0.0, false, false);
    assertEquals(" 6",uvi.toString());
  }
  
    @Test
    public void findMaximum()
    {
      UVI[] data;
      UVI result;
      UVI result2;
      UVI result3;
      
      result = new UVI(49, true);
      result2 = new UVI(59, true);
      result3 = new UVI(69, true);
      data = new UVI[]{result, result2, result3};
      double test = UVICalculator.findMaximum(data, true);
      assertTrue(test == 69);
     
      result = new UVI(49, true);
      result2 = new UVI(59, true);
      result3 = new UVI(69, true);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      result = new UVI(101, true);
      result2 = new UVI(59, true);
      result3 = new UVI(49, true);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == 59);
      
      result = new UVI(69, false);
      result2 = new UVI(59, false);
      result3 = new UVI(49, false);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      result = new UVI(49, false);
      result2 = new UVI(59, false);
      result3 = new UVI(69, false);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      result = new UVI(69, false);
      result2 = new UVI(59, false);
      result3 = new UVI(49, false);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == 69);
      
      result = new UVI(10, true);
      result2 = new UVI(99, true);
      result3 = new UVI(47, true);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == 99);
      
      result = new UVI(10, false);
      result2 = new UVI(99, false);
      result3 = new UVI(47, false);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      result = new UVI(10, true);
      result2 = new UVI(99, false);
      result3 = new UVI(47, true);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, true);
      assertTrue(test == 47);
      
      result = new UVI(10, true);
      result2 = new UVI(99, false);
      result3 = new UVI(47, false);
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == 99);
      
      data = new UVI[0];
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      data = null;
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == Double.NEGATIVE_INFINITY);
      
      result = null;
      result2 = new UVI(49, false);
      result3 = null;
      data = new UVI[]{result, result2, result3};
      test = UVICalculator.findMaximum(data, false);
      assertTrue(test == 49);
    }
    
  
  }


