import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File[] dirs = new File[]{
                new File("/home/nworly/Games/temp"),
                new File("/home/nworly/Games/src"),
                new File("/home/nworly/Games/src/main"),
                new File("/home/nworly/Games/src/test"),
                new File("/home/nworly/Games/res"),
                new File("/home/nworly/Games/res/drawables"),
                new File("/home/nworly/Games/res/vectors"),
                new File("/home/nworly/Games/res/icons"),
                new File("/home/nworly/Games/savegames"),
        };

        File[] files = new File[]{
                new File("/home/nworly/Games/src/main/Main.java"),
                new File("/home/nworly/Games/src/main/Utils.java"),
                new File("/home/nworly/Games/temp/temp.txt")
        };

        StringBuilder sb = new StringBuilder();

        for (File dir : dirs) {
            if (dir.mkdir()) {
                sb.append("Создан каталог ").append(dir.getAbsolutePath()).append("\n");
            }
        }

        try {
            for (File file : files) {
                if (file.createNewFile()) {
                    sb.append("Создан файл ").append(file.getAbsolutePath()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("/home/nworly/Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
