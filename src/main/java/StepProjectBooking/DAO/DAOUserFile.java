package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class DAOUserFile implements DAO<User> {
  //private final File file = new File("StepProjectBooking/Data/flights.txt");

  public DAOUserFile() {
  }

  @Override
  public List<User> getAll() throws FileNotFoundException {


    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public Optional<User> getById(int id) {


    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public void saveChanges(User user) {

  }

  @Override
  public void create() {
    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public void remove() {
    throw new IllegalArgumentException("Not implemented");
  }
}
