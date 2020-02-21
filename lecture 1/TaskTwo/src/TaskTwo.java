public class TaskTwo {

    /**
     * This method displays bytes in a convenient way
     * @param value - bytes input
     */
    public static void printBytes(long value) {
        String[] format = new String[] {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int i = 0;
        double bytes = (double)value;
        for (; bytes >= 1024; bytes /= 1024, i++) {}
        System.out.println(String.format("%.1f", bytes) + " " + format[i]);
    }

    public static void main(String[] args) {
        printBytes(23);
        printBytes(28);
        printBytes(25000);
        printBytes(1024);
        printBytes(5674839345L);
        printBytes(53692044905543L);
        printBytes(Long.MAX_VALUE);
    }
}
/*
output:
23,0 B
28,0 B
24,4 KB
1,0 KB
5,3 GB
48,8 TB
8,0 EB
 */
