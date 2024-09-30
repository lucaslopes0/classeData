import java.util.Arrays;

public class principal {
    public static void main(String[] args) {
        try {
            Data2 dat = new Data2((short) 2010, (byte) 1, (byte) 1);

            System.out.println("A data padrão do construtor é: " + dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno()+".");

            dat.setAno((short)2000);
            dat.setMes((byte)2);
            dat.setDia((byte)29);



            System.out.printf("A data setada pelo usuário é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

            dat.avancaUmDia();

            System.out.println("\nA data avançou em um dia, " + "então a nova data é: " +dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno());

            int avanc = 2;

            dat.avancaVariosDias(avanc);

            System.out.println("\nA data avançou em "+ avanc + " dias," + "então a nova data é: " +dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno());

            dat.retrocedeUmDia();

            System.out.printf("\nA data retrocedeu um dia, então agora a nova data é: %d/%d/%d\n", dat.getDia(),dat.getMes(),dat.getAno());

            dat.retrocedeVariosDias(avanc);

            System.out.printf("\nA data retrocedeu em "+avanc+" dias, então agora a nova data é: %d/%d/%d\n", dat.getDia(),dat.getMes(),dat.getAno());

            System.out.printf("\nA data atual é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\nO dia seguinte da data atual será: "+dat.getDiaSeguinte());

            System.out.println("\nO dia anterior da data atual foi: "+dat.getDiaAnterior());

            System.out.println("\nA data daqui "+avanc+" dias será dia: " + dat.getVariosDiasAdiante(avanc));

            System.out.println("\nA data à "+avanc+" dias será dia: " + dat.getVariosDiasAtras(avanc));

            System.out.printf("\nA data atual é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

        }catch(Exception error){
            System.err.println(error.getMessage());
        }

    }
}
