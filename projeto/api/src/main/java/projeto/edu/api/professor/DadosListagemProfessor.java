package projeto.edu.api.professor;


public record DadosListagemProfessor(Long id, String nome, String email, FuncoesProfessor funcao) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getId(),professor.getNome(), professor.getEmail(), professor.getFuncao());
    }
}
