package cosc236.lab9;

import java.util.*;
public class TimeSpan implements Comparable<TimeSpan>{
    private int hours;
    private int minutes;

    public TimeSpan(int hours1, int minutes1) {
        hours = 0;
        minutes = 0;
        add(hours1, minutes1);
    }

    public void add(int hours1, int minutes1) {
        hours += hours1;
        minutes += minutes1;
        while (minutes > 60) {
            minutes -= 60;   // convert 60 min --> 1 hour
            hours++;
        }
    }

    public void add(TimeSpan time) {
        add(time.hours, time.minutes);
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public String toString() {
        return hours + "h-" + minutes + "m";
    }

    //  *** Your method code here ***

    /**
     * For the TimeSpan class described below, add a compareTo method that takes another TimeSpan object as a parameter & returns:
     *       -1 if this TimeSpan is SMALLER than to the TimeSpan object passed in as a parameter
     *        0 if both TimeSpans are the same
     *        1 if this TimeSpan is GREATER than the TimeSpan object passed in as a parameter
     * Add code, as needed, to allow the Collections class to sort the ArrayList of TimeSpan objects
     * @param o Timespan object
     * @return
     *       -1 if this TimeSpan is SMALLER than to the TimeSpan object passed in as a parameter\n
     *        0 if both TimeSpans are the same
     *        1 if this TimeSpan is GREATER than the TimeSpan object passed in as a parameter
     */

    @Override
    public int compareTo(TimeSpan o) {
        return Double.compare(this.getTotalHours(), o.getTotalHours());
        //alternatively, this longer bit of code can be used:
        /*
            if(this.getTotalHours() > o.getTotalHours()) {
                return 1;
            } else if(this.getTotalHours() < o.getTotalHours()) {
                return -1;
            } else {
                return 0;
            }
         */
    }
    public static void main(String[] args) {
        TimeSpan t1 = new TimeSpan(4, 13);
        TimeSpan t2 = new TimeSpan(5, 8);
        TimeSpan t3 = new TimeSpan(3, 51);
        TimeSpan t4 = new TimeSpan(6, 76);
        TimeSpan t5 = new TimeSpan(1, 1);
        ArrayList<TimeSpan> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}