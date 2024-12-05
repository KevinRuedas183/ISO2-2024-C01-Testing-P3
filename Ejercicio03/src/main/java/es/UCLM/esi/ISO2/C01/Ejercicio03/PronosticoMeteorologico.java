package repaso1;

public class PronosticoMeteorologico {

    private int temperatura;
    private int porcentajeHumedadRelativa;
    private Precipitaciones precipitaciones;

    public PronosticoMeteorologico(int temperatura, int porcentajeHumedadRelativa, Precipitaciones precipitaciones) {
        this.temperatura = temperatura;
        this.porcentajeHumedadRelativa = porcentajeHumedadRelativa;
        this.precipitaciones = precipitaciones;
    }

    // Getters y Setters
    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getPorcentajeHumedadRelativa() {
        return porcentajeHumedadRelativa;
    }

    public void setPorcentajeHumedadRelativa(int porcentajeHumedadRelativa) {
        this.porcentajeHumedadRelativa = porcentajeHumedadRelativa;
    }

    public Precipitaciones getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(Precipitaciones precipitaciones) {
        this.precipitaciones = precipitaciones;
    }

    // Métodos auxiliares para el clima
    public boolean esClimaNevado() {
        return temperatura < 0 && porcentajeHumedadRelativa < 15 && (precipitaciones == Precipitaciones.nieve || precipitaciones == Precipitaciones.lluvia);
    }

    public boolean esClimaEsquiable() {
        return temperatura < 0 && porcentajeHumedadRelativa < 15 && precipitaciones == null;
    }
}
