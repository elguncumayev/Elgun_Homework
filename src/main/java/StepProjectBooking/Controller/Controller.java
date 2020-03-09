package StepProjectBooking.Controller;

import StepProjectBooking.Services.Services;

public class Controller {
  private Services service;

  public Controller() {
    service = new Services();
  }

  public String showMenu() {
   return service.getMenu();
  }

  public String allInfo() {
    return service.getAllInfo();
  }

  public String byID(int id) {
    return service.getByID(id);
  }
}
