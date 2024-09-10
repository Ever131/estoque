import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class Estoque {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public void baixarProduto(int codigo, int quantidade) {
        Produto produto = produtos.get(codigo);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produto.quantidade -= quantidade;
            System.out.println("Produto baixado com sucesso!");
        } else {
            System.out.println("Produto não encontrado ou quantidade insuficiente em estoque.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventário:");
        for (Produto produto : produtos.values()) {
            System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade());
        }
    }
}

public class SistemaEstoque {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar produto");
            System.out.println("2. Baixar produto");
            System.out.println("3. Mostrar inventário");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.next();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    Produto produto = new Produto(codigo, nome, quantidade);
                    estoque.adicionarProduto(produto);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser baixado: ");
                    codigo = scanner.nextInt();
                    System.out.print("Digite a quantidade a ser baixada: ");
                    quantidade = scanner.nextInt();
                    estoque.baixarProduto(codigo, quantidade);
                    break;
                case 3:
                    estoque.mostrarInventario();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}