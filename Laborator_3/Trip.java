import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String city;
    private PeriodOfTime periodOfTime;
    private List<Attraction> attractions;

    Trip()
    {
        attractions = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public PeriodOfTime getPeriodOfTime() {
        return periodOfTime;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPeriodOfTime(PeriodOfTime periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    public void setAttractions(Attraction[] attractions) {
        for(Attraction attraction : attractions)
        {
            this.attractions.add(attraction);
        }
    }

    @Override
    public String toString() {
        return "Trip{" + "\n" +
                "city='" + city + '\'' + "\n" +
                ", periodOfTime=" + periodOfTime.toString() + "\n" +
                ", attractions=" + attractions.toString() + "\n" +
                '}';
    }
}
