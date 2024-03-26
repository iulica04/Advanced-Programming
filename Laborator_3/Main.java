import java.time.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Church church = new Church("Notre Dame", "medieval Catholic cathedral", "Ile de la Cite, Paris, France");
        Statue statue = new Statue("La Défense de Paris", "bronze statue by French sculptor Louis-Ernest Barrias", "the Arche de la Défense, Paris, France");
        Concert concert = new Concert("Shadows and Lights - Cultural Olympiad", "", "Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris");
        Church church2 = new Church("Catedrala din Bourges", "", "14 pl Etienne Dolet, 18000 Bourges");
        Statue statue1 = new Statue("Clock Sculpture", "Just outside the Saint-Lazare train station in Paris is a sculpture with clocks….lots of clocks.", " Cour du Havre, 5 Rue d’Amsterdam, 75008 Paris");

        Map<DayOfWeek, TimeInterval> timeIntervalForChurch = new HashMap<>();
        TimeInterval timeInterval1 = new TimeInterval(LocalTime.of(10, 0), LocalTime.of(17, 0));
        timeIntervalForChurch.put(DayOfWeek.MONDAY, timeInterval1);
        timeIntervalForChurch.put(DayOfWeek.TUESDAY, timeInterval1);
        timeIntervalForChurch.put(DayOfWeek.FRIDAY, timeInterval1);
        timeIntervalForChurch.put(DayOfWeek.SUNDAY, timeInterval1);
        church.setTimetable(timeIntervalForChurch);
        church2.setTimetable(timeIntervalForChurch);

        Map<DayOfWeek, TimeInterval> timeIntervalForStatue = new HashMap<>();
        TimeInterval timeInterval2 = new TimeInterval(LocalTime.of(7, 0), LocalTime.of(19, 0));
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            timeIntervalForStatue.put(dayOfWeek, timeInterval2);
        }
        statue.setTimetable(timeIntervalForStatue);
        statue1.setTimetable(timeIntervalForStatue);

        Map<DayOfWeek, TimeInterval> timeIntervalForConcert = new HashMap<>();
        TimeInterval timeInterval3 = new TimeInterval(LocalTime.of(19, 0), LocalTime.of(22, 0));
        timeIntervalForConcert.put(DayOfWeek.FRIDAY, timeInterval3);
        concert.setTimetable(timeIntervalForConcert);

        Attraction[] attractions = {concert, church, statue, church2, statue1};
        PeriodOfTime periodOfTime = new PeriodOfTime(LocalDate.of(2024, 3, 18), LocalDate.of(2024, 3, 20));
        Trip tripInFrance = new Trip();
        tripInFrance.setAttractions(attractions);
        tripInFrance.setCity("Paris");
        tripInFrance.setPeriodOfTime(periodOfTime);

//        System.out.println(tripInFrance);
//
//        List<Attraction> attractionList = tripInFrance.getVisitableNotPayableAttractionSorted(DayOfWeek.MONDAY);
//        System.out.println("Attractions sorted by opening hour: ");
//        for(Attraction attraction: attractionList) {
//            System.out.println(attraction);
//        }


//        TravelPlan travelPlanForParis = new TravelPlan();
//        travelPlanForParis.setTrip(tripInFrance);
//        travelPlanForParis.setTravelPlan();


        TravelPlanWithColoring travel = new TravelPlanWithColoring(tripInFrance);
        travel.planingAttractionsForEachDay();


    }

}



