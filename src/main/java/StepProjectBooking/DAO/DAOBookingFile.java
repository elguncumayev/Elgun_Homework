package StepProjectBooking.DAO;

import StepProjectBooking.Concretes.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBookingFile implements DAO<Booking> {
  private final String filename = "E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\StepProjectBooking\\Data\\booking.txt";

  @Override
  public Collection<Booking> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
      return br.lines().map(Booking::parse).collect(Collectors.toList());
    } catch (IOException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> p) {
    return getAll().stream()
            .filter(p)
            .collect(Collectors.toList());
  }

  @Override
  public Optional<Booking> get(int id) {
    Collection<Booking> all = this.getAll();
    return all.stream()
            .filter(x -> x.getBookingID() == id)
            .findFirst();
  }

  @Override
  public void save(Booking booking) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), true))) {
      bw.write(booking.fileFormat());
      bw.write("\n");
    } catch (IOException e) {
      throw new RuntimeException("Something went wrong: Booking::save()");
    }
  }

  @Override
  public void create() {
    throw new IllegalArgumentException("Not implemented");
  }

  @Override
  public void remove(Booking booking) {
    Collection<Booking> removed = this.getAll();
    removed.remove(booking);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)))) {
      for (Booking book : removed) {
        bw.write(book.fileFormat());
        bw.write("\n");
      }
    } catch (IOException e) {
      throw new RuntimeException("Something went wrong: Booking::remove()");
    }
  }
}
