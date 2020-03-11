package StepProjectBooking.FileConverter;

import StepProjectBooking.Concretes.User;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class TextToBinary {
  public static void convertUsersFile(File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    List<User> collected = br.lines().map(User::parse).collect(Collectors.toList());
    br.close();
    File f = new File("E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\StepProjectBooking\\Data\\usersBIN.bin");

    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
    oos.writeObject(collected);
    oos.close();
  }

  public static void convertFlightsMainFile(File file){

  }

  public static void main(String[] args) throws IOException {
    File file = new File("E:\\0Elgun\\BACKEND\\Elgun_Homework\\src\\main\\java\\StepProjectBooking\\Data\\users.txt");
    convertUsersFile(file);
    System.out.println("Okay");
  }
}
