package StepProjectBooking.Services;

import StepProjectBooking.Concretes.Flight;
import StepProjectBooking.Concretes.User;
import StepProjectBooking.DAO.DAO;
import StepProjectBooking.DAO.DAOFlightMainFile;
import StepProjectBooking.DAO.DAOUserFile;
import StepProjectBooking.DAO.DAOUsersOfFlightsFile;

public class Services {
  DAO<Flight> daoMain = new DAOFlightMainFile();
  DAO<User> daoUser = new DAOUserFile();
  DAO<Integer> daoIds = new DAOUsersOfFlightsFile();
  public String getMenu(){
    StringBuilder sB = new StringBuilder();
    sB.append("1. **Online-board**\n")
            .append("2. **Show the flight info**\n")
            .append("3. **Search and book a flight**\n")
            .append("4. **Cancel the booking**\n")
            .append("5. **My flights**\n")
            .append("6. **Exit**");
    return sB.toString();
  }

  public String getAllInfo() {
    daoMain.getAll();
    throw new IllegalArgumentException("not Implemented");
  }

  public String getByID(int id) {
    daoMain.getById(id);
    throw new IllegalArgumentException("not Implemented");
  }
}
