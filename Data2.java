public class Data2 implements Cloneable{
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

    public static boolean isDataValida(short ano, byte mes, byte dia) {
        if (ano < -45) return false;
        if (ano == 0) return false;
        if ((mes < 1 || mes > 12) || (dia < 1 || dia > 31)) return false;

        if (mes == 2 && dia > 29) return false;

        if (mes == 2) {
            if (isBissexto(ano)) {
                if (dia <= 29) return true;
                else return false;
            } else if (!isBissexto(ano)) {
                if (dia <= 28) return true;
                else return false;
            }
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;

        if (ano == 1582 && mes == 10 && dia > 4 && dia < 15) return false;

        return true;
    }

    public Data2(short ano, byte mes, byte dia) throws Exception {
        if (!Data2.isDataValida(ano, mes, dia))
            throw new Exception("Invalid Date!");
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setAno(short ano) throws Exception {
        if (!Data2.isDataValida(ano, this.mes, this.dia)) {
            throw new Exception("Invalid Date!");
        }
        this.ano = ano;
    }

    public short getAno() {
        return this.ano;
    }

    public void setMes(byte mes) throws Exception {
        if (!Data2.isDataValida(this.ano, mes, this.dia)) {
            throw new Exception("Invalid Date!");
        }
        this.mes = mes;
    }

    public byte getMes() {
        return this.mes;
    }

    public void setDia(byte dia) throws Exception {
        if (!Data2.isDataValida(this.ano, this.mes, dia)) {
            throw new Exception("Invalid Date!");
        }
        this.dia = dia;
    }

    public byte getDia() {
        return this.dia;
    }

    public Data2 getDiaSeguinte() throws Exception {
        if (this.ano == 1582 && this.mes == 10 && this.dia == 4) {
            return new Data2(this.ano, this.mes, (byte) 15);
        } else {
            try {
                return new Data2(this.ano, this.mes, (byte) (this.dia + 1));
            } catch (Exception erro1) {
                try {
                    return new Data2(this.ano, (byte) (this.mes + 1), (byte) 1);
                } catch (Exception erro2) {
                    try {
                        return new Data2((short) (this.ano + 1), (byte) 1, (byte) 1);
                    } catch (Exception erro3) {
                        return new Data2((short) (this.ano + 2), (byte) 1, (byte) 1);
                    }
                }
            }
        }
    }

    public Data2 getDiaAnterior() throws Exception {
        if (this.ano == 1582 && this.mes == 10 && this.dia == 15)
            return new Data2(this.ano, this.mes, this.dia = (byte) 4);
        else {
            try {
                return new Data2(this.ano, this.mes, (byte) (this.dia - 1));
            } catch (Exception err1) {
                try {
                    return new Data2(this.ano, (byte) (this.mes - 1), this.dia);
                } catch (Exception err2) {
                    try {
                        return new Data2((short) (this.ano - 1), this.mes, this.dia);
                    } catch (Exception err3) {
                        return new Data2((short) (this.ano - 2), this.mes, this.dia);
                    }
                }
            }
        }
    }

    public Data2 getVariosDiasAdiante(int n) throws Exception {

        Data2 date = this.clone();

        for (int i = 0; i < n; i++) {
            date = date.getDiaSeguinte();
        }
        return date;
    }

    public Data2 getVariosDiasAtras(int n) throws Exception{
        Data2 date = this.clone();

        for (int i = 0; i < n; i++) {
            date = date.getDiaAnterior();
        }
        return date;
    }

    public void avancaUmDia () {
        if (this.ano == 1582 && this.mes == 10 && this.dia == 4)
            this.dia = (byte) 15;

        else if (Data2.isDataValida(this.ano, this.mes, (byte) (this.dia + 1))) {
            this.dia++;
        } else if (Data2.isDataValida(this.ano, (byte) (this.mes + 1), (byte) 1)) {
            this.dia = (byte) 1;
            this.mes++;
        } else if (Data2.isDataValida((short) (this.ano + 1), this.mes, this.dia)) {
            this.dia = (byte) 1;
            this.mes = (byte) 1;
            this.ano++;
        } else if (Data2.isDataValida((short) (this.ano + 2), this.mes, this.dia)) {
            this.dia = (byte) 1;
            this.mes = (byte) 1;
            this.ano = (short) (this.ano + 2);
        }
    }

    public void avancaVariosDias ( int n){
        for (int i = 0; i < n; i++) {
            this.avancaUmDia();

        }
    }

    public void retrocedeUmDia () {
        if (this.dia == 15 && this.mes == 10 && this.ano == 1582) {
            this.dia = (byte) 4;
        } else if (this.dia == 1 && this.mes == 1 && this.ano == 1) {
            this.dia = (byte) 31;
            this.mes = (byte) 12;
            this.ano = (byte) -1;
        }
        if (Data2.isDataValida(this.ano, this.mes, (byte) (this.dia - 1))) {
            this.dia--;
        } else if (Data2.isDataValida(this.ano, (byte) (this.mes - 1), this.dia)) {
            if ((byte) (this.mes - 1) == 2) {
                if (Data2.isBissexto(this.ano)) {
                    this.dia = (byte) 29;
                } else {
                    this.dia = (byte) 28;
                }
            } else {
                this.dia = (byte) 31;
                if (!Data2.isDataValida(this.ano, (byte) (this.mes - 1), this.dia)) {
                    this.dia = (byte) 30;
                }
            }
            this.mes--;
        } else if (Data2.isDataValida((short) (this.ano - 1), this.mes, this.dia)) {
            this.dia = (byte) 31;
            this.mes = (byte) 12;
            this.ano--;
        }
    }

    public void retrocedeVariosDias ( int n){
        for (int i = 0; i < n; i++) {
            this.retrocedeUmDia();
        }
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        Data2 oth = (Data2)obj;

        if (oth.dia != this.dia) return false;
        if (oth.mes != this.mes) return false;
        if (oth.ano != this.ano) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int hs =1;
        hs = hs*11+ Short.valueOf(this.ano).hashCode();
        hs = hs*11+ Byte.valueOf(this.mes).hashCode();
        hs = hs*11+ Byte.valueOf(this.dia).hashCode();

        if(hs<0) hs=-hs;

        return hs;
    }

    @Override
    public Data2 clone(){
        Data2 date = null;
        try{
            date= new Data2(this.ano,this.mes,this.dia);
        }catch (Exception ignored){}
        return date;
    }

    @Override
    public String toString () {
        return (this.dia < 10 ? "0" : "")
                + this.dia + "/"
                + (this.mes < 10 ? "0" : "")
                + this.mes + "/"
                + (this.ano > 0 && this.ano < 10 ? "0" : "")
                + (this.ano < 0 ? (-this.ano + " aC") : this.ano);
    }
}



