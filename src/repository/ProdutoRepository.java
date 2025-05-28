package repository;

import java.util.ArrayList;

import banco.Conexao;
import entity.ProdutoEntity;

public class ProdutoRepository extends Conexao {
    public ProdutoRepository() throws Exception {}

    public boolean incluir(ProdutoEntity produto)
    throws Exception {
        return true;
    }
    public boolean editar(ProdutoEntity produto)
    throws Exception {
        return true;
    }
    public boolean excluir(int id)
    throws Exception {
        return true;
    }
    public ArrayList<ProdutoEntity> listarTodos()
    throws Exception {
        return new ArrayList<>();
    }
}
