package hw05;

import java.util.Arrays;

public class Pet {private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }
    public String[] getHabits() {
        return habits;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up.");
    }

    public String toString() {
        return this.species + "{nickname='" + this.nickname + "', age=" + this.age + ", trickLevel=" + this.trickLevel +
                ", habits=" + Arrays.toString(this.habits) + "}";
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = result*31 + this.nickname.hashCode();
        result = result*31 + this.age;
        result = result*31 + this.trickLevel;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return  true;
        if(!(obj instanceof Pet)) return false;
        Pet that = (Pet) obj;
        return this.nickname.equals(that.nickname) &&
                this.age == that.age &&
                this.trickLevel == that.trickLevel;
    }
    //    private String nickname;
//    private int age;
//    private int trickLevel;
//    private String[] habits;

//       if (o == this) return true;
//    if (!(o instanceof Human)) {
//        return false;
//    }
}
