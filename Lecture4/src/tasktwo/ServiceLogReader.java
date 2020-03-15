package tasktwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ServiceLogReader {

    /**
     * Paths to log files.
     */
    private Path[] paths;

    /**
     * Constructs {@code ServiceLogReader} for reading logs from {@param filesPaths}
     * @param filesPaths - a set of file paths.
     */
    public ServiceLogReader(String[] filesPaths) {
        setNewPaths(filesPaths);
    }

    /**
     * Sets the new file paths.
     * @param filesPaths - a set of file paths.
     */
    public void setNewPaths(String[] filesPaths) {
        Objects.requireNonNull(filesPaths, "Null paths");
        if (filesPaths.length == 0)
            throw new IllegalArgumentException();
        paths = new Path[filesPaths.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = Paths.get(filesPaths[i]);
        }
    }

    /**
     * Prints all logs to the standard output stream.
     * This method uses ArrayList.sort() method for sorting strings.
     */
    public void createOutLog() {
        ArrayList<String> stringBuffer = new ArrayList<>();
        Comparator<String> comparator =
                Comparator.comparingInt(o -> Integer.parseInt(o.replaceAll("\\D", "") ) );
        BufferedReader[] bufferedReaders = new BufferedReader[paths.length];
        //init readers
        for (int i = 0; i < paths.length; i++) {
            try {
                bufferedReaders[i] = Files.newBufferedReader(paths[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //reading from all files
        while (checkFiles(bufferedReaders)) {
            for (int i = 0; i < bufferedReaders.length; i++) {
                try {
                    if (bufferedReaders[i].ready()) {
                        stringBuffer.add(bufferedReaders[i].readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (i == bufferedReaders.length - 1) {
                    stringBuffer.sort(comparator);
                    printOut(stringBuffer);
                }
            }
        }
        try {
            closeReaders(bufferedReaders);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private void closeReaders(BufferedReader[] bufferedReaders) throws IOException {
        Objects.requireNonNull(bufferedReaders, "Null buffered readers");
        for (BufferedReader bufferedReader : bufferedReaders)
            bufferedReader.close();
    }

    private boolean checkFiles(BufferedReader[] bufferedReaders) {
        Objects.requireNonNull(bufferedReaders);
        boolean check = false;
        for (BufferedReader bufferedReader : bufferedReaders) {
            try {
                if (bufferedReader.ready()) {
                    check = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    private void printOut(ArrayList<String> stringBuffer) {
        Objects.requireNonNull(stringBuffer);
        while (!stringBuffer.isEmpty())
            System.out.println(stringBuffer.remove(0));
    }

    public static void main(String[] args) {
        ServiceLogReader serviceLogReader = new ServiceLogReader(args);
        serviceLogReader.createOutLog();
    }
}

/*
    input:
        log1:   1 hi
                4 i am here
                7 i am a programmer
                10 do you like Java?
                12 TreeSet is used here
                14 Hey, this is 14th line
                15 Kek
                16 Shrek

        log2:   0 hahahah
                2 hello
                5 me too
                8 it was a joke
                10 yes, of course
                13 Maybe HashSet?

        log3:   3 hi everyone
                6 so am i
                9 i'm not sure
                11 and c++
                13 No, the best set is SortedSet!
    output:
        1 hi
        2 hello
        3 hi everyone
        4 i am here
        5 me too
        6 so am i
        7 i am a programmer
        8 it was a joke
        9 i'm not sure
        10 do you like Java?
        10 yes, of course
        11 and c++
        12 TreeSet is used here
        13 Maybe HashSet?
        13 No, the best set is SortedSet!
        14 Hey, this is 14th line
        15 Kek
        16 Shrek
 */

