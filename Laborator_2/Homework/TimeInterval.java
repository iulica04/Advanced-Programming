package Compulsory;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * The TimeInterval class represents a time interval between two LocalDateTime objects.
 */
public class TimeInterval {
    /**
     * The start time of the time interval.
     */
    LocalDateTime startTime;

    /**
     * The end time of the time interval.
     */
    LocalDateTime endTime;

    /**
     * Constructs a new TimeInterval object with default values.
     */
    TimeInterval() {
    }

    /**
     * Constructs a new TimeInterval object with specified start and end times.
     * If the start time is not before the end time, an invalid time interval message is printed.
     *
     * @param startTime The start time of the interval.
     * @param endTime   The end time of the interval.
     */
    TimeInterval(LocalDateTime startTime, LocalDateTime endTime) {
        if (!startTime.isBefore(endTime)) {
            System.out.println("Invalid time interval.");
            return;
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the time interval between the start and end times.
     *
     * @return A string representation of the time interval.
     */
    public String getTimeInterval() {
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();

        return "Time interval is: " + hours + " hours.";
    }

    /**
     * Returns a string representation of the TimeInterval object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "TimeInterval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
