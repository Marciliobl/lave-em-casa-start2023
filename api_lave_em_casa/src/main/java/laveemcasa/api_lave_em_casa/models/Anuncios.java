package laveemcasa.api_lave_em_casa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import laveemcasa.api_lave_em_casa.models.UsuariosProprietarios;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "anuncios")
public class Anuncios {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String titulo;

   private String descricao;

   @Column(name = "valor_lavagem")
   private Double valorLavagem;

   private Boolean disponivel;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "proprietario_id")
   private UsuariosProprietarios proprietario;

   // Construtores, getters e setters

}
