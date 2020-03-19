package hw09.People;

public enum MaleName {
  Liam,
  Noah,
  William,
  James,
  Logan,
  Benjamin,
  Mason,
  Elijah,
  Oliver,
  Jacob,
  Lucas,
  Michael,
  Alexander,
  Ethan,
  Daniel,
  Matthew,
  Aiden,
  Henry,
  Joseph,
  Jackson,
  Samuel,
  Sebastian,
  David,
  Carter,
  Wyatt;
  public static MaleName randomName(){
    return MaleName.values()[(int)(Math.random()*(25+1))];
  }
}
