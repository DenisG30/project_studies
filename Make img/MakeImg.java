import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MakeImg {
    
    static final int OK = 0; // Успешно
    static final int ERROR_DIR = 1; // Не нашли директорию
    static final int ERROR_READ_IMG = 2; // Не удалось прочесть изображение
    static final int ERROR_HANDLE_FILE = 3; // Не удалось обработать файл (главный catch)

    public static HashMap<String, Integer> makeImg(String path, String inputFormat, String outputFormat) {
        
        HashMap<String, Integer> nameAndStatus = new HashMap<String, Integer>();
        
        File file = new File(path);
        File[] files = file.listFiles();

        if (files == null) {
            // System.out.println("Директория не найдена или не является директорией.");
            nameAndStatus.put(path, ERROR_DIR);
            return nameAndStatus;
        }

        for (int i = 0; i < files.length; i++) {
            try {
                if(files[i].isFile() && files[i].getName().contains(inputFormat)) {
                    BufferedImage img = ImageIO.read(files[i]);
                    
                    if (img == null) {
                        nameAndStatus.put(files[i].getName(), ERROR_READ_IMG);
                        //System.out.println("Не удалось прочитать изображение: " + files[i].getName());
                        continue; // Переходим к следующему файлу
                 }
                    
                    String fileName = files[i].getName();
                    String newFileName = path + File.separator + fileName.substring(0, fileName.lastIndexOf('.')) + "." + outputFormat;
                    //String newFileName = (path +  "\\" + fileName.substring(0, fileName.lastIndexOf('.'))) + "." + outputFormat;
                    //System.out.println(newFileName);
                    
                    
                    Graphics2D g = img.createGraphics();
        
                    // очищаем фон
                        g.setBackground(Color.white);
                        g.clearRect(0, 0, img.getWidth(), img.getHeight());  
            
                    // размеры квадрата
                        int w = 100, h = 100;
                        int wFrame = img.getWidth();
                        int hFrame = img.getHeight();
            
                        g.setColor(Color.black); // задать цвет прямоугольника
            
                    // нарисовать прямоугольник:
                        g.drawRect((wFrame-w)/2, (hFrame-h)/2, w, h);
            
                    // Рисуем текст в центре квадрата
                        String text1 = "Hello,";
                        String text2 = "World!";    
                        FontMetrics metrics = g.getFontMetrics(g.getFont());
            
                    // Определяем координаты для первой строки
                        int x1 = (wFrame-w)/2 + (w - metrics.stringWidth(text1)) / 2;
                        int y1 = (hFrame-h)/2 + (h - metrics.getHeight()) / 2 + metrics.getAscent();
            
                    // Определяем координаты для второй строки
                        int x2 = (wFrame-w)/2 + (w - metrics.stringWidth(text2)) / 2;
                        int y2 = y1 + metrics.getHeight(); // смещение на высоту строки
                        
                        g.drawString(text1, x1, y1);
                        g.drawString(text2, x2, y2);
                        
                        g.dispose(); // освобождаем холст
                        
                    
                    // записываем итоговое изображение в файл
                        ImageIO.write(img, outputFormat, new File(newFileName));
                        nameAndStatus.put(files[i].getName(), OK);
                        files[i].delete();
                        //System.out.println("создание успешно!");

            } catch(Exception e) {
                nameAndStatus.put(files[i].getName(), ERROR_HANDLE_FILE);
                //System.out.println("Ошибка при обработке файла: " + files[i].getName());
                //e.printStackTrace();
            }    
        }
        return nameAndStatus;
    }
}
