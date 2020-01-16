
package taller3;

/**
 *
 * @author mab02
 */
import ucn.StdOut;
import ucn.StdOut;


public class OwnersList {
  private int quantityOwners;
  private int max;
  private Owner[] owners;
  
  public OwnersList(int max)
  {
    quantityOwners = 0;
    this.max = max;
    owners = new Owner[max];
  }
  
  public boolean addOwners(Owner owner) { if (quantityOwners == 0) {
      owners[0] = owner;
      quantityOwners += 1;
      return true;
    }
    if (quantityOwners < max) {
      owners[quantityOwners] = owner;
      quantityOwners += 1;
      return true;
    }
    return false;
  }
  
  public boolean removeOwners(String rut)
  {
    boolean result = false;
    if (quantityOwners == 0) {
      StdOut.println("There are no registered owners");
    } else {
      for (int i = 0; i < quantityOwners; i++) {
        if (owners[i].getRut().equalsIgnoreCase(rut)) {
          for (int j = i; j < quantityOwners; j++) {
            owners[j] = owners[(j + 1)];
            quantityOwners -= 1;
            result = true;
          }
        }
      }
    }
    return result;
  }
  
  public Owner searchOwner(String rut)
  {
    for (int i = 0; i < quantityOwners; i++) {
      if (owners[i].getRut().equalsIgnoreCase(rut)) {
        break;
      }
    }
    if (i == quantityOwners) {
      return null;
    }
    return owners[i];
  }
  
  public int getQuantityOwners() {
    return quantityOwners;
  }
  
  public Owner getOwnerI(int i) {
    return owners[i];
  }
}