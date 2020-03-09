package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.Flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class DAOFlightMainFile implements DAO<Flight> {
  private final String filename = "StepProjectBooking/Data/flightsMainInfo.txt";
  @Override
  public List<Flight> getAll() throws FileNotFoundException {
    BufferedReader bR = new BufferedReader(new FileReader(new File(filename)));
    bR.lines().map(Flight::parse)
    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public Flight getById(int id) {
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
