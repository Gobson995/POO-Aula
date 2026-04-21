package negocio;

import dados.*;
import java.util.*;

public class Turma {
    private List <Aluno> alunos = new ArrayList<>();
    
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    private void ordenarAlunosPorMedia() {
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return Double.compare(a1.calcularMedia(), a2.calcularMedia());
            }
        });
    }

    public List<Equipe<Aluno>> separarEmEquipes() {
        ordenarAlunosPorMedia();

        List<Equipe<Aluno>> equipes = new ArrayList<>();
        int contadorEquipe = 1;

        List<Aluno> copiaAlunos = new ArrayList<>(alunos);

        while (copiaAlunos.size() >= 3) {
            Equipe<Aluno> novaEquipe = new Equipe<>("Equipe " + contadorEquipe++);
            
            novaEquipe.adicionarMembro(copiaAlunos.remove(0));

            novaEquipe.adicionarMembro(copiaAlunos.remove(copiaAlunos.size() - 1));

            novaEquipe.adicionarMembro(copiaAlunos.remove(0));

            if (copiaAlunos.size() > 0 && contadorEquipe % 2 == 0) {
                 novaEquipe.adicionarMembro(copiaAlunos.remove(copiaAlunos.size() - 1));
            }

            equipes.add(novaEquipe);
        }

        for (Aluno sobra : copiaAlunos) {
            if (!equipes.isEmpty()) {
                equipes.get(equipes.size() - 1).adicionarMembro(sobra);
            }
        }

        return equipes;
    }
}
