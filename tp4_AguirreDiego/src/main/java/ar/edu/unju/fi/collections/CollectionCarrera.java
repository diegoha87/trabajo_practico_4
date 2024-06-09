package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
@Component
public class CollectionCarrera {
	private static List<Carrera> carreras  = new ArrayList<Carrera>();
	/**
	 * devuelve un arrayList de objetos de la clase Carrera
	 * @return 
	 */
	 public static List<Carrera> getCarreras(){
		 if(carreras.isEmpty()) {
			 carreras.add(new Carrera("1","A.P.U",(byte)3,true));
			 carreras.add(new Carrera("2","Ingeniería Informática",(byte)5,true));
			 carreras.add(new Carrera("3","Ingeniería Química",(byte)5,false));
		 }
		 return carreras;
	 }
	 
	 /**
	  * agrega un objeto Carrera al arrayList de carreras
	  * @param carrera
	  */
	 public static void agegarCarrera(Carrera carrera) {
		 carreras.add(carrera);
	 }
	 
	 /**
	  * elimina un objeto carrera del arrayList de carreras
	  * @param codigoCarrera
	  */
	 public static void eliminarCarrera(String codigoCarrera) {
		 Iterator<Carrera> iterator = carreras.iterator();
		 while(iterator.hasNext()) {
			 if(iterator.next().getCodigo().equals(codigoCarrera)) {
				 iterator.remove();
			 }
		 }
	 }
	 
	 /**
	  * modifica un objeto carrera con los nuevos valores enviado en 
	  * @param carrera objeto con los valores de atributos modificados
	  */
	 public static void modificarCarrera(Carrera carrera) {
		 for(Carrera carre : carreras) {
			 if(carre.getCodigo().equals(carrera.getCodigo()) ) {
				 carre.setNombre(carrera.getNombre());
				 carre.setCantidadAnios(carrera.getCantidadAnios());
				 carre.setEstado(carrera.isEstado());
			 }else {
				 System.out.println("no se encuentra el código de carrera");
			 }
		 }
	 }
	 
	 /** 
	  * busca un objeto carrera dentro del arrayList, el criterio es por
	  * @param codigo el codigo a bscar en el arrayList carreras
	  * @return
	  */
	 public static Carrera buscarCarrera(String codigo) {
		 Carrera carrera = new Carrera();
		 for(Carrera c: carreras) {
			 if(c.getCodigo().equals(codigo)) {
				 carrera = c;
				 break;
			 }
		 }
		 return carrera;
	 }
}
