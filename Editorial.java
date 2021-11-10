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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "editoriales")
public class Editorial {	
@Id
private int ideditorial;
private String editorial;
//RELACION UNO A MUCHOS
@JsonIgnore
@OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial")
private List<Libro> libro = new ArrayList<>();
}
