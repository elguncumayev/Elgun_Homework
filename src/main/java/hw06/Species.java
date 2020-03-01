package hw06;

public enum Species {
  CAT,
  DOG,
  BIRD,
  FISH,
  HEDGEHOGS;

  static String name(Species name){
    return name.toString();
  }
}
