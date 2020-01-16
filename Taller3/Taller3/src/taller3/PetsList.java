package taller3;

/**
 *
 * @author mab02
 */
import ucn.StdOut;
public class PetsList{
    
  private int quantityPets;
  private int max;
  private Pet[] pets;
  
  public PetsList(int max)
  {
    quantityPets = 0;
    this.max = max;
    pets = new Pet[max];
  }
  
  public boolean addPet(Pet pet) { if (quantityPets == 0) {
      pets[0] = pet;
      quantityPets += 1;
      return true;
    }
    if (quantityPets < max) {
      pets[quantityPets] = pet;
      quantityPets += 1;
      return true;
    }
    return false;
  }
  
  public boolean removePet(String id)
  {
    boolean result = false;
    if (quantityPets == 0) {
      StdOut.println("There are no registered pets");
    } else {
      for (int i = 0; i < quantityPets; i++) {
        if (pets[i].getIdPet().equalsIgnoreCase(id)) {
          for (int j = i; j < quantityPets; j++) {
            pets[j] = pets[(j + 1)];
            quantityPets -= 1;
            result = true;
          }
        }
      }
    }
    return result;
  }
  
  public Pet searchPet(String id)
  {
    for (int i = 0; i < quantityPets; i++) {
      if (pets[i].getIdPet().equalsIgnoreCase(id)) {
        break;
      }
    }
    if (i == quantityPets) {
      return null;
    }
    return pets[i];
  }
  
  public int getQuantityVets() {
    return quantityPets;
  }
  
  public Pet getPetI(int i) {
    return pets[i];
  }
}