import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");


    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from, INPUT_FORMATTER);
        this.to = LocalDate.parse(to, INPUT_FORMATTER);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(OUTPUT_FORMATTER) + " to: " + to.format(OUTPUT_FORMATTER) + ")";
    }

    @Override
    public String toFileFormat() {
        return "E" + super.toFileFormat() + " | " + from.format(INPUT_FORMATTER) + " | " + to.format(INPUT_FORMATTER);
    }
}
