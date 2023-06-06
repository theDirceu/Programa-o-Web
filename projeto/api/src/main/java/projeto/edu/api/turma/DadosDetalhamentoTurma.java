package projeto.edu.api.turma;

public record DadosDetalhamentoTurma(Long id, String nome, String sala) {

    public DadosDetalhamentoTurma(Turma turma){
        this(turma.getId(), turma.getNome(), turma.getSala());
    }
}
