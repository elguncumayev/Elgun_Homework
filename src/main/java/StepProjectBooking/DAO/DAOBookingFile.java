package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DAOBookingFile implements DAO<Booking> {
  private final String filename = "E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\StepProjectBooking\\Data\\booking.txt";
  @Override
  public Collection<Booking> getAll() throws FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
    return br.lines().map(Booking::parse).collect(Collectors.toList());
  }

  @Override
  public Optional<Booking> getById(int id) {

    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public void saveChanges(Booking booking) throws IOException {
    Collection<Booking> collected = getAll().stream().map(x -> {
      if (x.getID() == booking.getID()) {
        return new Booking(x.getID(),x.union(booking.getPassengerList()));
      } else return x;
    }).collect(Collectors.toList());
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
    for (Booking booking1 : collected) {
      bw.write(booking1.fileFormat());
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
