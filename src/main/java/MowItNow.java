import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Pattern;

public class MowItNow {
    private Pelouse pelouse;

    public MowItNow(String path) throws IOException {
        Optional<String> firstLineOpt = Files.lines(Paths.get(path))
                .findFirst();
        firstLineOpt.ifPresent(this::initiatePelouse);
    }

    private void initiatePelouse(String inputFirstLine) {
        String trimmedInput =  inputFirstLine.trim();

        String regex = "^\\d+\\s\\d+$";
        Pattern pattern = Pattern.compile(regex);

        if (!pattern.matcher(trimmedInput).matches()) {
            throw new IllegalArgumentException("Invalid input for initializing Pelouse");
        }

        String[] strArr = trimmedInput.split("\\s");
        this.pelouse = new Pelouse(Long.parseLong(strArr[0]), Long.parseLong(strArr[1]));
    }

    public Pelouse getPelouse() {
        return pelouse;
    }
}
