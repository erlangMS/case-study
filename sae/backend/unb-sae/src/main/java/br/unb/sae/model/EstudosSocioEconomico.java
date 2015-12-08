package br.unb.sae.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EstudosSocioEconomicos")
public class EstudosSocioEconomico implements Serializable {
	private static final long serialVersionUID = 5471384039041899158L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Column(name = "periodo", nullable = false, insertable = true, updatable = true, length = 5)
    private String periodo;

    @Basic
    @Column(name = "Data", nullable = true, insertable = true, updatable = true)
    private Timestamp data;

    @Basic
    @Column(name = "Motivo", nullable = true, insertable = true, updatable = true)
    private Byte motivo;

    @Basic
    @Column(name = "Nivel", nullable = true, insertable = true, updatable = true, length = 13)
    private String nivel;


	
}
