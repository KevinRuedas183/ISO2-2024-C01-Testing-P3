package repaso1;


public class Usuario {

    private int dniNum;
    private char dniLetra;
    private boolean sano;
    private boolean contactoConInfectado;
    private boolean covidSuperado;
    private boolean tieneCartillaVacunacion;

    // Constructor
    public Usuario(int dniNum, char dniLetra, boolean sano, boolean contactoConInfectado, boolean covidSuperado, boolean tieneCartillaVacunacion) throws Exception {
        setDniNum(dniNum);
        setDniLetra(dniLetra);
        setSano(sano);
        setContactoConInfectado(contactoConInfectado);
        setCovidSuperado(covidSuperado);
        setTieneCartillaVacunacion(tieneCartillaVacunacion);
    }

    // Getters y Setters

    public int getDniNum() {
        return dniNum;
    }

    public void setDniNum(int dniNum) throws Exception {
        if (String.valueOf(dniNum).length() != 8 || dniNum <= 0) {
            throw new Exception("El DNI debe tener 8 dígitos y ser positivo.");
        }
        this.dniNum = dniNum;
    }

    public char getDniLetra() {
        return dniLetra;
    }

    public void setDniLetra(char dniLetra) throws Exception {
        if (!Character.isLetter(dniLetra)) {
            throw new Exception("La letra del DNI debe ser una letra alfabética.");
        }
        dniLetra = Character.toUpperCase(dniLetra); // Convertimos a mayúscula
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
