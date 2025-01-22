public class TwoMain {
    public static void main(String[] args) {
        String path = "2";
        String extension = ".txt"; 
        boolean flag = true;
    
        //List<List<String>> result = MakeList(path, extension, flag);
        
        System.out.println("Файлы с расширением " + extension + ": " + MakeList.listName(path, extension, flag).get(0));
        System.out.println("Подкаталоги: " + MakeList.listName(path, extension, flag).get(1));
    }
}
