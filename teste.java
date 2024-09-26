public class teste {
    public static void main(String[] args) {
        int n = 5;  // exemplo com n = 5
        int[] vetor = criarVetorContagem(n);

        // Imprime o vetor
        for (int j : vetor) {
            System.out.print(j + " ");
        }
    }

    public static int[] criarVetorContagem(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = i+1;
        }
        return vetor;
    }
}
