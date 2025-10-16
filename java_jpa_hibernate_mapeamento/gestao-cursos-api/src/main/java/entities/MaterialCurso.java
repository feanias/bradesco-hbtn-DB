package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "material_curso")
public class MaterialCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String conteudo;

    @OneToOne(mappedBy = "material", fetch = FetchType.LAZY)
    private Curso curso;

    public MaterialCurso() {}
    public MaterialCurso(String conteudo) { this.conteudo = conteudo; }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}