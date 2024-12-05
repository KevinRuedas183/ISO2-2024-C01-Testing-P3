package repaso1;

public class EspacioDeOcio {

    private int aforoEsqui;
    private int aforoSenderismo;
    private boolean tieneRestriccionesConfinamiento;
    private int aforoEstablecimientos;
    private int aforoPiscina;
    private PronosticoMeteorologico pronostico;

    public EspacioDeOcio(int aforoEsqui, int aforoSenderismo, boolean tieneRestriccionesConfinamiento, int aforoEstablecimientos, int aforoPiscina, PronosticoMeteorologico pronostico) {
        this.aforoEsqui = aforoEsqui;
        this.aforoSenderismo = aforoSenderismo;
        this.tieneRestriccionesConfinamiento = tieneRestriccionesConfinamiento;
        this.aforoEstablecimientos = aforoEstablecimientos;
        this.aforoPiscina = aforoPiscina;
        this.pronostico = pronostico;
    }

    // Getters y Setters
    public int getAforoEsqui() {
        return aforoEsqui;
    }

    public void setAforoEsqui(int aforoEsqui) {
        this.aforoEsqui = aforoEsqui;
    }

    public int getAforoSenderismo() {
        return aforoSenderismo;
    }

    public void setAforoSenderismo(int aforoSenderismo) {
        this.aforoSenderismo = aforoSenderismo;
    }

    public boolean isTieneRestriccionesConfinamiento() {
        return tieneRestriccionesConfinamiento;
    }

    public void setTieneRestriccionesConfinamiento(boolean tieneRestriccionesConfinamiento) {
        this.tieneRestriccionesConfinamiento = tieneRestriccionesConfinamiento;
    }

    public int getAforoEstablecimientos() {
        return aforoEstablecimientos;
    }

    public void setAforoEstablecimientos(int aforoEstablecimientos) {
        this.aforoEstablecimientos = aforoEstablecimientos;
    }

    public int getAforoPiscina() {
        return aforoPiscina;
    }

    public void setAforoPiscina(int aforoPiscina) {
        this.aforoPiscina = aforoPiscina;
    }

    public PronosticoMeteorologico getPronostico() {
        return pronostico;
    }

    public void setPronostico(PronosticoMeteorologico pronostico) {
        this.pronostico = pronostico;
    }

    // Métodos auxiliares para validar aforo
    public boolean esAforoEsquiDisponible() {
        return aforoEsqui > 0;
    }

    public boolean esAforoSenderismoDisponible() {
        return aforoSenderismo > 0;
    }

    public boolean esAforoEstablecimientosDisponible() {
        return aforoEstablecimientos > 0;
    }

    public boolean esAforoPiscinaDisponible() {
        return aforoPiscina > 0;
    }

    // Método para verificar si hay restricciones
    public boolean tieneRestricciones() {
        return tieneRestriccionesConfinamiento;
    }
}

