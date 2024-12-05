package repaso1;

public class Usuario {

    private int dniNum;
    private char dniLetra;
    private boolean sano;
    private boolean contactoConInfectado;
    private boolean covidSuperado;
    private boolean tieneCartillaVacunacion;

    public Usuario(int dniNum, char dniLetra, boolean sano, boolean contactoConInfectado, boolean covidSuperado, boolean tieneCartillaVacunacion) {
        this.dniNum = dniNum;
        this.dniLetra = dniLetra;
        this.sano = sano;
        this.contactoConInfectado = contactoConInfectado;
        this.covidSuperado = covidSuperado;
        this.tieneCartillaVacunacion = tieneCartillaVacunacion;
    }

    // Getters y Setters
    public int getDniNum() {
        return dniNum;
    }

    public void setDniNum(int dniNum) {
        this.dniNum = dniNum;
    }

    public char getDniLetra() {
        return dniLetra;
    }

    public void setDniLetra(char dniLetra) {
        this.dniLetra = dniLetra;
    }

    public boolean isSano() {
        return sano;
    }

    public void setSano(boolean sano) {
        this.sano = sano;
    }

    public boolean isContactoConInfectado() {
        return contactoConInfectado;
    }

    public void setContactoConInfectado(boolean contactoConInfectado) {
        this.contactoConInfectado = contactoConInfectado;
    }

    public boolean isCovidSuperado() {
        return covidSuperado;
    }

    public void setCovidSuperado(boolean covidSuperado) {
        this.covidSuperado = covidSuperado;
    }

    public boolean isTieneCartillaVacunacion() {
        return tieneCartillaVacunacion;
    }

    public void setTieneCartillaVacunacion(boolean tieneCartillaVacunacion) {
        this.tieneCartillaVacunacion = tieneCartillaVacunacion;
    }
}
