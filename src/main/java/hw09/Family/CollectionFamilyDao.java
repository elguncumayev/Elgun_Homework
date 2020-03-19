package hw09.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao<Family> {

  private List<Family> familyList = new ArrayList<>();

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
