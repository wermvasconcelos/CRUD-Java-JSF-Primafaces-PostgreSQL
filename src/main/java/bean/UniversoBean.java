package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import dao.UniversoDao;
import entidades.Universo;

@ManagedBean
public class UniversoBean {
	private Universo uni = new Universo();
	private List<Universo> listar;
	private Integer contar = UniversoDao.contar();
	
	public String salvar() {
		try {
			UniversoDao.salvar(uni);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Planeta "+ uni.getNome() +" inclu�do com sucesso!"));
			uni = new Universo();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "N�o foi poss�vel concluir o cadastro!"));
		}
		return null;
	}
	
	public String editar() {
		try {
			UniversoDao.editar(uni);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Cadastro alterado!"));
			uni = new Universo();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "N�o foi poss�vel concluir a altera��o!"));
		}
		
		return "listagem";
	}
	
	public String excluir(int id) {
		try {
			UniversoDao.excluir(uni, id);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Exclus�o feita com sucesso!"));
			uni = new Universo();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "N�o foi poss�vel concluir a exclus�o!"));	
		}	
		
		return null;
	}

	public Universo getUni() {
		return uni;
	}
	
	public void setUni(Universo universo) {
		this.uni = universo;
	}
	
	public List<Universo> getListar(){
		if (listar == null) {
			listar = UniversoDao.listar();
		}
		return listar;
	}
	
	public void setListar(List<Universo> listar) {
		this.listar= listar;
	}
	
	public String contar() {
		if (getContar()>1) {
			return "Existem "+getContar()+" planetas cadastrados!";
		} else {
			return "Existe 1 planeta cadastrado!";
		}
	}
	
	public Integer getContar() {
		return contar;
	}
	
	public void setContar(Integer contar) {
		this.contar = contar;
	}
	
}
