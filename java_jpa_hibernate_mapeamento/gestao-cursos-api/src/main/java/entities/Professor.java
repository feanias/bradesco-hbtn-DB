
package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Curso> cursos = new ArrayList<>();

    public Professor() {}

    public Professor(String nomeCompleto, String matricula, String email) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
        telefone.setProfessor(this);
    }

    public void removeTelefone(Telefone telefone) {
        telefones.remove(telefone);
        telefone.setProfessor(null);
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
        curso.setProfessor(this);
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
        curso.setProfessor(null);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
