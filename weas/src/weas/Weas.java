
public class Weas {
private double[] lista; // referencia el arreglo
private int nElems;// número de items
private int max; //Máxima cantidad de elementos para el contenedor
public Weas(int max) {
lista = new double[max];
nElems = 0; 
this.max = max;
}
//-----------------------------------
public boolean encontrar(double claveBusqueda){
// encuentra el valor especificado
int j; for(j=0; j<nElems; j++) { // para cada elemento
if(lista[j] == claveBusqueda){ // ¿item encontrado? break; // sale del loop
}
}
if(j == nElems) { //no lo encontró
return false;
}
else{
return true; // si lo encontró
}
} // end econtrar()
2.73
public boolean insertar(double valor){ //inserta elemento en el contenedor
if (nElems < max) { //Hay espacio
lista[nElems] = valor; // lo inserta
nElems++; // incrementa el tamaño
return true;
}
else {
return false;
}
}
//-----------------------------------
public boolean eliminar(double valor){ int j; for(j=0; j<nElems; j++) { //buscar el valor
if( valor == lista[j] ) {
break;
}
}
if(j==nElems) { // no lo encontró
return false;
}
else { // si lo encontró
for(int k=j; k<nElems - 1; k++) {
lista[k] = lista[k+1]; //Corrimiento }
nElems--; // decrementa el tamaño
return true;
} //fin else
} // end eliminar()
//-----------------------------------
public int getTam() {
return nElems;
}
//-----------------------------------
public double getElem(int i) {
return lista[i];
}
}// end class ListaDoubles