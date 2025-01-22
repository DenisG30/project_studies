/* 
Напишите функцию с тремя параметрами (путь к каталогу, расширение файла и булев флажок), которая возвращает список из двух списков имён:
список всех файлов с заданным расширением в заданном каталоге (включая файлы из его подкаталогов одного уровня вложенности, если флажок = true),
и список всех подкаталогов в заданном каталоге (включая подкаталоги одного уровня вложенности, если флажок = true).
*/



import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MakeList {
    public static List<List<String>> listName (String path, String extension, boolean flag) {
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        File dir = new File(path);
        File[] elements = dir.listFiles();
        if (elements != null) {
            for (File element : elements) {
                // Если это подкаталог
                if (element.isDirectory()) {
                    listTwo.add(element.getName());
                    if (flag) {
                        List<List<String>> res = listName(element.getAbsolutePath(), extension, true);
                        listOne.addAll(res.get(0));
                        listTwo.addAll(res.get(1));
                    }
                } else {
                    // Если это файл с нужным расширением
                    if (element.getName().endsWith(extension)) {
                        listOne.add(element.getName());
                    }
                }
            }
        }
    listOfLists.add(listOne);
    listOfLists.add(listTwo);
    return listOfLists;
    }
}
