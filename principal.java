import java.util.Arrays;

public class principal {
    public static void main(String[] args) {
        try {
            Data2 dat = new Data2((byte) 1, (byte) 1, (short) 2010);

            System.out.println("A data padrão do construtor é: " + dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno()+".");

            dat.setDia((byte)29);
            dat.setMes((byte)2);
            dat.setAno((short)2000);

            System.out.printf("A data setada pelo usuário é: %d/%d/%d\n",
                    dat.getDia(),dat.getMes(),dat.getAno());

            int avanc = 5;

            dat.avancaVariosDias(avanc);

            System.out.println("\nA data avançou em "+ avanc + " dias," + "então a nova data é: " +dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno());

            dat.retrocedeUmDia();

            System.out.printf("\nA data retrocedeu um dia, então agora a nova data é: %d/%d/%d\n", dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\nO dia seguinte da data setada será: "+dat.getDiaSeguinte());

            System.out.println("\nO dia anterior da data setada foi: "+dat.getDiaAnterior());

            System.out.println("\nA data daqui "+avanc+" dias é: " + dat.getVariosDiasAdiante(avanc));


        }catch(Exception error){
            System.err.println(error.getMessage());
        }

    }
}
