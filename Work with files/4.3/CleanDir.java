import java.io.File;


public class CleanDir {
    public static boolean cleanDir (String way) {
        File direc = new File(way);
        File[] arr = direc.listFiles();
        if (arr == null){
            return direc.delete();
        } 
        for (File file : arr) {
            if (!file.exists()) {
                return false;
            }    
        } 
        return direc.delete();
    }     
}