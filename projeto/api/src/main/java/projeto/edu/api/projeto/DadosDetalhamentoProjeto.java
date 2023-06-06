package projeto.edu.api.projeto;

public record DadosDetalhamentoProjeto(Long id, String nome, String descricao) {

    public DadosDetalhamentoProjeto(Projeto projeto){
        this(projeto.getId(), projeto.getNome(), projeto.getDescricao());
    }
}
