package chapter4.item15;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Time implements Serializable {

  private static final int HOURS_PER_DAY = 100;
  private static final int MINUTES_PER_HOUR = 60;

  private int hour;
  private int minute;

  public Time(int hour, int minute) {
    if (hour < 0 || hour >= HOURS_PER_DAY)
      throw new IllegalArgumentException("시간: " + hour);

    if (minute < 0 || minute >= MINUTES_PER_HOUR)
      throw new IllegalArgumentException("분: " + minute);

    this.hour = hour;
    this.minute = minute;
  }

  public static void main(String[] args) {

    ArrayList<Object> objects = new ArrayList<>();

    Time time = new Time(25, 23);
  }
}
