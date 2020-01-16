/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;
import java.util.Date;
/**
 *
 * @author mab02
 */
public class Attention {

  private String idAttention;
  private Date date;
  private boolean done;
  private String observations;
  private Vet vet;
  private Pet pet;
  
  public Attention(String idAttention, Date date, boolean done, String observations, Vet vet, Pet pet)
  {
    this.idAttention = idAttention;
    this.date = date;
    this.done = done;
    this.observations = observations;
    this.vet = vet;
    this.pet = pet;
  }
  
  public String getIdAttention() {
    return idAttention;
  }
  
  public void setIdAttention(String idAttention) {
    this.idAttention = idAttention;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public boolean getDone() {
    return done;
  }
  
  public void setDone(boolean done) {
    this.done = done;
  }
  
  public String getObservations() {
    return observations;
  }
  
  public void setObservations(String observations) {
    this.observations = observations;
  }
  
  public Vet getVet() {
    return vet;
  }
  
  public void setVet(Vet vet) {
    this.vet = vet;
  }
  
  public Pet getPet() {
    return pet;
  }
  
  public void setPet(Pet pet) {
    this.pet = pet;
  }

    
}

