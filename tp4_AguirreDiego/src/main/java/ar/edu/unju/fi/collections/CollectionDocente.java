package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	private static List<Docente> docentes  = new ArrayList<Docente>();
	/**
	 * devuelve un arrayList de objetos de la clase Docente
	 * @return 
	 */
	 public static List<Docente> getDocentes(){
		 if(docentes.isEmpty()) {
			 docentes.add(new Docente("12455","Ariel","Vega","arielvega@gmail.com","3885378601"));
			 docentes.add(new Docente("34577", "Juan Carlos", "Rodriguez", "juancrodriguez@gmail.com", "3886994737"));
			 docentes.add(new Docente("54389", "Gustavo", "Sosa", "gustavososa@gmail.com", "3885037423")); 
		 }
		 return docentes;
	 }
	 

	 /**
	  * agrega un objeto Docente al arrayList de docentes
	  * @param docente
	  */
	 public static void agregarDocente(Docente docente) {
		 docentes.add(docente);
	 }
	 
	 /**
	  * elimina un objeto Docente del arrayList de docentes
	  * @param legajoDocente
	  */
	 public static void eliminarDocente(String legajoDocente) {
		 Iterator<Docente> iterator = docentes.iterator();
		 while(iterator.hasNext()) {
			 if(iterator.next().getLegajo().equals(legajoDocente) ) {
				 iterator.remove();
			 }
		 }
	 }
	 
	 /**
	  * modifica un objeto Docente con los nuevos valores enviado en 
	  * @param docente objeto con los valores de atributos modificados
	  */
	 public static void modificarDocente(Docente docente) {
		 for(Docente doce : docentes) {
			 if(doce.getLegajo().equals(docente.getLegajo()) ) {
				 doce.setNombre(docente.getNombre());
				 doce.setApellido(docente.getApellido());
				 doce.setEmail(docente.getEmail());
				 doce.setTelefono(docente.getTelefono());
			 }else {
				 System.out.println("no se encuentra el legajo del docente");
			 }
		 }
	 }
	 
	 /** 
	  * busca un objeto Docente dentro del arrayList, el criterio es por
	  * @param legajo el legajo a buscar en el arrayList docentes
	  * @return
	  */
	 public static Docente buscarDocente(String legajo) {
		 Docente docente = new Docente();
		 for(Docente d: docentes) {
			 if(d.getLegajo().equals(legajo)) {
				 docente = d;
				 break;
			 }
		 }
		 return docente;
	 }
}
