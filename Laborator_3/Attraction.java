import java.time.*;
import java.util.*;

public abstract class Attraction implements Comparable<Attraction> {
    private String name;
    private String description;
    private String location;


    @Override
    public int compareTo(Attraction other)
    {
        if(other == null)
            throw new IllegalArgumentException("");
        if(other instanceof Visitable)
        {
           return ((Visitable) this).getOpeningHour(DayOfWeek.MONDAY).compareTo(((Visitable) other).getOpeningHour(DayOfWeek.MONDAY));
        }
        else
        {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}