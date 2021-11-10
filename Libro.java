package com.example.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "libros")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
@Id
private int idlibro;
private String titulo;
private int paginas;
private String descripcion;

// RELACIONES TABLA CENTRAL QUE RECIBE EL ID DE LAS 2 TABLAS
@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
@JoinColumn(name = "autor_id", referencedColumnName = "idautor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Autor autor;

@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
@JoinColumn(name = "editorial_id", referencedColumnName = "ideditorial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Editorial editorial; 


}
