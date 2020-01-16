/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

/**
 *
 * @author Victor Huerta
 */
public class ListaPaginasGrupos {
    private int max;
    private int cantPaginasGrupos;
    private PaginaGrupo [] lpg;

    public ListaPaginasGrupos(int max) {
        this.max = max;
        cantPaginasGrupos = 0;
        lpg = new PaginaGrupo[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantPaginasGrupos() {
        return cantPaginasGrupos;
    }

    public void setCantPaginasGrupos(int cantPaginasGrupos) {
        this.cantPaginasGrupos = cantPaginasGrupos;
    }

    public PaginaGrupo[] getLpg() {
        return lpg;
    }

    public void setLpg(PaginaGrupo[] lpg) {
        this.lpg = lpg;
    }
    
    public PaginaGrupo getPaginaGrupo(int i) {
        return lpg[i];
    }
    
    public boolean ingresarPaginaGrupo(PaginaGrupo PG){
        if(cantPaginasGrupos>= max) {
            return false;
        }else{
            lpg[cantPaginasGrupos]=PG;
            cantPaginasGrupos++;
            return true;
        }
    }
    
    public PaginaGrupo buscarPaginaGrupo(int codigo){
        int i=0;
        for(i = 0; i<cantPaginasGrupos; i++) {
            if(lpg[i].getCodigo() == codigo) {
                break;

            }
        }
        if(i==cantPaginasGrupos) {
            return null;
        }else{
            return lpg[i];
        }
    }
    
    public boolean eliminarPaginaGrupo(PaginaGrupo PG) {
        int i;
        for(i = 0; i < cantPaginasGrupos; i++) {
            if(lpg[i] == PG){
                break;
            }
        }
        if(i==cantPaginasGrupos) {
            return false;
        }else{
            for(int j=0; j<cantPaginasGrupos; j++){
                lpg[j]=lpg[j+1];
            }
            cantPaginasGrupos--;
            return true;
        }
    }
    
}
