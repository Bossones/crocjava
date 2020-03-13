package taskone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileWordsCounter {

    private int counterWords;

    private Charset cs;

    private Path path;

    public FileWordsCounter(Path path) {
        this(path, StandardCharsets.UTF_8);
    }

    public FileWordsCounter(Path path, Charset cs) {
        Objects.requireNonNull(cs);
        counterWords = 0;
        setNewPath(path);
        this.cs = cs;
    }

    public int readWords() {
        counterWords = 0;
        try (BufferedReader reader = Files.newBufferedReader(path, cs) ) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                countWords(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counterWords;
    }

    private void countWords(String line) {
        Objects.requireNonNull(line);
        String[] words;
        words = line.split(" ");
        for (String word : words) {
            if (!word.equals(" ") && !word.equals("") )
                counterWords++;
        }
    }

    public void setNewPath(Path path) {
        Objects.requireNonNull(path);
        this.path = path;
    }

    public String pathToString() {
        return path.toString();
    }

    public Path getPath() {
        return path;
    }

    public static void main(String[] args) {
        FileWordsCounter wc = new FileWordsCounter(Paths.get(args[0]) );
        System.out.println(wc.readWords() );
        System.out.println("========");
        Path path = Paths.get("hello.txt");
        wc.setNewPath(path);
        System.out.println(wc.readWords() );
    }
}

/*
    input:
        У   лукоморья   дуб   зелёный;
        Златая цепь   на   дубе том:
        И днём   и   ночью  кот  учёный
        Всё ходит  по  цепи  кругом;
    output:
        20
        ========
        20
 */