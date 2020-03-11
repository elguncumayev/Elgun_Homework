package StepProjectBooking.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {
  Collection<T> getAll() throws FileNotFoundException;
  Optional<T> getById(int id) throws FileNotFoundException;
  void saveChanges(T t) throws IOException;
  void create();
  void remove();
}
