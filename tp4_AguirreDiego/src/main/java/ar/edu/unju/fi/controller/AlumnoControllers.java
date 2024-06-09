package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CollectionAlumno;

import ar.edu.unju.fi.model.Alumno;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/alumno")
public class AlumnoControllers {
	@Autowired
	private Alumno alumno;
	
	@GetMapping("/listado")
	public String getAlumnosPage(Model model) {
		model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
		model.addAttribute("titulo", "alumnos");
		return "alumnos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		return "alumno";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumnos");
		CollectionAlumno.agregarAlumno(alumno);
		modelView.addObject("alumnos", CollectionAlumno.getAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{dni}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="dni") long dni) {
		Alumno alumnoEncontrado = new Alumno();
		boolean edicion = true;
		alumnoEncontrado = CollectionAlumno.buscarAlumno(dni);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar Alumno");
		return "alumno";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		CollectionAlumno.modificarAlumno(alumno);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable(value="dni") long dni) {
		CollectionAlumno.eliminarAlumno(dni);
		return "redirect:/alumno/listado";
	}
}
