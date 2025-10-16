package entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefone> telefones = new HashSet<>();

    @ManyToMany(mappedBy = "alunos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Curso> cursos = new HashSet<>();

    public Aluno() {}
    public Aluno(String nome) { this.nome = nome; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Endereco> getEnderecos() { return enderecos; }
    public Set<Telefone> getTelefones() { return telefones; }
    public Set<Curso> getCursos() { return cursos; }

    public void addEndereco(Endereco e) {
        enderecos.add(e);
        e.setAluno(this);
    }
    public void addTelefone(Telefone t) {
        telefones.add(t);
        t.setAluno(this);
    }
    public void addCurso(Curso c) {
        cursos.add(c);
        c.getAlunos().add(this);
    }
}