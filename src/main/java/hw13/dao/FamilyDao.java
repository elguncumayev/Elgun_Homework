package hw13.dao;

import java.util.List;

public interface FamilyDao<T> {
  List<T> loadData();
  void saveToLocal();
  List<T> getAllFamilies();
  T getFamilyByIndex(int index);
  boolean deleteFamily(int index);
  boolean deleteFamily(T t);
  void saveFamily(T t);
}
