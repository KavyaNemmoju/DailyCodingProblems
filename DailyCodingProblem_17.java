/** 
Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.

For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
*/








import java.util.stream.IntStream;

public class Dailycodingproblem {
    private static class ContentReader {
        private int headerPosition = 0;
        private static String CONTENT = "Hello World hello world";
        public String read7() {
            int len = CONTENT.length();
            if (headerPosition >= len)
                return "";
            String s = CONTENT.substring(headerPosition, Math.min(headerPosition + 7, len));
            headerPosition += 7;
            return s;
        }
    }
    public static String readN(int n) {
        StringBuilder sb = new StringBuilder();
        ContentReader Reader = new ContentReader();
        int readCount = 0;
        while (readCount + 7 < n) {
            readCount += 7;
            sb.append(Reader.read7());
        }
        if (readCount < n) {
            String s = Reader.read7();
            sb.append(s.substring(0, n - readCount));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        IntStream.range(0, 15).mapToObj(Dailycodingproblem::readN).forEach(System.out::println);
    }
}
