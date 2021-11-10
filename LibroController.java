package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Libro;
import com.example.serviceimpl.LibroServiceImpl;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
	@Autowired
	private LibroServiceImpl libroService;
	@PostMapping("/create")
	public ResponseEntity<Libro> save(@RequestBody Libro libro){
		try {
			Libro lb = libroService.create(new Libro(libro.getIdlibro(),libro.getTitulo(),libro.getPaginas(),libro.getDescripcion(),libro.getAutor(),libro.getEditorial()));
			return new ResponseEntity<>(lb, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Libro>> getLibros(){
		try {
			List<Libro> list = new ArrayList<>();
			list = libroService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Libro> getLibro(@PathVariable("id") int id){
		Libro libro = libroService.read(id);
			if(libro.getIdlibro()>0) {
				return new ResponseEntity<>(libro, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			libroService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Libro> update(@RequestBody Libro l, @PathVariable("id") int id) {
	        try {
	            Libro li = libroService.read(id);
	            if (li.getIdlibro() > 0) {
	                li.setTitulo(l.getTitulo());
	                li.setPaginas(l.getPaginas());
	                li.setDescripcion(l.getDescripcion());
	                li.setAutor(l.getAutor());
	                li.setEditorial(l.getEditorial());

	                return new ResponseEntity<>(libroService.create(li), HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }

	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
}


























