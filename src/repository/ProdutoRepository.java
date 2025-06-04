package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "update tbprodutos "+
        " set nome=?,preco=?, categoria=? "+
        " where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setFloat(2, produto.getPreco());
        ps.setString(3, produto.getCategoria());
        ps.setInt(4,produto.getId());
        // return ps.executeUpdate()>0;
        if(ps.executeUpdate()>0) return true;
        else return false;
    }
    public boolean excluir(int id)
    throws Exception {
        String sql="Delete from tbprodutos where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate()>0;
    }
    public ArrayList<ProdutoEntity> listarTodos()
    throws Exception {
        ArrayList<ProdutoEntity> lista = new ArrayList<>();
        String sql = "select * from tbprodutos order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProdutoEntity produto = new ProdutoEntity(rs.getInt("id"), 
            rs.getString("nome"), rs.getFloat("preco"), 
            rs.getString("categoria"));
            //ou
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setCategoria(rs.getString("categoria"));
            lista.add(produto);
        }
        return lista;
    }
    public ArrayList<ProdutoEntity> pesquisar(String pesquisa)
    throws Exception {
        ArrayList<ProdutoEntity> lista = new ArrayList<>();
        String sql = "select * from tbprodutos "+
        " where nome like ? order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, pesquisa + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProdutoEntity produto = new ProdutoEntity(rs.getInt("id"), 
            rs.getString("nome"), rs.getFloat("preco"), 
            rs.getString("categoria"));
            //ou
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setCategoria(rs.getString("categoria"));
            lista.add(produto);
        }
        return lista;
    }
}
