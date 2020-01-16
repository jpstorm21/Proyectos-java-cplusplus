package taller3;

/**
 *
 * @author mab02
 */
import java.util.Date;
public class Vet extends Person {
    
  private Date contractDate;
  private String specialization1;
  private String specialization2;
  
  public Vet(String rut, String fullName, Date contractDate, String specialization1, String specialization2)
  {
    super(rut, fullName);
    this.contractDate = contractDate;
    this.specialization1 = specialization1;
    this.specialization2 = specialization2;
  }
  
  public Date getContractDate() {
    return contractDate;
  }
  
  public void setContractDate(Date contractDate) {
    this.contractDate = contractDate;
  }
  
  public String getSpecialization1() {
    return specialization1;
  }
  
  public void setSpecialization1(String specialization1) {
    this.specialization1 = specialization1;
  }
  
  public String getSpecialization2() {
    return specialization2;
  }
  
  public void setSpecialization2(String specialization2) {
    this.specialization2 = specialization2;
  }
}
