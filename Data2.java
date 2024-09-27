import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Data2 {
    private byte dia, mes;
    private short ano;


    public static boolean isBissexto(short ano) {
        if (ano < 1582) {
            return ano % 4 == 0;
        }

        if (ano % 400 == 0) {
            return true;
        }
        if (ano % 100 == 0) {
            return false;
        }
        return ano % 4 == 0;
    }

    public static boolean isDataValida(byte dia, byte mes, short ano) {
        if (ano == 0 || ano < -45) return false;
        if ((mes < 1 || mes > 12) || (dia < 1 || dia > 31)) return false;

        if (mes == 2) {
            if (isBissexto(ano)) {
                if (dia<=29) return true;
            } else {
                if (dia<=28) return true;
            }
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;

        if (ano == 1582 && mes == 10 && dia > 4 && dia < 15) return false;

        return true;
    }

    public Data2(byte dia, byte mes, short ano) throws Exception {
        if (!Data2.isDataValida(dia, mes, ano))
            throw new Exception("Invalid Date!");
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia(byte dia) throws Exception {
        if (!Data2.isDataValida(dia, this.mes, this.ano)) {
            throw new Exception("Invalid Date!");
        }
        this.dia = dia;
    }

    public byte getDia() {
        return this.dia;
    }

    public void setMes(byte mes) throws Exception {
        if (!Data2.isDataValida(this.dia, mes, this.ano)) {
            throw new Exception("Invalid Date!");
        }
        this.mes = mes;
    }

    public byte getMes() {
        return this.mes;
    }

    public void setAno(short ano) throws Exception {
        if (!Data2.isDataValida(this.dia, this.mes, ano)) {
            throw new Exception("Invalid Date!");
        }
        this.ano = ano;
    }

    public short getAno() {
        return this.ano;
    }

    public Data2 getDiaSeguinte() throws Exception {
        if (this.ano == 1582 && this.mes == 10 && this.dia == 4) {
            return new Data2((byte) 15, this.mes, this.ano);
        } else {
            try {
                return new Data2((byte) (this.dia + 1), this.mes, this.ano);
            } catch (Exception erro1) {
                try {
                    return new Data2((byte) 1, (byte) (this.mes + 1), this.ano);
                } catch (Exception erro2) {
                    try {
                        return new Data2((byte) 1, (byte) 1, (short) (this.ano + 1));
                    } catch (Exception erro3) {
                        return new Data2((byte) 1, (byte) 1, (short) (this.ano + 2));
                    }
                }
            }
        }
    }

    public Data2 getDiaAnterior() throws Exception {
        if (this.ano == 1582 && this.mes == 10 && this.dia == 15)
            return new Data2(this.dia = (byte) 4,this.mes,this.ano);
        else {
            try {
                return new Data2((byte)(this.dia - 1), this.mes, this.ano);
            }catch (Exception err1){
                try {
                    return new Data2(this.dia, (byte)(this.mes - 1), this.ano);
                }catch (Exception err2){
                    try {
                        return new Data2(this.dia, this.mes ,(short)(this.ano - 1));
                    }catch (Exception err3){
                        return new Data2(this.dia, this.mes ,(short)(this.ano - 2));
                    }
                }
            }
        }
    }

    public Data2 getVariosDiasAdiante(int n) throws Exception {

        Data2 date = null;
        try {
            date = new Data2(this.dia, this.mes, this.ano);
        } catch (Exception ignored) {}

        for (int i = 0; i < n; i++) {
            if ((date.dia > 4 && date.dia < 14) && date.mes == 10 && date.ano == 1582) {
                return new Data2((byte) 15, date.mes, date.ano);
            } else {
                try {
                    date.dia++;
                } catch (Exception err1) {
                    try {
                        return new Data2((byte) 1, date.mes++, date.ano);
                    } catch (Exception err2) {
                        return new Data2((byte) 1, (byte) 1, date.ano++);
                    }
                }

            }

        }
        return new Data2(date.dia, date.mes, date.ano);
    }

    public void avancaUmDia() {
        if (this.dia == 31 && this.mes == 12 && this.ano == -1) {
            this.dia = (byte) 1;
            this.mes = (byte) 1;
            this.ano = (short) 1;
        } else if (this.ano == 1582 && this.mes == 10 && this.dia == 4)
            this.dia = (byte) 15;

        else if (Data2.isDataValida((byte) (this.dia + 1), this.mes, this.ano)) {
            this.dia++;
        } else if (Data2.isDataValida(this.dia, (byte) (this.mes + 1), this.ano)) {
            this.dia = (byte) 1;
            this.mes++;
        } else {
            this.dia = (byte) 1;
            this.mes = (byte) 1;
            this.ano++;
        }
    }


    //arrumar o avancaVariosDias
    public void avancaVariosDias(int n) {
        for (int i = 0; i < n; i++) {
            this.dia++;
            if (!Data2.isDataValida(this.dia, this.mes, this.ano)) {
                if (!Data2.isBissexto(this.ano) && this.dia == 29 && this.mes == 2) {
                    continue;
                }
                if ((this.dia>4 && this.dia<14) && this.mes==10 && this.ano==1582){
                    this.dia=(byte)15;
                    continue;
                }
                this.dia = (byte) 1;
                this.mes++;
            }
            if (!Data2.isDataValida(this.dia, this.mes, this.ano)) {
                this.dia = (byte) 1;
                this.mes = (byte) 1;
                this.ano++;
            }
        }
    }


    public void retrocedeUmDia() {
        if (this.dia == 15 && this.mes == 10 && this.ano == 1582) {
            this.dia = (byte) 4;
        } else if (this.dia == 1 && this.mes == 1 && this.ano == 1) {
            this.dia = (byte) 31;
            this.mes = (byte) 12;
            this.ano = (byte) -1;
        }
        if (Data2.isDataValida((byte)(this.dia - 1), this.mes, this.ano)) {
            this.dia--;
        }
        else if (Data2.isDataValida(this.dia, (byte) (this.mes - 1), this.ano)) {
            if ((byte)(this.mes-1) == 2){
                if (Data2.isBissexto(this.ano)){
                    this.dia = (byte) 29;
                }
                else {
                    this.dia = (byte) 28;
                }
            }else {
                this.dia = (byte) 31;
                if (!Data2.isDataValida(this.dia, (byte) (this.mes - 1), this.ano)) {
                    this.dia = (byte) 30;
                }
            }
            this.mes--;
        }
        else if (Data2.isDataValida(this.dia, this.mes, (short) (this.ano - 1))) {
            this.dia = (byte) 31;
            this.mes = (byte) 12;
            this.ano--;
        }
    }
    @Override
    public String toString(){
        return    (this.dia<10?"0":"")
                + this.dia + "/"
                + (this.mes<10?"0":"")
                + this.mes+ "/"
                + (this.ano>0 && this.ano<10?"0":"")
                + (this.ano<0?(-this.ano+" aC"):this.ano);
    }

}


