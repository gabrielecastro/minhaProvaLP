public class Jogador {
    public String nome;
    public int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public void incrementaUmVoto() {
        this.votos = getVotos() + 1;
    }

    public int getVotos() {
        return votos;
    }

    public String getNome() {
        return nome;
    }
}
