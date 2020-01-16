/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2016progra1;

/**
 *
 * @author Usuario
 */
public abstract class Pagina {
    protected int cantVisitas;
    protected String url;

    public Pagina(int cantVisitas, String url) {
        this.cantVisitas = 0;
        this.url = url;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
