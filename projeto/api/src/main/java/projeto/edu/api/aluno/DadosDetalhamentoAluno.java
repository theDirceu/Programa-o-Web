package projeto.edu.api.aluno;


public record DadosDetalhamentoAluno(Long id, String nome, String email, String matricula, FuncoesAluno funcao) {
    public DadosDetalhamentoAluno (Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getFuncao());
    }
}
