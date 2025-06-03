import java.util.Scanner;

import banco.Conexao;
import entity.ProdutoEntity;
import repository.ProdutoRepository;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Conectandoooo....");
            Conexao conexao = new Conexao();
            System.out.println("Conectado com sucesso!!");
            ProdutoEntity produto = new ProdutoEntity();
            Scanner ler = new Scanner(System.in);
            System.out.println("Digite o nome do produto:");
            produto.setNome(ler.next());
            System.out.println("Digite o preço:");
            produto.setPreco(ler.nextFloat());
            System.out.println("Digite a categoria:");
            produto.setCategoria(ler.next());

            ProdutoRepository DAO = new ProdutoRepository();
            if(DAO.incluir(produto))
                System.out.println("Salvou!!!!");
            else
                System.out.println("opsss, não salvou...");
        } catch (Exception e) {
            System.out.println("Erro:"+ e.getMessage());
        }
    }
}
