package projeto.escola.musica.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import projeto.escola.musica.dao.CidadeDao;
import projeto.escola.musica.modelo.Cidade;
import projeto.escola.musica.modelo.Estado;

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = -3933633786923042000L;

	private List<Cidade> cidades;
	private Cidade cidade = new Cidade();

	public CidadeBean() {
		atualizarCidades();
	}
	
	public void salvar() {
		CidadeDao.salvar(cidade);
		atualizarCidades();
		cidade = new Cidade();
	}
	
	private void atualizarCidades() {
		cidades = CidadeDao.listarTodas();
	}

	public List<Estado> getEstados() {
		return Arrays.asList(Estado.values());
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
