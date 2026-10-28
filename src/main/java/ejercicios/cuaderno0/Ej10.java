package ejercicios.cuaderno0;
import java.nio.file.DirectoryNotEmptyException; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.Comparator; 
import java.util.List; 
import java.util.stream.Stream; 
import java.io.IOException;
public class Ej10 {
	public static void main(String[] args) throws IOException {
		 Path carpeta = Path.of("datos", "2026");    // la del ejercicio 7 
	        Files.writeString(carpeta.resolve("notas").resolve("1T.csv"), 
	                "id;nota\n"); 
	 
	        try { 
	            Files.delete(carpeta); 
	        } catch (DirectoryNotEmptyException e) { 
	            System.out.println("delete: DirectoryNotEmptyException " 
	                    + e.getMessage()); 
	        } 
	 
	        try (Stream<Path> todo = Files.walk(carpeta)) { 
	            List<Path> alReves = todo.sorted(Comparator.reverseOrder()) 
	                                     .toList(); 
	            for (Path p : alReves) { 
	                System.out.println("Borro " + p); 
	                Files.delete(p); 
	            } 
	        } 
	 
	        System.out.println("¿Existe todavía? " + Files.exists(carpeta)); 
	        System.out.println("deleteIfExists devuelve " 
	                + Files.deleteIfExists(carpeta)); 
	    } 
	}

