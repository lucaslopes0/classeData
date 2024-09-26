import java.util.Arrays;

public class principal {
    public static void main(String[] args) {
        try {
            Data2 dat = new Data2((byte) 1, (byte) 1, (short) 2010);

            System.out.println("A data padrão do construtor é: " + dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno()+".");

            dat.setDia((byte)1);
            dat.setMes((byte)1);
            dat.setAno((short)2000);

            System.out.printf("A data setada pelo usuário é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\nO dia seguinte da data setada é: "+dat.getDiaSeguinte());

            int diasAvancados = 6;


            System.out.printf("\nA data avançada em %d dias" + " é: %d/%d/%d\n", diasAvancados, dat.getDia(),dat.getMes(),dat.getAno());

            dat.getVariosDiasAdiante(diasAvancados);

            //System.out.println("\nOs dias avançados foram: "+ Arrays.toString(new Data2[]{dat.getVariosDiasAdiante(diasAvancados)}));

            System.out.printf("A data setada pelo usuário é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());



        }catch(Exception error){
            System.err.println(error.getMessage());
        }

    }
}
