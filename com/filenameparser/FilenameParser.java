package com.filenameparser;

import java.util.Date;
import java.util.Calendar;

public class FilenameParser {
  private String filename;
  public boolean isFound = false;
  private static Calendar calendar;
  static {
    calendar = Calendar.getInstance();
  }
  public FilenameParser(String filename) {
    parse(filename);
    this.isFound = true;
  }
  public FilenameParser(String filename, int dayOfWeek, int startHour, int endHour) {
    parse(filename);
    if( calendar.get(Calendar.DAY_OF_WEEK)-1 == dayOfWeek &&
        calendar.get(Calendar.HOUR_OF_DAY) >= startHour &&
        calendar.get(Calendar.HOUR_OF_DAY) <= endHour
        ) {
      this.isFound = true;
    }
  }
  public Calendar getCalendar() {
    return this.calendar;
  }
  private void parse(String filename) {
    int year = Integer.parseInt(filename.substring(4, 8));
    int month = Integer.parseInt(filename.substring(8, 10));
    int day = Integer.parseInt(filename.substring(10, 12));
    int hour = Integer.parseInt(filename.substring(13, 15));
    int minute = Integer.parseInt(filename.substring(15, 17));
    int second = Integer.parseInt(filename.substring(17, 19));
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month-1);
    calendar.set(Calendar.DATE, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
  }

}
