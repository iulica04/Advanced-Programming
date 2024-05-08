package Entities;

import javax.persistence.*;


@Entity
@Table(name = "authors")
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a ORDER BY a.name"),
        @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = ?1"),
        @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = ?1")

})
public class Author{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;


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

    public void setName(String name) {
        this.name = name;
    }
    
}
