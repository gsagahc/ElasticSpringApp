package br.com.elastic.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="produtos")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto", nullable = false, length = 80)
	private Long id;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "precocusto", nullable = false, length = 50)
	private float precoCusto;

	@Column(name = "precovenda", nullable = false, length = 50)
	private float precoVenda;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "descricao", nullable = false, length = 80)
	private String descricao;

	@Column(name = "unidade", nullable = false, length = 10)
	private String unidade;

	@Column(name = "ncm")
	private String ncm;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "snestocavel", nullable = false)
	private String snEstocavel;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductEntity that = (ProductEntity) o;
		return Float.compare(precoCusto, that.precoCusto) == 0 && Float.compare(precoVenda, that.precoVenda) == 0 && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(tipo, that.tipo) && Objects.equals(descricao, that.descricao) && Objects.equals(unidade, that.unidade) && Objects.equals(ncm, that.ncm) && Objects.equals(codigo, that.codigo) && Objects.equals(snEstocavel, that.snEstocavel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, precoCusto, precoVenda, tipo, descricao, unidade, ncm, codigo, snEstocavel);
	}
}


