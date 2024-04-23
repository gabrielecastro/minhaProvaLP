
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

        // inicializa participantes
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
                "Yasmin Brunet"};

        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }

        JOptionPane.showMessageDialog(null, "Bem-vindo à Casa Mais Vigiada do Brasil!");

        String voto = null;

        do {
            voto = JOptionPane.showInputDialog("Vote em quem você deseja eliminar da casa ou digite 'sair' para encerrar:");
            if (!voto.equalsIgnoreCase("sair")) {
                registrarVoto(jogadores, voto);
            }
        } while (!voto.equalsIgnoreCase("sair"));

        Jogador eliminado = encontrarJogadorEliminado(jogadores);

        if (eliminado != null) {
            JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n "
                    + "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir\n "
                    + "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te "
                    + "eliminar com alegria.\n Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Não houve eliminação nesta votação.");
        }

    }

    private static void registrarVoto(ArrayList<Jogador> participantes, String voto) {
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto registrado para " + jogador.getNome());
                return;
            }
        }
        System.out.println("O participante '" + voto + "' não foi encontrado.");
    }

    private static Jogador encontrarJogadorEliminado(ArrayList<Jogador> jogadores) {
        Jogador eliminado = null;
        int maxVotos = 0;

        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                eliminado = jogador;
            }
        }
        return eliminado;
    }
}
