package laveemcasa.api_lave_em_casa.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "locatario_id", nullable = false)
    private UsuariosLocatorios locatorio;

    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private UsuariosProprietarios proprietario;

    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_termino", nullable = false)
    private LocalDateTime dataHoraTermino;

    @Column(name = "valor_proprietario", nullable = false)
    private Double valorProprietario; // valor da reserva

    @Column(name = "taxa_administrativa", nullable = false)
    private Double taxaAdministrativa;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "anuncio_id", nullable = false)
    private Anuncios anuncio;



    // getters and setters
}
