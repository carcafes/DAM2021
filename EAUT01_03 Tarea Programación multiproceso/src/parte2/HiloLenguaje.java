package parte2;

import java.io.File;
import java.io.IOException;

public class HiloLenguaje extends Thread{
private int cantidad;
private File archivo;

public HiloLenguaje() {
	this.cantidad=10;
	this.archivo=new File("./miFicheroDeLenguaje.txt");
	try {
		lenguaje.noExiste(archivo, cantidad);
	} catch (IOException e) {
		System.out.println("Error al crear el archivo");
		e.printStackTrace();
	}
}
public HiloLenguaje(File archivo,int cantidad) {
	this.cantidad=cantidad;
	this.archivo=archivo;
	try {
		lenguaje.existe(archivo, cantidad);
	} catch (IOException e) {
		System.out.println("Error al acceder al archivo");
		e.printStackTrace();
	}
}

}
