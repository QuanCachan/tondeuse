import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MowItNow {
    private Pelouse pelouse;
    private List<Tondeuse> tondeuses;

    public MowItNow(String path) throws IOException {
        initiatePelouse(path);
        initiateTondeuses(path);
    }

    private void initiateTondeuses(String path) throws IOException {
        Stream<String> fileStream = Files.lines(Paths.get(path));
        Stream<String> newStream = fileStream.skip(1);
        List<List<String>> tondeuseList = newStream.collect(TondeuseCollector.pairCollector());
        this.tondeuses = initiateTondeusesFromList(tondeuseList);
    }

    private List<Tondeuse> initiateTondeusesFromList(List<List<String>> tondeuseList) {
        List<Tondeuse> tondeuses = new ArrayList<>();
        for (List<String> list : tondeuseList) {
            Tondeuse tondeuse = initiateTondeuse(list);
            tondeuses.add(tondeuse);
        }
        return tondeuses;
    }

    private Tondeuse initiateTondeuse(List<String> list) {
        String tondeuseDescriptions = list.get(0);
        Tondeuse res = validateTondeuseDescriptions(tondeuseDescriptions);

        String tondeuseInstructions = list.size() == 2 ? list.get(1) : "";
        String instructions = validateTondeuseInstructions(tondeuseInstructions);
        res.setInstructions(instructions);
        return res;
    }

    private String validateTondeuseInstructions(String tondeuseInstructions) {
        String trimmedInput =  tondeuseInstructions.trim();

        String regex = "^[ADG]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input for initializing Tondeuse instructions.\n" +
                    "Input format must be: Chain of these characters: A|D|G.\n" +
                    "For example: AADAADADDA");
        }

        return trimmedInput;
    }

    private Tondeuse validateTondeuseDescriptions(String tondeuseDescriptions) {
        String trimmedInput =  tondeuseDescriptions.trim();

        String regex = "^(\\d+)\\s(\\d+)\\s([NEWS])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input for initializing Tondeuse.\n" +
                    "Input format must be: Positive long number-Space-positive longNumber-N|E|W|S.\n" +
                    "For example: 1 2 E");
        }

        Long width = Long.parseLong(matcher.group(1));
        Long height = Long.parseLong(matcher.group(2));

        if (width > pelouse.getWidth() || height > pelouse.getHeight()) {
            throw new IllegalArgumentException("Tondeuse must be located in Pelouse. First input must be less than "+this.getPelouse().getWidth()+
                    " and second input must be greater than "+this.getPelouse().getHeight());
        }

        return new Tondeuse(width, height, matcher.group(3));
    }

    private void initiatePelouse(String path) throws IOException {
        Stream<String> fileStream = Files.lines(Paths.get(path));
        Optional<String> firstLineOpt = fileStream.findFirst();
        firstLineOpt.ifPresent(this::initiatePelouseFromString);
    }


    private void initiatePelouseFromString(String inputFirstLine) {
        String trimmedInput =  inputFirstLine.trim();

        String regex = "^(\\d+)\\s(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input for initializing Pelouse.\n" +
                    "Input format must be: Positive long number-Space-positive longNumber.\n" +
                    "For example: 4 6");
        }

        this.pelouse = new Pelouse(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)));
    }

    public Pelouse getPelouse() {
        return pelouse;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }

    public List<String> moveTondeuses() {
        List<String> res = new ArrayList<>();
        for (Tondeuse tondeuse : this.tondeuses) {
            res.add(tondeuse.move(this.pelouse));
        }
        return res;
    }
}
