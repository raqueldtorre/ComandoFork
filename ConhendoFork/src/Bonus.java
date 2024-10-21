/*JOGO DA VELHA EM JAVA*/
import java.util.Scanner;

public class Bonus {

	private char[][] tabuleiro = {
	        {' ', ' ', ' '},
	        {' ', ' ', ' '},
	        {' ', ' ', ' '}
	    };
	    private char jogadorAtual = 'X';

	    public static void main(String[] args) {
	    	Bonus jogo = new Bonus();
	        jogo.iniciarJogo();
	    }

	    public void iniciarJogo() {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            exibirTabuleiro();
	            System.out.println("Jogador " + jogadorAtual + ", escolha uma linha (0-2) e uma coluna (0-2): ");
	            int linha = scanner.nextInt();
	            int coluna = scanner.nextInt();

	            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
	                System.out.println("Movimento inválido. Tente novamente.");
	                continue;
	            }

	            tabuleiro[linha][coluna] = jogadorAtual;

	            if (verificarVitoria()) {
	                exibirTabuleiro();
	                System.out.println("Jogador " + jogadorAtual + " venceu!");
	                break;
	            }

	            if (verificarEmpate()) {
	                exibirTabuleiro();
	                System.out.println("Empate!");
	                break;
	            }

	            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
	        }
	        scanner.close();
	    }

	    private void exibirTabuleiro() {
	        System.out.println("Tabuleiro:");
	        for (char[] linha : tabuleiro) {
	            System.out.println(" " + linha[0] + " | " + linha[1] + " | " + linha[2]);
	            System.out.println("---|---|---");
	        }
	    }

	    private boolean verificarVitoria() {
	        // Verificar linhas e colunas
	        for (int i = 0; i < 3; i++) {
	            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
	                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
	                return true;
	            }
	        }
	        // Verificar diagonais
	        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
	            (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
	            return true;
	        }
	        return false;
	    }

	    private boolean verificarEmpate() {
	        for (char[] linha : tabuleiro) {
	            for (char celula : linha) {
	                if (celula == ' ') {
	                    return false; // ainda há movimentos disponíveis
	                }
	            }
	        }
	        return true; // não há movimentos disponíveis

	}

}
