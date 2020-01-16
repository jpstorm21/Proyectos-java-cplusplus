
package taller3;

/**
 *
 * @author mab02
 */
import java.util.Date;

public class Owner extends Person
{
  private Date regitrationDate;
  PetsList pets;
  
  public Owner(String rut, String fullName, Date regitrationDate)
  {
    super(rut, fullName);
    this.regitrationDate = regitrationDate;
    pets = new PetsList(20);
  }
  
  public Date getRegitrationDate() {
    return regitrationDate;
  }
  
  public void setRegitrationDate(Date regitrationDate) {
    this.regitrationDate = regitrationDate;
  }
  
  public PetsList getPets() {
    return pets;
  }
  
  public void setPets(PetsList pets) {
    this.pets = pets;
  }

}