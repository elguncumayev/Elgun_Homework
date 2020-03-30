package hw13.People;

import hw13.Family.Family;
import hw13.Services.DayOfWeek;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class Human {
  protected String name;
  protected String surname;
  protected long birthDate;
  protected int iqLevel;
  protected Map<DayOfWeek, ArrayList<String>> schedule;
  protected Family family;


  public Human() {
  }

  public Human(String name, String surname, long timeStamp) {
    this.name = name;
    this.surname = surname;
    this.birthDate = timeStamp;
  }

  public Human(String name, String surname, String dateOfBirth, int iqLevel) {
    this.name = name;
    this.surname = surname;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(dateOfBirth, formatter);
    this.birthDate = localDate.toEpochDay() * 86400000;
    this.iqLevel = iqLevel;
  }

  public Human(String name, String surname, long timeStamp, int iqLevel, Map<DayOfWeek, ArrayList<String>> schedule) {
    this.name = name;
    this.surname = surname;
    this.birthDate = timeStamp;
    this.iqLevel = iqLevel;
    this.schedule = schedule;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }

  public long getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(long birthDate) {
    this.birthDate = birthDate;
  }

  public int getIqLevel() {
    return iqLevel;
  }

  public void setIqLevel(int iqLevel) {
    this.iqLevel = iqLevel;
  }

  public Map<DayOfWeek, ArrayList<String>> getSchedule() {
    return schedule;
  }

  public void setSchedule(Map<DayOfWeek, ArrayList<String>> schedule) {
    this.schedule = schedule;
  }

  public String describeAge() {
    long l = System.currentTimeMillis();
    Instant instantNow = Instant.ofEpochMilli(l);
    LocalDateTime dateNow = instantNow.atZone(ZoneId.systemDefault()).toLocalDateTime();
    Instant instantBirth = Instant.ofEpochMilli(this.birthDate);
    LocalDateTime dateBirth = instantBirth.atZone(ZoneId.systemDefault()).toLocalDateTime();
    Period period = Period.between(dateBirth.toLocalDate(), dateNow.toLocalDate());
    return String.format("%s year %s month %s day", period.getYears(), period.getMonths(), period.getDays());
  }


  public long getAge() {
    Instant instantBirth = Instant.ofEpochMilli(this.birthDate);
    LocalDateTime dateBirth = instantBirth.atZone(ZoneId.systemDefault()).toLocalDateTime();
    return LocalDateTime.now().getYear() - dateBirth.getYear();
  }

  public void deleteFromFamily() {
    this.family = null;
  }

  private String birthDateFormat() {
    Instant instant = Instant.ofEpochMilli(this.birthDate);
    LocalDateTime dateNew = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    return String.format("%s/%s/%s", dateNew.getDayOfMonth(), dateNew.getMonthValue(), dateNew.getYear());
  }

  public String prettyFormat(){
    return String.format("name='%s', surname='%s', birthDate='%s', iq=%s, schedule=%s",
            this.getName(),
            this.getSurname(),
            this.birthDateFormat(),
            this.getIqLevel(),
            this.getSchedule());
  }

  @Override
  public String toString() {
    return String.format("Human{name='%s', surname='%s', year=%s, iq=%d, schedule= %s",
            this.getName(), this.getSurname(), this.birthDateFormat(), this.getIqLevel(), this.schedule);
  }

  @Override
  public int hashCode() {
    long result = 17;
    result = result * 23 + this.name.hashCode();
    result = result * 23 + this.surname.hashCode();
    result = result * 23 + this.getAge();
    result = result * 23 + this.iqLevel;
    return (int) result;
  }

  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Human)) {
      return false;
    }
    Human that = (Human) o;
    return that.name.equals(this.name) &&
            that.surname.equals(this.surname) &&
            that.birthDate == this.birthDate &&
            that.family.equals(this.family) &&
            that.iqLevel == this.iqLevel;
  }

  @Override
  protected void finalize() {
    System.out.printf("Object is deleted: %s\n", this.getClass());
  }
}