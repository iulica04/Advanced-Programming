import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public record Person(String name, int id) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return id;
    }

    @JsonCreator
    public Person(@JsonProperty("name") String name, @JsonProperty("id") int id) {
        this.name = name;
        this.id = id;
    }
}
