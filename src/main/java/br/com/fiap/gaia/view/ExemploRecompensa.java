package br.com.fiap.gaia.view;

import br.com.fiap.gaia.dao.RecompensaDao;
import br.com.fiap.gaia.model.Recompensa;
import java.util.Scanner;

public class ExemploRecompensa {
    public static void main(String[] args) throws Exception {
        Scanner e = new Scanner(System.in); RecompensaDao dao = new RecompensaDao(); int op = -1;
        while (op != 0) {
            System.out.println("\n=== MENU DE RECOMPENSAS ===\n1-Cadastrar  2-Buscar ID  3-Listar  4-Atualizar  5-Excluir  0-Sair");
            op = e.nextInt(); e.nextLine();
            if (op == 1) { System.out.print("Nome: "); String n=e.nextLine(); System.out.print("Descrição: "); String d=e.nextLine(); System.out.print("Tipo acessório: "); String t=e.nextLine(); System.out.print("Custo: "); int c=e.nextInt(); e.nextLine(); System.out.print("Imagem: "); String i=e.nextLine(); Recompensa r=new Recompensa(n,d,t,c,i,'A'); dao.cadastrar(r); System.out.println("Cadastrada: "+r.getIdRecompensa()); }
            else if (op == 2) { System.out.print("ID: "); Recompensa r=dao.buscarPorId(e.nextInt()); System.out.println(r.getIdRecompensa()+" - "+r.getNmRecompensa()); }
            else if (op == 3) { for (Recompensa r:dao.listar()) System.out.println(r.getIdRecompensa()+" - "+r.getNmRecompensa()+" ("+r.getNrCustoPontos()+" pontos)"); }
            else if (op == 4) { System.out.print("ID: "); Recompensa r=dao.buscarPorId(e.nextInt()); e.nextLine(); System.out.print("Novo nome: "); r.setNmRecompensa(e.nextLine()); System.out.print("Novo custo: "); r.setNrCustoPontos(e.nextInt()); dao.atualizar(r); System.out.println("Atualizada."); }
            else if (op == 5) { System.out.print("ID: "); dao.deletar(e.nextInt()); System.out.println("Excluída."); }
            else if (op != 0) System.out.println("Opção inválida.");
        } e.close();
    }
}
