package com.example.service;
import java.util.List;
import com.example.entity.Libro;

public interface LibroService {
	Libro create(Libro libro);
	List<Libro> readAll();
	Libro read(int id);
	void delete(int id);
	Libro update(Libro lb);
}
