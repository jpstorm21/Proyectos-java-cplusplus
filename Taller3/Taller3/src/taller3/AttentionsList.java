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
import ucn.StdOut;

public class AttentionsList
{
  private int quantityAttentions;
  private int max;
  private Attention[] attentions;
  
  public AttentionsList(int max)
  {
    quantityAttentions = 0;
    this.max = max;
    attentions = new Attention[max];
  }
  
  public boolean addAttention(Attention attention) { if (quantityAttentions == 0) {
      attentions[0] = attention;
      quantityAttentions += 1;
      return true;
    }
    if (quantityAttentions < max) {
      attentions[quantityAttentions] = attention;
      quantityAttentions += 1;
      return true;
    }
    return false;
  }
  
  public boolean removePet(String id)
  {
    boolean result = false;
    if (quantityAttentions == 0) {
      StdOut.println("There are no registered attentions");
    } else {
      for (int i = 0; i < quantityAttentions; i++) {
        if (attentions[i].getIdAttention().equalsIgnoreCase(id)) {
          for (int j = i; j < quantityAttentions; j++) {
            attentions[j] = attentions[(j + 1)];
            quantityAttentions -= 1;
            result = true;
          }
        }
      }
    }
    return result;
  }
  
  public Attention searchAttentions(String id)
  {
    for (int i = 0; i < quantityAttentions; i++) {
      if (attentions[i].getIdAttention().equalsIgnoreCase(id)) {
        break;
      }
    }
    if (i == quantityAttentions) {
      return null;
    }
    return attentions[i];
  }
  
  public int getQuantityAttentions() {
    return quantityAttentions;
  }
  
  public Attention getAttentionsI(int i) {
    return attentions[i];
  }
}
