package core.tree;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sugamagarwal
 */
public class Event {

    private LocalDateTime when;
    private String what;

    public Event(LocalDateTime parse, String event1) {
        this.when = parse;
        this.what  = event1;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public static void main(String[] args) {
        List<Event> events = Arrays.asList(
                new Event(LocalDateTime.parse("2017-03-03T09:01:16.111"), "EVENT1"),
                new Event(LocalDateTime.parse("2017-03-03T09:02:11.222"), "EVENT1"),
                new Event(LocalDateTime.parse("2017-04-03T09:04:11.333"), "EVENT1"),
                new Event(LocalDateTime.parse("2017-04-03T09:04:11.333"), "EVENT2"),
                new Event(LocalDateTime.parse("2017-04-03T09:06:16.444"), "EVENT2"),
                new Event(LocalDateTime.parse("2017-05-03T09:01:26.555"), "EVENT3")
        );
        StringBuilder builder = new StringBuilder();
        Map<YearMonth, List<Event>> collect = events.stream().collect(Collectors.groupingBy(event -> YearMonth.from(event.when)));

        collect.forEach((key, value1) -> {
            Map<String, List<Event>> collect1 = value1.stream().collect(Collectors.groupingBy(event -> event.what));
            collect1.forEach((key1, value) -> System.out.println(key.toString() +  " "+ key1 + " "+ value.size()));
        });

    }
}
