package repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import banco.Conexao;
import entity.ProdutoEntity;

public class ProdutoRepository extends Conexao {
    public ProdutoRepository() throws Exception {}

    public boolean incluir(ProdutoEntity produto)
    throws Exception {
        String sql = "insert into tbprodutos "+
        " (nome,preco, categoria) "+
        " values (?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setFloat(2, produto.getPreco());
        ps.setString(3, produto.getCategoria());
        // return ps.executeUpdate()>0;
        if(ps.executeUpdate()>0) return true;
        else return false;
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
