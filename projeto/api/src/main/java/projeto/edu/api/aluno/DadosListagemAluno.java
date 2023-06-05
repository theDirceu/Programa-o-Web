package projeto.edu.api.aluno;

public record DadosListagemAluno(Long id, String nome, String email, FuncoesAluno funcao) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getFuncao());
    }
}
