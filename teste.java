public class teste {
    public static void main(String[] args) {
        int n = 5;  // exemplo com n = 5
        int[] vetor = criarVetorContagem(n);

        // Imprime o vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    public static int[] criarVetorContagem(int n) {
        int vetor[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            vetor[i] = i;
        }
        return vetor;
    }
}
