import java.time.LocalDate;
import java.time.*;
import java.util.Comparator;

public class SortByOpeningHour implements Comparator<Attraction> {

    DayOfWeek day;

    SortByOpeningHour(DayOfWeek day)
    {
        this.day = day;
    }

    public int compare(Attraction attraction1, Attraction attraction2)
    {
        Visitable visitable1 = (Visitable) attraction1;
        Visitable visitable2 = (Visitable) attraction2;

        LocalTime openingHour1 = visitable1.getOpeningHour(day);
        LocalTime openingHour2 = visitable2.getOpeningHour(day);

        LocalTime closingHour1 = visitable1.getClosingHour(day);
        LocalTime closingHour2 = visitable2.getClosingHour(day);

        //lucru adaugat pentru TravelPlan -> sa compar si ora deschiderii si ora inchiderii
        if(openingHour1.compareTo(openingHour2) == 0) // adica ora deschiderii este egala
        {
            return closingHour1.compareTo(closingHour2);
        }
        return openingHour1.compareTo(openingHour2);
    }
}
