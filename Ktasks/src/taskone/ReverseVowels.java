package taskone;

public class ReverseVowels {

    private String inputString;

    private String outputString;

    public ReverseVowels(String inputString) {
        this.inputString = inputString;
    }

    public ReverseVowels() {
        this("");
    }

    public String reverseVowelsInString(String inputString) {
        this.inputString = inputString;
        return reverseVowelsInString();
    }

    public String reverseVowelsInString() {
        if (inputString.equals("") )
            return outputString = "";

        char[] outString = inputString.toCharArray();
        boolean next = true;
        char buffer;
        for (int i = 0, y = outString.length - 1; i != y;) {
            if (next) {
                if (isVowel(outString[i])) {
                    next = false;
                } else i++;
            }
            if (!next) {
                if (isVowel(outString[y])) {
                    buffer = outString[i];
                    outString[i] = outString[y];
                    outString[y] = buffer;
                    next = true;
                    i++;
                }
                if (i != y)
                    y--;
            }
        }
        return outputString = String.copyValueOf(outString);
    }

    private boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'y' || symbol == 'i' || symbol == 'u';
    }

    public String getReversedString() {
        return (outputString == null) ? "" : outputString;
    }

    public static void main(String[] args) {
        ReverseVowels rev = new ReverseVowels("index");
        ReverseVowels rev2 = new ReverseVowels("palindrome");
        ReverseVowels rev3 = new ReverseVowels("garage");
        ReverseVowels rev4 = new ReverseVowels("reflect");
        ReverseVowels rev5 = new ReverseVowels("array");
        System.out.println(rev.reverseVowelsInString());
        System.out.println(rev2.reverseVowelsInString());
        System.out.println(rev3.reverseVowelsInString());
        System.out.println(rev4.reverseVowelsInString());
        System.out.println(rev5.reverseVowelsInString());
    }
}
/*
    input:
        index
        palindrome
        garage
        reflect
        array
    output:
        endix
        pelondrima
        geraga
        reflect
        yrraa
 */
