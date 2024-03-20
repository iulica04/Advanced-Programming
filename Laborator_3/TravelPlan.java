import java.util.*;
import java.time.*;
import java.time.DayOfWeek;

public class TravelPlan {
    Trip trip;
    Map<Integer, List<Attraction>> plan;

    TravelPlan()
    {
        plan = new HashMap<>();
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setTravelPlan()
    {
        PeriodOfTime periodOfTime = trip.getPeriodOfTime();
        String city = trip.getCity();
        System.out.println("Number of days: " + trip.numberOfDays());

        List<Attraction> attractionList = trip.getAttractions();
        System.out.println("Number of attractions: " + attractionList.size());

        LocalDate currentDay = periodOfTime.getFirst();

        int numberOfDays = trip.numberOfDays();
        int numberOfAttractions = attractionList.size();
        int numberOfAttractionPerDay;
        int attractionRest = 0;
        int dayRest = 0;
        int days=0;

        /** Logica din patele acestei alocari: incercam sa alocam un numar constant de atractii pe zi
         * daca avem mai multe zile decat atractii -> sigur o sa ramana niste zile de pauza
         * daca avem mai multe atractii -> impartim numarul de atractii la numarul de zile pentru a vedea cate atractii vizitam pe zi
         * daca aceaste doua numere nu sunt divizibile -> vom avea niste atractii a caror numar este mai mic decat numarul zilelor
         *    incercam ca din prima zi sa mai adaugam cate o atractie din acest rest pana cand numarul lor devine 0
         * PRIORITARE sunt atractiile care nu sunt platite -> pe acestea incercam sa le vizitam prima data*/
        if(numberOfAttractions >= numberOfDays)
        {
             numberOfAttractionPerDay = numberOfAttractions / numberOfDays;
             attractionRest = numberOfAttractions % numberOfDays;
        }
        else
        {
             numberOfAttractionPerDay = numberOfDays / numberOfAttractions;
             dayRest = numberOfDays % numberOfAttractions;
        }
        System.out.println("Number of atraction per day: " + numberOfAttractionPerDay + "  Rest: " + attractionRest);

        List<Attraction> addedAttraction = new ArrayList<>();
        List<Attraction> freeAttraction = trip.getVisitableNotPayableAttraction();

        for(int i=1; i<= numberOfDays; i++)
        {
            List<Attraction> attractionsForIDay = new ArrayList<>();
            List<Attraction> freeAttractionPerDay = trip.getVisitableNotPayableAttractionSorted(currentDay.getDayOfWeek());


            if(freeAttraction.size() == addedAttraction.size())
            {

                System.out.println("Am adaugat toate locatiile free posibile de vizitat.");
                i--;
                break;
            }
            System.out.println("day "+i);
            days++;


            if(freeAttractionPerDay.size() > numberOfAttractionPerDay)
            {

                if(attractionRest != 0)
                {
                    numberOfAttractionPerDay++;
                    attractionRest--;
                }
                for(int j=0; j<numberOfAttractionPerDay; j++)
                {
                    if(!addedAttraction.contains(freeAttractionPerDay.get(j))) {
                        addedAttraction.add(freeAttractionPerDay.get(j));
                        attractionsForIDay.add(freeAttractionPerDay.get(j));
                    }
                }

            }
            else
            {
                numberOfAttractionPerDay = freeAttractionPerDay.size();
                for(int j=0; j<numberOfAttractionPerDay; j++)
                {
                    if(!addedAttraction.contains(freeAttractionPerDay.get(j))) {
                        addedAttraction.add(freeAttractionPerDay.get(j));
                        attractionsForIDay.add(freeAttractionPerDay.get(j));
                    }
                }
            }

            plan.put(i, attractionsForIDay);
            currentDay = currentDay.plusDays(1L);

        }
        int newNumberOfDays = numberOfDays -days;
        numberOfAttractions = attractionList.size() - addedAttraction.size(); // cate atractii mai avem de vizitat

        if(numberOfAttractions >= numberOfDays)
        {
            numberOfAttractionPerDay = numberOfAttractions / newNumberOfDays;
            attractionRest = numberOfAttractions % newNumberOfDays;
        }
        else
        {
            numberOfAttractionPerDay = newNumberOfDays / numberOfAttractions;
            dayRest = newNumberOfDays % numberOfAttractions;
        }


        List<Attraction> payableAttractions = trip.getPayableAttraction();
        int index=0;
        for(int i=days+1; i<= numberOfDays; i++)
        {
            List<Attraction> attractionsForIDay = new ArrayList<>();
            if(attractionRest != 0)
            {
                numberOfAttractionPerDay++;
                attractionRest--;
            }

            int j=0;
            while(j<numberOfAttractionPerDay)
            {
                attractionsForIDay.add(payableAttractions.get(index));
                index++;
                j++;
            }
            plan.put(i, attractionsForIDay);
        }

        for(Integer key : plan.keySet())
        {
            System.out.println("In day " + key + ": " + plan.get(key));
        }

    }

}
