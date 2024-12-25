package MyTestGeo;

import java.util.Scanner;
import MyMath.MyGeoMath;

public class TestGeo {
    public static double rad(){
        Scanner in = new Scanner(System.in); 
        double r = in.nextDouble();
        //System.out.println(MyGeoMath.circleLen(r));
        return MyGeoMath.circleLen(r);
        
  } 


}
