package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.Flight;

import java.io.*;
import java.util.Collection;
import java.util.List;
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
  public void saveChanges(Flight flight) throws IOException {
    List<Flight> collected = this.getAll().stream()
            .map(x -> {
              if (x.getId() == flight.getId()) {

                try {
                  return Flight.parse(String.format("%s;%s;%s;%s;%s", flight.getId()
                          , flight.getDestination()
                          , flight.getDateTime().toString()
                          , (flight.getAllSeats() - (new DAOBookingFile().getById(flight.getId())
                                  .get().getPassengerList().size()))
                          , flight.getAllSeats()));
                } catch (FileNotFoundException e) {
                  throw new IllegalArgumentException("DAOFlightFile->saveChanges : DAOBooking->getById method ");
                }
              } else return x;
            }).collect(Collectors.toList());
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
    for (Flight flight1 : collected){
      bw.write(flight1.fileFormat());
      bw.write("\n");
    }
    bw.close();
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
