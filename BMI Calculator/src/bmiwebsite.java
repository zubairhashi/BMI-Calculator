
/*
 * Name: Zubair Hashi
 * Description: this program redi
 * Date: 02/08/2023
 * 
 */


import java.awt.Desktop;
import java.io.*;
import java.net.URI;
  
public class bmiwebsite {
    public void website()
             throws Exception
    {
        Desktop desk = Desktop.getDesktop();
        
        // now we enter our URL that we want to open in our
        // default browser
        desk.browse(new URI("https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html"));
    }
}
