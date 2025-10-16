
package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Date nascimento;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos = new ArrayList<>();

    public Aluno() {}

    public Aluno(String nomeCompleto, String matricula, Date nascimento, String email) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
        telefone.setAluno(this);
    }

    public void removeTelefone(Telefone telefone) {
        telefones.remove(telefone);
        telefone.setAluno(null);
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        endereco.setAluno(this);
    }

    public void removeEndereco(Endereco endereco) {
        enderecos.remove(endereco);
        endereco.setAluno(null);
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
        curso.getAlunos().add(this);
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
        curso.getAlunos().remove(this);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                '}';
    }
}
