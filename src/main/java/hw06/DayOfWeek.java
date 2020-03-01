package hw06;

public enum DayOfWeek {
  SUNDAY,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY;

  static DayOfWeek name(String name){
    name = name.trim();
    name = name.toLowerCase();
    switch (name){
      case "sunday" : return SUNDAY;
      case "monday" : return MONDAY;
      case "tuesday" : return TUESDAY;
      case "wednesday" : return WEDNESDAY;
      case "thursday" : return THURSDAY;
      case "friday" : return FRIDAY;
      case "saturday" : return SATURDAY;
      default: throw new IllegalArgumentException("Wrong input!");
    }
  }
}
