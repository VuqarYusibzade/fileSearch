import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Faylin adini daxil edin(cixmaq isteyirsinizse e daxil edin): ");
            String fileName = scanner.nextLine();

            if (fileName.equals("e")) {
                System.out.println("Program dayandirilir...");
                break;
            }

            searchFile(fileName);
        }

        scanner.close();
    }

    public static void searchFile(String fileName) {
        Path configFilePath = Paths.get("C:\\Users\\yusib\\IdeaProjects\\HomeWorkFiles\\src\\main\\java\\org\\example\\DriverDate.txt"); // Config faylının yolu
        Path startPath = Paths.get(System.getProperty("user.dir"));

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().startsWith(fileName)) {
                        System.out.println("Fayl tapildi: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
