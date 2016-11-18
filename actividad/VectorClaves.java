import java.io.Serializable;
import java.util.Vector;

public class VectorClaves implements Serializable {
	public Vector<Clave> claves =new Vector<Clave>(); // contiene el valor elegido

	public boolean addClave(int num) {
		if(claves.indexOf(num) == -1) {
			claves.add(new Clave(num));
			return true;
		}
		return false;
	}
}

class Clave {
	private int clave;
	private int primo1 = -1;
	private int primo2 = -1;
	public Clave(int mul) {
		this.clave = mul;
	}
	/**
	 * Recibe dos numeros primos y devuelve true
	 * si son la solucion de la clave.
	 * 
	 **/
	public boolean solucion(int p1, int p2) {
		if(p1*p2 == this.clave) {
			this.primo1 = p1;
			this.primo2 = p2;
			return true;
		}
		return false;
	}
}

