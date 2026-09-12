package br.com.fiap.gaia.view;

import br.com.fiap.gaia.dao.MissaoDao;
import br.com.fiap.gaia.model.Missao;
import java.util.Scanner;

public class ExemploMissao {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        MissaoDao dao = new MissaoDao();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU DE MISSÕES ===");
            System.out.println("1 - Cadastrar | 2 - Buscar por ID | 3 - Listar | 4 - Atualizar | 5 - Excluir | 6 - Buscar dificuldade | 0 - Sair");
            opcao = entrada.nextInt(); entrada.nextLine();
            if (opcao == 1) {
                System.out.print("Nome: "); String nome = entrada.nextLine();
                System.out.print("Descrição: "); String descricao = entrada.nextLine();
                System.out.print("Dificuldade (1 simples, 2 média, 3 difícil): "); int dificuldade = entrada.nextInt();
                System.out.print("Pontos: "); int pontos = entrada.nextInt(); entrada.nextLine();
                System.out.print("Imagem: "); String imagem = entrada.nextLine();
                Missao missao = new Missao(nome, descricao, dificuldade, pontos, imagem, 'A');
                dao.cadastrar(missao); System.out.println("Cadastrada com ID " + missao.getIdMissao());
            } else if (opcao == 2) {
                System.out.print("ID: "); int id = entrada.nextInt();
                Missao m = dao.buscarPorId(id); System.out.println(m.getIdMissao() + " - " + m.getNmMissao());
            } else if (opcao == 3) {
                for (Missao m : dao.listar()) System.out.println(m.getIdMissao() + " - " + m.getNmMissao() + " (" + m.getTpDificuldade() + ")");
            } else if (opcao == 4) {
                System.out.print("ID: "); int id = entrada.nextInt(); entrada.nextLine(); Missao m = dao.buscarPorId(id);
                System.out.print("Novo nome: "); m.setNmMissao(entrada.nextLine());
                System.out.print("Nova descrição: "); m.setDsMissao(entrada.nextLine());
                dao.atualizar(m); System.out.println("Atualizada.");
            } else if (opcao == 5) {
                System.out.print("ID: "); dao.deletar(entrada.nextInt()); System.out.println("Excluída.");
            } else if (opcao == 6) {
                System.out.print("Dificuldade: "); int d = entrada.nextInt();
                for (Missao m : dao.buscarPorDificuldade(d)) System.out.println(m.getIdMissao() + " - " + m.getNmMissao());
            } else if (opcao != 0) System.out.println("Opção inválida.");
        }
        entrada.close();
    }
}
