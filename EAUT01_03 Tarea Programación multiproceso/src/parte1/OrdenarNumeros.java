package parte1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class OrdenarNumeros {

	static int[] arrayNumero = new int[1];

	public static void main(String[] args) {
		// Socket para establecer el canal de conexión con el escritor
		Socket canal = null; 
		
		// Para el stream de lectura
		BufferedReader entrada = null; 
		
		//Numeros leidos
		int numero;

		//Se inicia el socket
		try {
			canal = new Socket("localhost", 12345);
		} catch (IOException e) {

			System.err.println("No se ha podido establecer conexión.");
			e.printStackTrace();
		}
		
		// Si hemos podido establecer la conexión. Tenemos
		// un canal de comunicación
		if (canal != null) 
			try {
				
				// Obtemenos el objeto que representa el stream de entrada en el canal
				// Lector con buffer, para no perder ningún dato
				entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));

				//Incluimos los numeros
				while ((numero = Integer.parseInt(entrada.readLine() )) >= 0) {
					incluir(numero); // Recibimos los numeros
					
				}
				
				// Ordenamos los numeros
				arrayNumero = ordenar(arrayNumero);
				
				//imprimimos resultados con un for each
				for(int resultado:arrayNumero) {
					System.out.println(resultado);
				}
				
			} catch (Exception ex) {
				System.err.println("No se ha podido establecer conexión.");
				System.err.println(ex.toString());
			} finally {
				//Nos aseguramos de que se cierran los recursos que estamos utilizando
				if (entrada != null)
					try {
						entrada.close();
					} catch (IOException ex) {
						System.err.println("Se ha producido un error al cerrar el InputStreamReader.");
						System.err.println(ex.toString());
					}
				if (canal != null)
					try {
						canal.close();
					} catch (IOException ex) {
						System.err.println("Se ha producido un error al cerrar el Socket.");
						System.err.println(ex.toString());
					}
			}
	}

	public static int[] ordenar(int[] array) {
		Arrays.sort(array);
		return array;
	}

	public static void incluir(int nuevo) {
		arrayNumero[arrayNumero.length - 1] = nuevo;

		int[] aux = new int[arrayNumero.length + 1];
		for (int i = 0; i < arrayNumero.length; i++) {
			aux[i] = arrayNumero[i];
		}
		arrayNumero = aux;
	}
}
