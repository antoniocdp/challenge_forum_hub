package br.com.antoniocdp.challengeforumhub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "/topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;
    private String curso;
    private Boolean estadoDoTopico;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public <Usuario> Topico(DadosCadastroTopico dadosCadastroTopico, Usuario autor) {
        this.estadoDoTopico = true;
        this.titulo = dadosCadastroTopico.titulo();
        this.mensagem = dadosCadastroTopico.mensagem();
        this.autor = String.valueOf(autor.getClass());
        this.curso = dadosCadastroTopico.curso();
    }


    public void atualizar(DadosAtualizarTopico dadosAtualizarTopico) {
        if (dadosAtualizarTopico.titulo() != null) {
            this.titulo = dadosAtualizarTopico.titulo();
        }
        if (dadosAtualizarTopico.mensagem() != null) {
            this.mensagem = dadosAtualizarTopico.mensagem();
        }
        if (dadosAtualizarTopico.curso() != null) {
            this.curso = dadosAtualizarTopico.curso();
        }
        //String curso;
    }

}