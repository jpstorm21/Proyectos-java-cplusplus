/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author mab02
 */
import java.util.Date;

public class Cat extends Pet {
    
  private boolean indoor;
  
  public Cat(String idPet, String name, String breed, Date inscriptionDate, boolean sex, boolean sterilized, boolean indoor)
  {
    super(idPet, name, breed, inscriptionDate, sex, sterilized);
    this.indoor = indoor;
  }
  
  public boolean getIndoor() {
    return indoor;
  }
  
  public void setIndoor(boolean indoor) {
    this.indoor = indoor;
  }
}
