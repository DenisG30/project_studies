import java.io.*;
import java.util.zip.*;

public class addArchiveFiles {
    public static void AddArchiveFiles (String zipName, String[] fileNames) {
    try {
    // Создаем временный ZIP файл
        File tempZipFile = new File("Out" + zipName); 
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName));
             ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tempZipFile))) {
                
    // Копируем существующие записи в новый ZIP файл
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                zipOutputStream.putNextEntry(entry);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, length);
                }
                zipOutputStream.closeEntry();
            }
            
    // Добавляем файлы из массива в архив
            for (String fName : fileNames) {
                ZipEntry newEntry = new ZipEntry(fName);
                zipOutputStream.putNextEntry(newEntry);
                zipOutputStream.write(fName.getBytes());
                
                zipOutputStream.closeEntry();    
            }
            zipInputStream.close();
        }
        
    //Удаляем оригинальный ZIP файл и переименовываем временный файл
            File originalZipFile = new File(zipName);
            File doubleZip = originalZipFile;
            if (originalZipFile.delete()) {
                tempZipFile.renameTo(doubleZip);
            } else {
                System.out.println("Не удалось удалить оригинальный ZIP файл.");
            }

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }        
        
    }
}