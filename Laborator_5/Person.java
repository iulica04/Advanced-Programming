public record Person(String name, int id) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return id;
    }
}
