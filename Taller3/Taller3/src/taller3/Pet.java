
package taller3;

/**
 *
 * @author mab02
 */
import java.util.Date;

public abstract class Pet{
    
  protected String idPet;
  protected String name;
  protected String breed;
  protected Date inscriptionDate;
  protected boolean sex;
  protected boolean sterilized;
  
  public Pet(String idPet, String name, String breed, Date inscriptionDate, boolean sex, boolean sterilized)
  {
    this.idPet = idPet;
    this.name = name;
    this.breed = breed;
    this.inscriptionDate = inscriptionDate;
    this.sex = sex;
    this.sterilized = sterilized;
  }
  
  public String getIdPet() {
    return idPet;
  }
  
  public void setIdPet(String idPet) {
    this.idPet = idPet;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getBreed() {
    return breed;
  }
  
  public void setBreed(String breed) {
    this.breed = breed;
  }
  
  public Date getInscriptionDate() {
    return inscriptionDate;
  }
  
  public void setInscriptionDate(Date inscriptionDate) {
    this.inscriptionDate = inscriptionDate;
  }
  
  public boolean getSex() {
    return sex;
  }
  
  public void setSex(boolean sex) {
    this.sex = sex;
  }
  
  public boolean getSterilized() {
    return sterilized;
  }
  
  public void setSterilized(boolean sterilized) {
    this.sterilized = sterilized;
  }
}
