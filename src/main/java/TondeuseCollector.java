import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class TondeuseCollector {
    public static Collector<String, List<List<String>>, List<List<String>>> pairCollector() {
        return Collector.of(
                ArrayList::new,
                (list, value) -> {
                    List<String> block = list.isEmpty() ? null : list.get(list.size() - 1);
                    if (block == null || block.size() == 2) {
                        list.add(block = new ArrayList<>(2));
                    }
                    block.add(value);
                },
                (r1, r2) -> { throw new UnsupportedOperationException("Parallel processing not supported"); }
        );
    }
}
