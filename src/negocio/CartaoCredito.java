package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartaoCredito {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nomeCartao;
	
	@Column
	private int numero;
	
	@Column
	private int validade;
	
	@Column
	private int cvc;	
	
	public CartaoCredito(long id, String nomeCartao, int numero, int validade, int cvc) {
		this.id = id;
		this.nomeCartao = nomeCartao;
		this.numero = numero;
		this.validade = validade;
		this.cvc = cvc;
	}
	
	public CartaoCredito() {		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
}