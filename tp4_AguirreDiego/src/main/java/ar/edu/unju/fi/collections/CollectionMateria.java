package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
@Component
public class CollectionMateria {
	private static List<Materia> materias  = new ArrayList<Materia>();
	/**
	 * devuelve un arrayList de objetos de la clase Materia
	 * @return 
	 */
	 public static List<Materia> getMaterias(){
		 if(materias.isEmpty()) {
			Docente docente = CollectionDocente.buscarDocente("12455");
			Carrera carrera = CollectionCarrera.buscarCarrera("2");
			materias.add(new Materia(345,"Introduccion a la Informatica","PRIMERO",64,"Virtual", docente, carrera));
		 }
		 return materias;
	 }
	 

	 /**
	  * agrega un objeto Materia al arrayList de materias
	  * @param materias
	  */
	 public static void agregarMateria(Materia materia) {
		 materias.add(materia);
	 }
	 
	 /**
	  * elimina un objeto Materia del arrayList de materias
	  * @param codigoMateria
	  */
	 public static void eliminarMateria(int codigoMateria) {
		 Iterator<Materia> iterator = materias.iterator();
		 while(iterator.hasNext()) {
			 if(iterator.next().getCodigo()== codigoMateria) {
				 iterator.remove();
			 }
		 }
	 }
	 
	 /**
	  * modifica un objeto Materia con los nuevos valores enviado en 
	  * @param materia objeto con los valores de atributos modificados
	  */
	 public static void modificarMateria(Materia materia) {
		 for(Materia mate : materias) {
			 if(mate.getCodigo() == materia.getCodigo()) {
				 mate.setNombre(materia.getNombre());
				 mate.setCurso(materia.getCurso());
				 mate.setCantidadHoras(materia.getCantidadHoras());
				 mate.setModalidad(materia.getModalidad());
				 mate.setDocente(materia.getDocente());
				 mate.setCarrera(materia.getCarrera());
			 }else {
				 System.out.println("no se encuentra el codigo de la materia");
			 }
		 }
	 }
	 
	 /** 
	  * busca un objeto Materia dentro del arrayList, el criterio es por
	  * @param codigo el codigo a buscar en el arrayList materias
	  * @return
	  */
	 public static Materia buscarMateria(int codigo) {
		 Predicate<Materia> filterMateria = m -> m.getCodigo() == codigo;
		 Optional<Materia> materia = materias.stream().filter(filterMateria).findFirst();
		 if(materia.isPresent()) {
			 return materia.get();
		 }else {
			 return null;
		 }
	 }
}
