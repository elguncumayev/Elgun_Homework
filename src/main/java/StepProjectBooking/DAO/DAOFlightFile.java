package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.Flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class DAOFlightFile implements DAO<Flight> {
  private final String filename = "E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\StepProjectBooking\\Data\\flights.txt";
  @Override
  public Collection<Flight> getAll() throws FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
    return br.lines().map(Flight::parse).collect(Collectors.toList());
  }

  @Override
  public Optional<Flight> getById(int id) throws FileNotFoundException {
    Collection<Flight> all = this.getAll();
    return all.stream()
            .filter(x -> x.getId() == id)
            .findFirst();
  }

  @Override
  public void saveChanges(Flight flight) {

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
