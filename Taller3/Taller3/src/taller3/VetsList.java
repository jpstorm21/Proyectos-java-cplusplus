package taller3;

import java.io.IOException;
import ucn.StdOut;
/**
 *
 * @author mab020
 */

public class VetsList {
  private int quantityVets;
  private int max;
  private Vet[] vets;
  
  public VetsList(int max)
  {
    quantityVets = 0;
    this.max = max;
    vets = new Vet[max];
  }
  
  public boolean addVet(Vet vet) { if (quantityVets == 0) {
      vets[0] = vet;
      quantityVets += 1;
      return true;
    }
    if (quantityVets < max) {
      vets[quantityVets] = vet;
      quantityVets += 1;
      return true;
    }
    return false;
  }
  
  public boolean removeVet(String rut)
  {
    boolean result = false;
    if (quantityVets == 0) {
      StdOut.println("There are no registered vets");
    } else {
      for (int i = 0; i < quantityVets; i++) {
        if (vets[i].getRut().equalsIgnoreCase(rut)) {
          for (int j = i; j < quantityVets; j++) {
            vets[j] = vets[(j + 1)];
            quantityVets -= 1;
            result = true;
          }
        }
      }
    }
    return result;
  }
  
  public Vet searchVet(String rut)
  {
    for (int i = 0; i < quantityVets; i++) {
      if (vets[i].getRut().equalsIgnoreCase(rut)) {
        break;
      }
    }
    if (i == quantityVets) {
      return null;
    }
    return vets[i];
  }
  
  public int getQuantityVets() {
    return quantityVets;
  }
  
  public Vet getVetI(int i) {
    return vets[i];
  }
}
