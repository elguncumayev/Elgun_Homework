package hw13.dao;

import hw13.Family.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao<Family> {
  private String filename = "E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\hw13\\dao\\localData";
  private List<Family> familyList = new ArrayList<>();

  @Override
  public List<Family> loadData() {
    try( ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filename))))) {
//      ArrayList<Family> families = new ArrayList<>();
//      while (true ){
//        Family family = (Family) ois.readObject();
//        if(family == null) break;
//        else families.add(family);
//      }
      return (List<Family>) ois.readObject();
    }
    catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException("Something went wrong seriously...", e);
    }
  }

  @Override
  public void saveToLocal() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))))){
      oos.writeObject(this.familyList);
    }
    catch (IOException e) {
      throw new RuntimeException("Something went wrong seriously...", e);
    }
  }

  @Override
  public List<Family> getAllFamilies() {
    return this.familyList;
  }

  @Override
  public Family getFamilyByIndex(int index) {
    return this.familyList.get(index);
  }

  @Override
  public boolean deleteFamily(int index) {
    if(index<0 || index>this.familyList.size()) return false;
    this.familyList.remove(index);
    return true;
  }

  @Override
  public boolean deleteFamily(Family o) {
    if(!this.familyList.contains(o)) return false;
    this.familyList.remove(o);
    return true;
  }

  @Override
  public void saveFamily(Family o) {
    if(this.familyList.contains(o)){
      int i = this.familyList.indexOf(o);
      this.familyList.set(i,o);
    }
    else this.familyList.add(o);
  }
}
