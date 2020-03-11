package StepProjectBooking;

import StepProjectBooking.Controller.BookingAPP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) throws IOException {
    BookingAPP app = new BookingAPP();
    app.run();

//    LocalDateTime times = LocalDateTime.now();
//    System.out.println(times);
  }
}
