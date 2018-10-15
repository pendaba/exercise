package main.java.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateAPITest {

    public static void main(String[] args) {
//        clockTest();
//        timezonesTest();
        localTimeTest();
    }

    /**
     * Clock
     * Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的，并可用于替代System.currentTimeMillis()方法来获取当前的毫秒时间。
     * 当前时间线上的时刻可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。
     */
    public static void clockTest(){
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant); // legacy java.util.Date

    }
    /**
     * Timezones
     * 时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获取。时区类还定义了一个偏移量，用来在当前时刻或某时间与目标时区时间之间进行转换。
     */
    public static void timezonesTest(){
        System.out.println(ZoneId.getAvailableZoneIds());
        // prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
    // ZoneRules[currentStandardOffset=+01:00]
    // ZoneRules[currentStandardOffset=-03:00]
    }
    /**
     *  LocalTime
     *  本地时间类表示一个没有指定时区的时间，例如，10 p.m.或者17：30:15，下面的例子会用上面的例子定义的时区创建两个本地时间对象。然后我们会比较两个时间，并计算它们之间的小时和分钟的不同。
     */
    public static void localTimeTest(){
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween); // -3
        System.out.println(minutesBetween); // -239
    }



    }
