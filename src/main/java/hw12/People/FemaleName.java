package hw12.People;

public enum FemaleName {
  Emma,
  Olivia,
  Ava,
  Isabella,
  Sophia,
  Charlotte,
  Mia,
  Amelia,
  Harper,
  Evelyn,
  Abigail,
  Emily,
  Elizabeth,
  Mila,
  Ella,
  Avery,
  Sofia,
  Camila,
  Aria,
  Scarlett,
  Victoria,
  Madison,
  Luna,
  Grace,
  Chloe;
  public static FemaleName randomName(){
    return FemaleName.values()[(int)(Math.random()*(25))];
  }
}
