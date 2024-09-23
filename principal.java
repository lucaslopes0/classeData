import java.util.Arrays;

public class principal {
    public static void main(String[] args) {
        try {
            Data2 dat = new Data2((byte) 1, (byte) 1, (short) 2010);

            System.out.println("A data padrão é: " + dat.getDia()+"/"+dat.getMes()+"/"+dat.getAno()+".");

            dat.setDia((byte)1);
            dat.setMes((byte)1);
            dat.setAno((short)2000);

            System.out.printf("A data setada pelo usuário é: %d/%d/%d",
                    dat.getDia(),dat.getMes(),dat.getAno());

            //System.out.println("\nO dia seguinte da data setada é: "+dat.getDiaSeguinte());

            dat.avancaVariosDias(5);

            System.out.printf("\nA data setada atualmente é: %d/%d/%d",dat.getDia(),dat.getMes(),dat.getAno());

            System.out.println("\ngetVariosDias: "+ Arrays.toString(dat.getVariosDias(5)));



        }catch(Exception error){
            System.err.println(error.getMessage());
        }

    }
}
