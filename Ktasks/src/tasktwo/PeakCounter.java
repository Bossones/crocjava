package tasktwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to count max number of calls.
 */
public class PeakCounter {

    private Path pathToLog;

    /**
     * This class is used to store talk time.
     */
    private class TalkTime {

        private int begin;

        private int end;

        private int callTime;

        /**
         * Constructs this {@code TalkTime} to store the talk time.
         * @param begin is beginning of talk time.
         * @param end is end of talk time.
         */
        public TalkTime(int begin, int end) {
            if (begin < 0 || end <= 0 || end < begin)
                throw new IllegalArgumentException("Wrong call time");
            this.begin = begin;
            this.end = end;
            callTime = end - begin;
        }

        public TalkTime() {
            this(0, 0);
        }

        public int getBegin() { return begin; }

        public int getEnd() { return end; }

        public int getCallTime() { return callTime; }
    }

    public PeakCounter(String pathToLog) {
        Objects.requireNonNull(pathToLog, "Path is null");
        this.pathToLog = Paths.get(pathToLog);
    }

    public void setPathToLog(Path pathToLog) {
        this.pathToLog = pathToLog;
    }

    public void setPathToLog(String pathToLog) {
        setPathToLog(Paths.get(pathToLog));
    }

    public int countMaxTalk() {
        ArrayList<TalkTime> talkTimes = new ArrayList<>();
        String buffer;
        try (BufferedReader buf = Files.newBufferedReader(pathToLog)) {
            while ((buffer = buf.readLine() ) != null) {
                talkTimes.add(parseString(buffer) );
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return counter(talkTimes);
    }

    private int counter(ArrayList<TalkTime> talkTimes) {
        Objects.requireNonNull(talkTimes, "talkTimes is null");
        int countMax = 0;
        int count;
        for (int i = 0; i < talkTimes.size(); i++) {
            count = 1;
            if (talkTimes.get(i).getCallTime() < 2)
                continue;
            for (int j = 0; j < talkTimes.size(); j++) {
                if ((i != j) && (talkTimes.get(i).getEnd() >= talkTimes.get(j).getBegin() ) &&
                        (talkTimes.get(j).getEnd() >= talkTimes.get(i).getBegin() ) ) {
                    count++;
                }
            }
            if (countMax < count)
                countMax = count;
        }
        return countMax;
    }

    private TalkTime parseString(String buffer) {
        Objects.requireNonNull(buffer, "String buffer is null");
        int begin = 0;
        int end = 0;
        boolean comma = true;
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == ',') {
                comma = false;
                continue;
            }
            if (comma && Character.isDigit(buffer.charAt(i) ) ) {
                begin = (begin * 10) + (buffer.charAt(i) - 48);
            } else if (!comma && Character.isDigit(buffer.charAt(i) ) ) {
                end = (end * 10) + (buffer.charAt(i) - 48);
            }
        }
        return new TalkTime(begin, end);
    }

    public static void main(String[] args) {
        PeakCounter peakCounter = new PeakCounter("C:\\Users\\Горожанкина\\Desktop\\Учебка\\JavaLearning\\crock\\crockjava\\Ktasks\\resources\\log.txt");
        System.out.println(peakCounter.countMaxTalk());
    }
}
