package repaso1;

public class PronosticoMeteorologico {

    private int temperatura;
    private int porcentajeHumedadRelativa;
    private Precipitaciones precipitaciones;

    // Constructor
    public PronosticoMeteorologico(int temperatura, int porcentajeHumedadRelativa, Precipitaciones precipitaciones) throws Exception {
        setTemperatura(temperatura);
        setPorcentajeHumedadRelativa(porcentajeHumedadRelativa);
        setPrecipitaciones(precipitaciones);
    }

    // Getters y Setters

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) throws Exception {
        if (temperatura < -100 || temperatura > 100) {
            throw new Exception("La temperatura debe estar entre -100 y 100 grados.");
        }
        this.temperatura = temperatura;
    }

    public int getPorcentajeHumedadRelativa() {
        return porcentajeHumedadRelativa;
    }

    public void setPorcentajeHumedadRelativa(int porcentajeHumedadRelativa) throws Exception {
        if (porcentajeHumedadRelativa < 0 || porcentajeHumedadRelativa > 100) {
            throw new Exception("El porcentaje de humedad relativa debe estar entre 0 y 100.");
        }
        this.porcentajeHumedadRelativa = porcentajeHumedadRelativa;
    }

    public Precipitaciones getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(Precipitaciones precipitaciones) throws Exception {
        if (precipitaciones == null) {
            throw new Exception("El tipo de precipitaciones no puede ser nulo.");
        }
        this.precipitaciones = precipitaciones;
    }

}

