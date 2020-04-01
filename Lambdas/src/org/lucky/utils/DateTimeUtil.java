package org.lucky.utils;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Use ZonedDateTime max times
 * For Backward compatability with Date and Calendar, use Instant
 */
public class DateTimeUtil {

    public static void main(String[] args) {
        System.out.println("getCurrentTimeInUTC:" + getCurrentTimeInUTC());
        System.out.println("getCurrentTimeStampAsString:" + DateTimeUtil.getCurrentTimeStampAsString(null));
        //Use of TemporalAdjuster
        System.out.println("getFirstDayOfMonthStartTime:" + getFirstDayOfMonthStartTime(LocalDate.now()));
        System.out.println("getFirstDayOfWeekStartTime:" + getFirstDayOfWeekStartTime(LocalDate.now()));

        //Use of (SQL)Timestamp
        System.out.println("getCurrentTimeInUTCAsTimestamp:" + getCurrentTimeInUTCAsTimestamp());
        System.out.println("getZonedDateTimeFromTimestamp:" + getZonedDateTimeFromTimestamp(Timestamp.from(Instant.now()), "UTC"));

    }

    public static ZonedDateTime getCurrentTimeInUTC(){
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public static String getCurrentTimeStampAsString(String format){
        String pattern = format != null ? format : "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
        return ZonedDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern(pattern));
    }



    /**
     * Use of (SQL)Timestamp
     * Timestamp  holds the number of milliseconds since January 1, 1970, 00:00:00 GMT + nanos
     * It has kind of zonal info(UTC) in that sense but totally depends on DB driver , normally DB save in local zone of server
     * however returns in same timezone as was asked to save(DB driver plays a role here)
     *
     * i.e Below ex also shows(prints) in local zone
     */
    public static Timestamp getCurrentTimeInUTCAsTimestamp(){
        //return Timestamp.from(Instant.now());//Gives System time
        //System.out.println("Test:" + getCurrentTimeInUTC().toInstant());
        //System.out.println("Test1:" + LocalDateTime.now().to);
        return Timestamp.from(getCurrentTimeInUTC().toInstant());
    }

    public static ZonedDateTime getZonedDateTimeFromTimestamp(Timestamp timestamp, String zone){
        //System.out.println("TEST:" + timestamp.toLocalDateTime().atZone(ZoneId.of(zone)));// This gives wrong date
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of(zone));
    }


    //Use of TemporalAdjuster
    public static LocalDateTime getFirstDayOfMonthStartTime(LocalDate date){
        return date.with(TemporalAdjusters.firstDayOfMonth())// date on first of month
                .atStartOfDay();// as LocalDateTime with T00:00
    }

    public static LocalDateTime getFirstDayOfWeekStartTime(LocalDate date){
        /*if(date.getDayOfWeek().equals(DayOfWeek.MONDAY))
            return date.atStartOfDay();
        return date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))// date of monday of week
                .atStartOfDay();// as LocalDateTime with T00:00*/

        //Above logic can be replaced with simple logic below(removed if else)
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))// date of Monday of week
                .atStartOfDay();// as LocalDateTime with T00:00
    }



}
