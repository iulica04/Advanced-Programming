package Entities;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "authors")
@NamedQueries({
        @NamedQuery(name = "Author.findAll",
                query = "select e from Author e order by e.name"),
})

public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
