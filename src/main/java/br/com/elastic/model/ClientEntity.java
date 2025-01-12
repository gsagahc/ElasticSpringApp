package br.com.elastic.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import java.io.Serializable;
import java.util.Objects;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clientes")
public class ClientEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = false, length = 80)
	private Long id;

	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@Column(name = "endereco", nullable = false, length = 46)
	private String endereco;

	@Column(name = "cnpj", nullable = false, length = 20)
	private String cnpj;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "telefone", nullable = false, length = 15)
	private String telefone;

	@Column(name = "bairro", nullable = false, length = 60)
	private String bairro;

	@Column(name = "cidade", nullable = false, length = 37)
	private String cidade;

	@Column(name = "estado", nullable = false, length = 2)
	private String estado;

	@Column(name = "cep", nullable = false, length = 10)
	private String cep;

	@Column(name = "boleto", nullable = false, length = 1)
	private String boleto;

	@Column(name = "snlote", nullable = false, length = 1)
	private String snlote;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClientEntity that = (ClientEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(endereco, that.endereco) && Objects.equals(cnpj, that.cnpj) && Objects.equals(complemento, that.complemento) && Objects.equals(telefone, that.telefone) && Objects.equals(bairro, that.bairro) && Objects.equals(cidade, that.cidade) && Objects.equals(estado, that.estado) && Objects.equals(cep, that.cep) && Objects.equals(boleto, that.boleto) && Objects.equals(snlote, that.snlote);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, endereco, cnpj, complemento, telefone, bairro, cidade, estado, cep, boleto, snlote);
	}
}


