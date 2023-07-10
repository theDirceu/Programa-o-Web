package projeto.edu.api.domain.professor;


public record DadosListagemProfessor(Long id, String nome, String email, String formacao, FuncoesProfessor funcao) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getId(),professor.getNome(), professor.getEmail(), professor.getFormacao(), professor.getFuncao());
    }
}
