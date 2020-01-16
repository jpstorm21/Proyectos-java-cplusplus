package cl.ucn.ei.pa.sistemaUniversidades.dominio;

public class Arancel {
	private int arancelBasico;
	private Privada privada;
	private Carrera carrera;
	
	public Arancel(int arancelBasico, Privada privada, Carrera carrera) {	
		this.arancelBasico = arancelBasico;
		this.privada = privada;
		this.carrera = carrera;
	}

	public Privada getPrivada() {
		return privada;
	}

	public void setPrivada(Privada privada) {
		this.privada = privada;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public int getArancelBasico() {
		return arancelBasico;
	}

	public void setArancelBasico(int arancelBasico) {
		this.arancelBasico = arancelBasico;
	} 
	
	
}
