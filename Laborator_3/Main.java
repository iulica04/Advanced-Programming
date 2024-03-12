import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.*;
public class Main {

    public static void main(String args[])
    {
        Attraction church = new Church("Notre Dame","medieval Catholic cathedral", "Ile de la Cite, Paris, France");
        Attraction statue = new Statue("La Défense de Paris", "bronze statue by French sculptor Louis-Ernest Barrias", "the Arche de la Défense, Paris, France");
        Attraction concert = new Concert("Shadows and Lights - Cultural Olympiad", "", "Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris");

        Attraction attractions[] = {concert, church, statue};
        PeriodOfTime periodOfTime = new PeriodOfTime(LocalDateTime.of(2024, 03, 1, 12, 00), LocalDateTime.of(2024, 03, 15, 19, 00));
        Trip tripInFrance = new Trip();
        tripInFrance.setAttractions(attractions);
        tripInFrance.setCity("Paris");
        tripInFrance.setPeriodOfTime(periodOfTime);

        System.out.println(tripInFrance.toString());

    }

}
