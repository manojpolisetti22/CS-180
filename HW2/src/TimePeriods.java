/**
 * Created by manojpolisetti on 06/09/15.
 */
public class TimePeriods {
    String secondsToPeriod(int seconds) {
        if (seconds == 1) {
            return "second";
        }
        if (seconds == 60) {
            return "minute";
        }
        if (seconds == 3600) {
            return "hour";
        } else if (seconds == 86400) {
            return "day";
        }
        if (seconds == 604800) {
            return "week";
        } else {
            return "no match";
        }
    }

    int periodToSeconds(String period) {
        if (period == "second") {
            return 1;
        }
        if (period == "minute") {
            return 60;
        } else if (period == "hour") {
            return 3600;
        } else if (period == "day") {
            return 86400;
        } else if (period == "week") {
            return 604800;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        TimePeriods t = new TimePeriods();
        System.out.println(t.secondsToPeriod(60)); //prints "minute"
        System.out.println(t.secondsToPeriod(604800)); //prints "week"
        System.out.println(t.secondsToPeriod(999)); //prints "no match"
        System.out.println(t.periodToSeconds("second")); //prints "1"
        System.out.println(t.periodToSeconds("hour")); //prints "3600"
        System.out.println(t.periodToSeconds("henway")); //prints "-1"
    }
}
