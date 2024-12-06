package repaso1;


public class EspacioDeOcio {

    private int aforoEsqui;
    private int aforoSenderismo;
    private boolean tieneRestriccionesConfinamiento;
    private int aforoEstablecimientos;
    private int aforoPiscina;
    private PronosticoMeteorologico pronostico;

    // Constructor
    public EspacioDeOcio(int aforoEsqui, int aforoSenderismo, boolean tieneRestriccionesConfinamiento, 
                         int aforoEstablecimientos, int aforoPiscina, PronosticoMeteorologico pronostico) throws Exception {
        setAforoEsqui(aforoEsqui);
        setAforoSenderismo(aforoSenderismo);
        setTieneRestriccionesConfinamiento(tieneRestriccionesConfinamiento);
        setAforoEstablecimientos(aforoEstablecimientos);
        setAforoPiscina(aforoPiscina);
        setPronostico(pronostico);
    }

    // Getters y Setters

    public int getAforoEsqui() {
        return aforoEsqui;
    }

    public void setAforoEsqui(int aforoEsqui) throws Exception {
        if (aforoEsqui < 0) {
            throw new Exception("El aforo de esquí no puede ser negativo.");
        }
        this.aforoEsqui = aforoEsqui;
    }

    public int getAforoSenderismo() {
        return aforoSenderismo;
    }

    public void setAforoSenderismo(int aforoSenderismo) throws Exception {
        if (aforoSenderismo < 0) {
            throw new Exception("El aforo de senderismo no puede ser negativo.");
        }
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

    public void setAforoEstablecimientos(int aforoEstablecimientos) throws Exception {
        if (aforoEstablecimientos < 0) {
            throw new Exception("El aforo de los establecimientos no puede ser negativo.");
        }
        this.aforoEstablecimientos = aforoEstablecimientos;
    }

    public int getAforoPiscina() {
        return aforoPiscina;
    }

    public void setAforoPiscina(int aforoPiscina) throws Exception {
        if (aforoPiscina < 0) {
            throw new Exception("El aforo de la piscina no puede ser negativo.");
        }
        this.aforoPiscina = aforoPiscina;
    }

    public PronosticoMeteorologico getPronostico() {
        return pronostico;
    }

    public void setPronostico(PronosticoMeteorologico pronostico) throws Exception {
        if (pronostico == null) {
            throw new Exception("El pronóstico meteorológico no puede ser nulo.");
        }
        this.pronostico = pronostico;
    }

    // Métodos auxiliares
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

    public boolean tieneRestricciones() {
        return tieneRestriccionesConfinamiento;
    }
}


