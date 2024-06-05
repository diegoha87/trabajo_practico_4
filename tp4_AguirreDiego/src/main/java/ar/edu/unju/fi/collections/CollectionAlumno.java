package ar.edu.unju.fi.collections;

import java.lang.reflect.GenericArrayType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;


@Component
public class CollectionAlumno {
	private static List<Alumno> alumnos  = new ArrayList<Alumno>();
	/**
	 * devuelve un arrayList de objetos de la clase Alumno
	 * @return 
	 */
	 public static List<Alumno> getAlumnos(){
		 if(alumnos.isEmpty()) {
			 alumnos.add(new Alumno(33560457,"Diego","Aguirre","diegoha14@gmail.com","3885962601",LocalDate.of(1987, 10, 07),"Pje Tumbaya 1326","5343"));
			 alumnos.add(new Alumno(41763889, "Juan", "Perez", "juanperez24@gmail.com", "3886139935", LocalDate.of(1996, 02, 28), "Av. Americas", "4376"));
			 alumnos.add(new Alumno(41763889, "Carlos", "Sanchez", "carloss16@gmail.com", "3885198825", LocalDate.of(1981, 05, 10), "Los Tulipanes", "5134"));
				 
		 }
		 return alumnos;
	 }
	 

	 /**
	  * agrega un objeto Alumno al arrayList de Alumnos
	  * @param alumno
	  */
	 public static void agregarAlumno(Alumno alumno) {
		 alumnos.add(alumno);
	 }
	 
	 /**
	  * elimina un objeto Alumno del arrayList de alumno
	  * @param dniAlumno
	  */
	 public static void eliminarAlumno(long dniAlumno) {
		 Iterator<Alumno> iterator = alumnos.iterator();
		 while(iterator.hasNext()) {
			 if(iterator.next().getDni()== dniAlumno) {
				 iterator.remove();
			 }
		 }
	 }
	 
	 /**
	  * modifica un objeto Alumno con los nuevos valores enviado en 
	  * @param alumno objeto con los valores de atributos modificados
	  */
	 public static void modificarAlumno(Alumno alumno) {
		 for(Alumno alum : alumnos) {
			 if(alum.getDni() == alumno.getDni()) {
				 alum.setNombre(alumno.getNombre());
				 alum.setApellido(alumno.getApellido());
				 alum.setEmail(alumno.getEmail());
				 alum.setTelefono(alumno.getTelefono());
				 alum.setFechaNacimiento(alumno.getFechaNacimiento());
				 alum.setDomicilio(alumno.getDomicilio());
				 alum.setLu(alumno.getLu());
			 }else {
				 System.out.println("no se encuentra el dni del alumno");
			 }
		 }
	 }
	 
	 /** 
	  * busca un objeto alumno dentro del arrayList, el criterio es por
	  * @param dni el dni a buscar en el arrayList alumnos
	  * @return
	  */
	 public static Alumno buscarAlumno(long dni) {
		 Predicate<Alumno> filterDni = d -> d.getDni() == dni;
		 Optional<Alumno> alumno = alumnos.stream().filter(filterDni).findFirst();
		 if(alumno.isPresent()) {
			 return alumno.get();
		 }else {
			 return null;
		 }
	 }
}
