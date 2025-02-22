
public class Main{
    public static void main(String[] args) {
       HashMap<String, Integer> res = new HashMap<String, Integer>();
        res = MakeImg.makeImg("test", "jpg", "png");
        System.out.println("");
        for (String key : res.keySet()) {
            switch (res.get(key)) {
                case 0:
                        System.out.println("Создание из изображения: " + key + "– успешно завершено!");
                    break;
                case 1:
                        System.out.println("Директория не найдена или не является директорией.");   
                    break;
                case 2:
                    System.out.println("Не удалось прочитать изображение: " + key);
                    break;
                case 3:
                    System.out.println("Ошибка при обработке файла: " + key);
                    break;
            }
        }
    }
}
