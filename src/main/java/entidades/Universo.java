package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dao.UniversoDao;

@Entity
public class Universo {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	@Column(name = "existe_vida")
	private String existeVida;
	@Column(name = "data_descoberta")
	@Temporal(TemporalType.DATE)
	private Date dataDescoberta;
	private String descricao;
	 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getExisteVida() {
		return existeVida;
	}
	public void setExisteVida(String existeVida) {
		this.existeVida = existeVida;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataDescoberta() {
		return dataDescoberta;
	}
	public void setDataDescoberta(Date dataDescoberta) {
		this.dataDescoberta = dataDescoberta;
	}
	
}
