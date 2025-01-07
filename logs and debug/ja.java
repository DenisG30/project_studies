import java.util.logging.Level;
import java.util.logging.Logger;

public class ja {
    public static final Logger logger = Logger.getLogger(ja.class.getName());

    public int count(int bank, double percent) {
        logger.log(Level.INFO, "Data {0} and {1}", new Object[]{bank, percent});
        double res = bank * (percent/100) + bank; 
        assert res >= 0 : "Values can't be negative!";
        logger.log(Level.INFO, "Result of expression: {0}", res);
        return (int)res;
    }     

    public static void main(String[] args) {
          ja start = new ja();
         try {
            start.count(-10000, 20);
         } catch (AssertionError e) {
            logger.log(Level.SEVERE, "Assertion failed: {0}", e.getMessage());
         }

     }
}