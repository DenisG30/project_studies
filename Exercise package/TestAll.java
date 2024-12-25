import MyMath.MyGeoMath;
import MyTestGeo.TestGeo;

public class TestAll {
    public static void main(String[] args){
        double r = TestGeo.rad() / 2 / Math.PI;
        System.out.println("Площадь окружности с данным радиусом равна: " + Math.PI * (r*r));
    }
}