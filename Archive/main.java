public class main {
    public static void main(String[] args) {
        String zipName = "Archive.zip";
        String[] filesNames = {"goe.txt", "ende.txt", "starte.txt"};
        addArchiveFiles.AddArchiveFiles(zipName, filesNames);
        System.out.print("All right!");
    } 
}