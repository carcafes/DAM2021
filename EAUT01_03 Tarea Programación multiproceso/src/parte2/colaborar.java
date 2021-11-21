package parte2;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class colaborar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidadHilos,cantidadPalabras=10;
		
		File archivo=null;
		HiloLenguaje hilo1 =  new HiloLenguaje();
		
		if(args.length!=0) {
			cantidadHilos = Integer.parseInt(args[0])-1;
			archivo=new File("./"+args[1]);
		}else{
			cantidadHilos =10-1;
			archivo=new File("./miFicheroDeLenguaje.txt");
			
		}
		
		ExecutorService exs = Executors.newFixedThreadPool(cantidadHilos);
		for (int i=0; i<cantidadHilos; i++) { 
			cantidadPalabras+=10;
			HiloLenguaje t = new HiloLenguaje(archivo,cantidadPalabras);    
			
            exs.submit(t);
        }
		exs.shutdown();
	}

}
