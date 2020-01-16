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
public class Dog
  extends Pet
{
  private int dangerousLevel;
  
  public Dog(String idPet, String name, String breed, Date inscriptionDate, boolean sex, boolean sterilized, int dangerousLevel)
  {
    super(idPet, name, breed, inscriptionDate, sex, sterilized);
    this.dangerousLevel = dangerousLevel;
  }
  
  public int getDangerousLevel() {
    return dangerousLevel;
  }
  
  public void setDangerousLevel(int dangerousLevel) {
    this.dangerousLevel = dangerousLevel;
  }
}
