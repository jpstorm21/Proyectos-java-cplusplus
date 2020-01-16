
package taller3;

/**
 *
 * @author mab02
 */
public abstract class Person
{
  protected String rut;
  protected String fullName;
  public Person(String rut, String fullName)
  {
    this.rut = rut;
    this.fullName = fullName;
  }
  
  public String getRut() {
    return rut;
  }
  
  public void setRut(String rut) {
    this.rut = rut;
  }
  
  public String getFullName() {
    return fullName;
  }
  
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}