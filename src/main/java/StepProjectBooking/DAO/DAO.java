package StepProjectBooking.DAO;

import java.io.FileNotFoundException;
import java.util.List;

public interface DAO<T> {

  List<T> getAll() throws FileNotFoundException;
  T getById(int id);
  void create();
  void remove();
}
