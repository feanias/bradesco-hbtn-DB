package demo;

import models.AlunoModel;
import models.CursoModel;
import entities.*;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // Professor
        Professor professor = new Professor("Dr. Ana Souza");

        // Material
        MaterialCurso material = new MaterialCurso("Conteúdo inicial do curso sobre JPA e Hibernate.");

        // Curso (vincula professor e material)
        Curso curso = new Curso("JPA e Hibernate - Básico");
        curso.setProfessor(professor);
        curso.setMaterial(material);

        // Aluno com endereco e telefone
        Aluno aluno = new Aluno("Aluno Teste");
        Endereco end = new Endereco("Rua A", "CidadeX", "00000-000");
        Telefone tel = new Telefone("(11)99999-9999", "Celular");

        aluno.addEndereco(end);
        aluno.addTelefone(tel);

        // Vincula aluno ao curso
        curso.addAluno(aluno);

        // Persistir curso (cascade salva material, professor e também aluno se necessário)
        cursoModel.create(curso);

        // Listar resultados
        System.out.println("Cursos cadastrados: " + cursoModel.findAll().size());
        System.out.println("Alunos cadastrados: " + alunoModel.findAll().size());

        // fechar factories
        cursoModel.close();
        alunoModel.close();
    }
}