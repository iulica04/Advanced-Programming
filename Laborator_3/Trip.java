import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
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


    public List<Attraction> getVisitableNotPayableAttractionSorted(DayOfWeek day)
    {
        List<Attraction> freeAttractions = new ArrayList<>();
        for(Attraction attraction : attractions)
        {
            if(attraction instanceof Visitable && !(attraction instanceof Payable))
            {
                freeAttractions.add(attraction);
            }

        }

        Collections.sort(freeAttractions, new SortByOpeningHour(day));
        return freeAttractions;
    }

    public List<Attraction> getVisitableNotPayableAttraction()
    {
        List<Attraction> freeAttractions = new ArrayList<>();
        for(Attraction attraction : attractions)
        {
            if(attraction instanceof Visitable && !(attraction instanceof Payable))
            {
                freeAttractions.add(attraction);
            }

        }
        return freeAttractions;
    }

    public List<Attraction> getPayableAttraction()
    {
        List<Attraction> payableAttractions = new ArrayList<>();
        for(Attraction attraction : attractions)
        {
            if(attraction instanceof Visitable && attraction instanceof Payable)
            {
                payableAttractions.add(attraction);
            }

        }
        return payableAttractions;
    }

    public int numberOfDays()
    {
        LocalDate first = periodOfTime.getFirst();
        LocalDate second = periodOfTime.getSecond();

        return (int)ChronoUnit.DAYS.between(first, second);
    }
}
