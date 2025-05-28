import banco.Conexao;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Conectandoooo....");
            Conexao conexao = new Conexao();
            System.out.println("Conectado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Erro:"+ e.getMessage());
        }
    }
}
