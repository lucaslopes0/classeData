import java.util.Arrays;

public class principal {
    public static void main(String[] args) {
        try {
            Data2 dat = new Data2((byte) 1, (byte) 1, (short) 2010);

            System.out.println("A data padrão do construtor é: " + dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno()+".");

            dat.setDia((byte)30);
            dat.setMes((byte)12);
            dat.setAno((short)2000);

            System.out.printf("A data setada pelo usuário é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\nO dia seguinte da data setada é: "+dat.getDiaSeguinte());


            dat.avancaVariosDias(1);

            System.out.printf("\nA data avançou para: " + "%d/%d/%d\n", dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\ngetVariosDiasAdiante: "+ dat.getVariosDiasAdiante(1));
            //dat.getVariosDiasAdiante(qtddias);

            System.out.printf("\nA nova data agora é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());



        }catch(Exception error){
            System.err.println(error.getMessage());
        }

    }
}
