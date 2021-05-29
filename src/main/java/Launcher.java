import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/valid.txt";
        MowItNow test = new MowItNow(path);
        test.moveTondeuses();
    }
}
