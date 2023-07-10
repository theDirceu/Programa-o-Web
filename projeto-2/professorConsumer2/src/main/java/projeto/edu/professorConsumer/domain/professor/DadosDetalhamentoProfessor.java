package projeto.edu.api.domain.professor;


public record DadosDetalhamentoProfessor(Long id, String nome, String formacao, String email, String matricula, FuncoesProfessor funcao) {
    public DadosDetalhamentoProfessor (Professor professor){
        this(professor.getId(), professor.getNome(), professor.getFormacao(), professor.getEmail(), professor.getMatricula(), professor.getFuncao());
    }
}
