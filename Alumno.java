import java.io.Serializable;
import java.util.Random;

public class Alumno implements Serializable {
	public int numero = -1; // contiene el valor elegido
	/**
	 * Recibe el maximo y el minimo al generar aleatoriamente
	 * y lo pone en numero
	 *
	 * @param min El valor minimo para numero
	 * @param mx El valor maximo para numero
	 */
	public Alumno(int min, int max) {
		Random r = new Random();
		while(this.numero < min || this.numero>max) {
			this.numero = r.nextInt();
		}
	}
	public String toString() {
		return "Objeto Alumno: " +
				"\t numero = " + this.numero +
				"\n";
	}
}














