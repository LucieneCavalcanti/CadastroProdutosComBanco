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
            ProdutoRepository DAO = new ProdutoRepository();
            int opcao = 0;
            do {
                System.out.println("######   MENU  ######");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Editar produto");
                System.out.println("3 - Excluir produto");
                System.out.println("4 - Listar todos os produtos");
                System.out.println("10 - SAIR");
                opcao=ler.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("++++++++++++ INCLUSÃO ++++++++++++++");
                        System.out.println("Digite o nome do produto:");
                        produto.setNome(ler.next());
                        System.out.println("Digite o preço:");
                        produto.setPreco(ler.nextFloat());
                        System.out.println("Digite a categoria:");
                        produto.setCategoria(ler.next());
                        if(DAO.incluir(produto))
                            System.out.println("Salvou!!!!");
                        else
                            System.out.println("opsss, não salvou...");
                        break;
                    case 2:
                        System.out.println("++++++++++++ ALTERAÇÃO ++++++++++++++");
                        System.out.println("Digite o id:");
                        produto.setId(ler.nextInt());
                        System.out.println("Digite o nome do produto:");
                        produto.setNome(ler.next());
                        System.out.println("Digite o preço:");
                        produto.setPreco(ler.nextFloat());
                        System.out.println("Digite a categoria:");
                        produto.setCategoria(ler.next());
                        if(DAO.editar(produto))
                            System.out.println("Atualizado!!!!");
                        else
                            System.out.println("opsss, não atualizou...");
                        break;
                    case 3:
                        System.out.println("-------- Exclusão --------");
                        System.out.println("Digite o id do produto:");
                        int id = ler.nextInt();
                        if(DAO.excluir(id)) System.out.println("Excluído");
                        else System.out.println("Erro ao Excluir....");
                        break;
                    default:
                        break;
                }
            } while (opcao!=10);

            
        } catch (Exception e) {
            System.out.println("Erro:"+ e.getMessage());
        }
    }
}
