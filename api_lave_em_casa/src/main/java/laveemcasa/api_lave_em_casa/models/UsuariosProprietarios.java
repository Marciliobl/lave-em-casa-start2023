package laveemcasa.api_lave_em_casa.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios_proprietarios")
public class UsuariosProprietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nascimento_proprietario", nullable = false)
    private Date dataNascimentoProprietario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private Double rendaTotal;

    @Column(nullable = false)
    private Double pesoSuportadoMaquina;

    @Column(nullable = false)
    private Integer quantidadeMaquinas;

    @OneToMany(mappedBy = "proprietario")
    private List<Anuncios> anuncios;

    @Column(name = "quantidade_anuncios")
    private Integer quantidadeAnuncios;

    // getters and setters
}
