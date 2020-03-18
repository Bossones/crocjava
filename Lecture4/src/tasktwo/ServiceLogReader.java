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

    private int indexOfNextPrint;

    private int isOpen;

    /**
     * Constructs {@code ServiceLogReader} for reading logs from {@param filesPaths}
     *
     * @param filesPaths - a set of file paths.
     */
    public ServiceLogReader(String[] filesPaths) {
        setNewPaths(filesPaths);
        indexOfNextPrint = 0;
        isOpen = filesPaths.length;
    }

    /**
     * Sets the new file paths.
     *
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
     */
    public void createOutLog() {
        boolean check = true;
        String[] stringsBuffer = new String[paths.length];
        BufferedReader[] bufferedReaders = openReaders();
        for (int i = 0; i < paths.length; i++) {
            try {
                if ((stringsBuffer[i] = bufferedReaders[i].readLine()) == null) {
                    isOpen--;
                    stringsBuffer[i] = "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (isOpen != 0) {
            printNextStringLog(stringsBuffer);
            try {
                readNextStringLog(stringsBuffer, bufferedReaders);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            closeReaders(bufferedReaders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printNextStringLog(String[] stringsBuffer) {
        Objects.requireNonNull(stringsBuffer, "Strings buffer is null");
        String toPrint = stringsBuffer[0];
        indexOfNextPrint = 0;
        for (int i = 1; i < stringsBuffer.length; i++) {
            if (!stringsBuffer[i].equals("")) {
                if (Integer.parseInt(toPrint.replaceAll("[ ].+", "")) >
                        Integer.parseInt(stringsBuffer[i].replaceAll("[ ].+", ""))) {
                    toPrint = stringsBuffer[i];
                    indexOfNextPrint = i;
                }
            }
        }
        System.out.println(toPrint);
    }

    private void readNextStringLog(String[] stringsBuffer, BufferedReader[] bufferedReaders) throws IOException {
        Objects.requireNonNull(stringsBuffer, "String buffer is null");
        Objects.requireNonNull(bufferedReaders, "Buffered reader is null");
        if (stringsBuffer.length == 0)
            throw new IllegalArgumentException("String buffer is empty");
        if (bufferedReaders.length == 0)
            throw new IllegalArgumentException("Buffered readers are empty");
        if ((stringsBuffer[indexOfNextPrint] = bufferedReaders[indexOfNextPrint].readLine()) == null) {
            stringsBuffer[indexOfNextPrint] = "";
            isOpen--;
        }
    }

    private BufferedReader[] openReaders() {
        BufferedReader[] bufferedReaders = new BufferedReader[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                bufferedReaders[i] = Files.newBufferedReader(paths[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bufferedReaders;
    }

    private void closeReaders(BufferedReader[] bufferedReaders) throws IOException {
        Objects.requireNonNull(bufferedReaders, "Null buffered readers");
        for (BufferedReader bufferedReader : bufferedReaders)
            bufferedReader.close();
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
        0 hahahah
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

