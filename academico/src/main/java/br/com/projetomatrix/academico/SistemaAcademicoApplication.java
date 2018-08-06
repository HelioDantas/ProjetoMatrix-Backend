package br.com.projetomatrix.academico;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.BooleanLiteral;

import br.com.projetomatrix.academico.enumm.Status;
import br.com.projetomatrix.academico.modelo.Aluno;
import br.com.projetomatrix.academico.modelo.Turma;

@SpringBootApplication
public class SistemaAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademicoApplication.class, args);
		SistemaAcademicoService sistemaacademicoService = new SistemaAcademicoService();
		Boolean i = false;
		Turma turma = new Turma();
		Aluno aluno = new Aluno();
		aluno.setStatus(Status.Ativo);
		ArrayList<Turma> turmas = new ArrayList<>();
		turma = sistemaacademicoService.cadastrarTurma(turma);
		//System.out.println(turma.getCodigo());

		aluno = sistemaacademicoService.cadastrarAluno(aluno);
		System.out.println(sistemaacademicoService.buscaStatusDoAluno(aluno));
		

		i = sistemaacademicoService.cadastrarAlunoEmTurma(aluno, turma.getCodigo());
		//System.out.println(i);
		turmas = sistemaacademicoService.BuscarTurmasDoAluno(aluno.getMatricula());
		//System.out.println(i);

		for (Turma turma2 : turmas) {
			System.out.println(turma2.getCodigo());

		}

	}

}
