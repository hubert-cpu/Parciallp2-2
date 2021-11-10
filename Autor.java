package com.example.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "autores")
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
@Id
private int idautor;
private String nombres;
private String apellidos;

//RELACIONES ENTRE TABLAS UNO A MUCHOS
@JsonIgnore
@OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
private List<Libro> libro = new ArrayList<>();
}
