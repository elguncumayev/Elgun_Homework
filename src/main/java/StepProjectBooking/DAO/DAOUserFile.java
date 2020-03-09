package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class DAOUserFile implements DAO<User> {
  //private final File file = new File("StepProjectBooking/Data/flightsMainInfo.txt");

  public DAOUserFile() {
  }

  @Override
  public List<User> getAll() throws FileNotFoundException {


    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public User getById(int id) {


    throw new IllegalArgumentException("Not implemented");
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
