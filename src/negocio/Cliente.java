package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String nome;
    
    @Column	    
    private String login;
     
    @Column
    private String email;
    
    @Column    
    private String senha;
    
    @ManyToOne
    private CartaoCredito cartao;            
    
	public Cliente(long id, String nome, String login, String email, String senha, CartaoCredito cartao) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.cartao = cartao;
	}
	
	public Cliente() {		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}
	
}