
public record Document(String name, String format) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String format() {
        return format;
    }
}
