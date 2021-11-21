package parte1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GenerarNumeros {
	
	public static void main(String[] args) {
		int numero = 40;
		
		if(args.length != 0)
		numero =Integer.parseInt(args[0]);
		
		// Generador de numeros al azar
		Random R = new Random();
		

		// Socket para aceptar conexiones
		ServerSocket conexion = null;

		// Socket para establecer canal de comunicación
		Socket canal = null;

		PrintWriter streamSalida = null;

		try {
			// Solicitamos al sistema operativo que abra un puerto de escucha
			// de conexiones. El número del puerto es el 12345
			conexion = new ServerSocket(12345);

		} catch (IOException ex) {
			System.err.println("No se ha podido abrir el puerto de escucha.");
			System.err.println(ex.toString());
		}

		// Si hemos podido abrir el puerto
		if (conexion != null)
			try {
				System.out.println("Proceso escritor, esperando " + "la conexión del proceso lector....");
				// Esperamos hasta que se produzca una conexión al puerto
				// El método ServerSocket.accept(); bloquea (hace dormir)
				// el proceso hasta que se produce una conexión
				canal = conexion.accept();
				
				// Creamos un objeto PrintWriter a partir del Stream de salida
				// del socket o canal de comunicación
				// El objeto PrintWriter, nos permitirá utilizar los métodos
				// print y write para mandar datos al proceso que está
				// escuchando al otro lado del canal.
				streamSalida = new PrintWriter(canal.getOutputStream());
				

				System.out.println("Conexión establecida, mandando datos " + "al proceso lector....");
				
				// Mandamos los numeros
				for(int i=0;i<numero;i++) {
					streamSalida.println(R.nextInt(100)+1); 
					streamSalida.flush(); // Forzamos que mande cada número
				}
				streamSalida.println(-1); 
				streamSalida.flush(); // Forzamos que mande cada número
				System.out.println("Comunicación finalizada.");
			} catch (Exception ex) {
				System.err.println("No se ha podido establecer conexión, "
						+ "o no ha ocurrido un fallo al escribir en el canal.");
				System.err.print(ex.toString());
			} finally {
				// Nos aseguramos de que se cierren los recursos
				// que estamos utilizando
				if (streamSalida != null)// PrintWriter
					streamSalida.close(); // su cierre no genera excepciones
				if (canal != null) // Socket
					try {
						canal.close();
					} catch (IOException ex) {
						System.err.println("Error al cerrar el socket.");
						System.err.print(ex.toString());
					}
				if (conexion != null) // ServerSocket
					try {
						conexion.close();
					} catch (IOException ex) {
						System.err.println("Error al cerrar ServerSocket.");
						System.err.print(ex.toString());
					}
			}
	}

}
