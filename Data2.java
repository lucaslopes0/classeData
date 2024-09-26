import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Data2 {
        private byte dia, mes;
        private short ano;


        public static boolean isBissexto(short ano){
            if(ano<1582) {
                return ano % 4 == 0;
            }
            if(ano%400==0 && ano%100==0) return false;

            return ano % 4 == 0 && ano % 100 != 0;
        }

        public static boolean validaData(byte dia, byte mes, short ano) {
            if (ano < -45) return false;

            if (dia>29 && mes==2) return false;

            if (ano==0) return false;

            if ((dia<1 || dia>31) || (mes<1 || mes>12)) return false;

            if ((mes==4 || mes==6 || mes==9 || mes==11) && dia>30) return false;

            if (ano==1582 && mes==10 && dia>=5 && dia<=14) return false;

            return dia <= 28 || mes != 2 || Data2.isBissexto(ano);
        }

        public Data2 (byte dia, byte mes, short ano) throws Exception{
            if (!Data2.validaData(dia,mes,ano))
                throw new Exception("Invalid Date!");

            this.dia=dia;
            this.mes=mes;
            this.ano=ano;
        }

        public void setDia(byte dia) throws Exception{
            if(!Data2.validaData(dia, this.mes, this.ano)){
                throw new Exception("Invalid Date!");
            }
            this.dia = dia;
        }

        public byte getDia(){ return this.dia; }

        public void setMes(byte mes) throws Exception{
            if(!Data2.validaData(this.dia,mes,this.ano)){
                throw new Exception("Invalid Date!");
            }
            this.mes = mes;
        }

        public byte getMes(){ return this.mes; }

        public void setAno(short ano) throws Exception{
            if(!Data2.validaData(this.dia,this.mes,ano)){
                throw new Exception("Invalid Date!");
            }
            this.ano = ano;
        }

        public short getAno(){ return this.ano; }

        public void avancaUmDia() {
            if (this.dia == 31 && this.mes == 12 && this.ano == -1) {
                this.dia = (byte) 1;
                this.mes = (byte) 1;
                this.ano = (short) 1;
            } else if (this.ano == 1582 && this.mes == 10 && this.dia == 4)
                this.dia = (byte) 15;

            else if (Data2.validaData((byte) (this.dia + 1), this.mes, this.ano)) {
                this.dia++;
            } else if (Data2.validaData(this.dia, (byte) (this.mes + 1), this.ano)) {
                this.dia = (byte) 1;
                this.mes++;
            } else {
                this.dia = (byte) 1;
                this.mes = (byte) 1;
                this.ano++;
            }
        }
        public Data2 getDiaSeguinte() throws Exception {
            if (this.ano == 1582 && this.mes == 10 && this.dia == 4){
                return new Data2((byte)15, this.mes, this.ano);
            }
            else{
                try {
                    return new Data2((byte)(this.dia + 1), this.mes, this.ano);
                }catch (Exception erro1){
                    try{
                        return new Data2((byte)1,(byte)(this.mes + 1), this.ano);
                    }catch (Exception erro2){
                        try{
                            return new Data2((byte)1,(byte)1,(short)(this.ano + 1));
                        }catch (Exception erro3){
                            return new Data2((byte)1,(byte)1,(short)(this.ano + 2));
                        }
                    }
                }
            }
        }
        public Data2 getVariosDiasAdiante (int n) throws Exception{
            Data2 date = null;
            try{
                date = new Data2(this.dia,this.mes,this.ano);
            }catch (Exception ignored){}

            for ( int i = 0; i<n; i++) {
                if ((date.dia > 4 && date.dia < 14) && date.mes == 10 && date.ano == 1582) {
                    return new Data2((byte)15, date.mes, date.ano);
                }
                ifelse {
                    try {
                        //return new Data2(date.dia, date.mes, date.ano);
                    } catch (Exception err1) {
                        try {
                            return new Data2((byte) 1, date.mes++, date.ano);
                        } catch (Exception err2) {
                            return new Data2((byte) 1,(byte) 1, date.ano++);
                        }
                    }
                }
                date.dia++;
            }
            return new Data2(date.dia,date.mes,date.ano);
        }

    public void avancaVariosDias(int n) {
        for (int i = 0; i < n; i++) {
            this.dia++;
            if (!Data2.validaData(this.dia, this.mes, this.ano)) {
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
            if (!Data2.validaData(this.dia, this.mes, this.ano)) {
                this.dia = (byte) 1;
                this.mes = (byte) 1;
                this.ano++;
            }
        }
    }

        @Override
        public String toString(){
            return    (this.dia<10?"0":"")
                    + this.dia + "/"
                    + (this.mes<10?"0":"")
                    + this.mes+ "/"
                    + (this.ano<0?(-this.ano+"aC"):this.ano);
        }

    }


