package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Libro;
import com.example.repository.LibroRepository;
import com.example.service.LibroService;
@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	private LibroRepository libroRepository;
	@Override
	public Libro create(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}
	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}
	@Override
	public Libro read(int id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).get();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}
	@Override
	public Libro update(Libro lb) {
		// TODO Auto-generated method stub
		return libroRepository.save(lb);
	}
	

}
