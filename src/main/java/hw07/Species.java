package hw07;

public enum Species {
  DOMESTICCAT,
  DOG,
  BIRD,
  FISH,
  ROBOCAT,
  UNKNOWN,
  HEDGEHOGS;

  static String name(Species name){
    return name.toString();
  }
}
