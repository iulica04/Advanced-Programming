package Compulsory;
import java.time.LocalDateTime;
import java.time.Duration;

public class TimeInterval {
    LocalDateTime startTime;
    LocalDateTime endTime;

    TimeInterval() {
    }

    TimeInterval(LocalDateTime startTime, LocalDateTime endTime) {
        if(!startTime.isBefore(endTime))
        {
            System.out.println("Invalid time interval.");
            return ;
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTimeInterval()
    {
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();

        return "Time interval is: " + hours + " hours.";
    }


    @Override
    public String toString() {
        return "TimeInterval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
