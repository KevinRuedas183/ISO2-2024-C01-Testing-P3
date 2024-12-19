package repaso1;
import java.util.Scanner;

public class RecomendadorActividades {

    /**
     * Verifica si el usuario está sano y puede realizar actividades
     * parámetro: Usuario que se evalúa
     * devuelve true si el usuario está sano y cumple con las condiciones básicas
     */
    public boolean usuarioValido(Usuario usuario) {
        boolean res = false;
        if (usuario.isSano() && usuario.isCovidSuperado() && usuario.isTieneCartillaVacunacion()) {
            res = true;
        }
        return res;
    }

    /**
     * Genera una recomendación de actividad para el usuario según las condiciones
     * parámetro: usuario Usuario que se evalúa
     * parámetro: espacio Espacio de ocio donde se evaluará la actividad
     * devuelve la actividad recomendada según las condiciones
     */
    public String recomendacionActividad(Usuario usuario, EspacioDeOcio espacio) {
        // Verifica si el usuario cumple las condiciones básicas
        if (!usuarioValido(usuario)) {
            return "No puede realizar ninguna actividad.";
        }

        // Obtene las condiciones meteorológicas del espacio
        PronosticoMeteorologico pronostico = espacio.getPronostico();

        // Analiza condiciones específicas basadas en el clima
        if (esClimaNevado(pronostico)) {
            return "Quédese en casa.";
        }

        if (esClimaEsquiable(pronostico)) {
            if (espacio.getAforoEsqui() > 0) {
                return "Puede ir a esquiar.";
            } else {
                return "No se puede esquiar, aforo completo.";
            }
        }

        if (esClimaSenderismo(pronostico)) {
            if (espacio.getAforoSenderismo() > 0) {
                return "Puede ir a hacer senderismo.";
            } else {
                return "No puede hacer senderismo, aforo completo.";
            }
        }

        if (esClimaTurismo(pronostico)) {
            if (!espacio.tieneRestricciones()) {
                return "Puede ir a hacer turismo al aire libre.";
            } else {
                return "No puede hacer turismo, hay restricciones de confinamiento.";
            }
        }

        if (esClimaCañas(pronostico)) {
            if (espacio.getAforoEstablecimientos() > 0) {
                return "Puede irse de cañas.";
            } else {
                return "No puede irse de cañas, aforo completo.";
            }
        }

        if (esClimaPlayaPiscina(pronostico)) {
            if (espacio.getAforoPiscina() > 0) {
                return "Puede ir a la playa o a la piscina.";
            } else {
                return "No puede ir a la piscina, aforo completo.";
            }
        }

        return "No hay recomendaciones específicas.";
    }

    
    // Métodos auxiliares para evaluar las condiciones 

    private boolean PrecipitacionesNieveLLuvia(PronosticoMeteorologico pronostico) {
    	boolean resultado = false;
    	if(pronostico.getPrecipitaciones() == Precipitaciones.nieve || pronostico.getPrecipitaciones() == Precipitaciones.lluvia) {
    		resultado = true;
    	}
    	return resultado;
    }
    
    private boolean NoPrecipitacionesNieveLLuvia(PronosticoMeteorologico pronostico) {
    	boolean resultado = false;
    	if(pronostico.getPrecipitaciones() != Precipitaciones.nieve || pronostico.getPrecipitaciones() != Precipitaciones.lluvia) {
    		resultado = true;
    	}
    	return resultado;
    }
    
    private boolean NoPrecipitacionesNubesLLuvia(PronosticoMeteorologico pronostico) {
    	boolean resultado = false;
    	if(pronostico.getPrecipitaciones() != Precipitaciones.nubes || pronostico.getPrecipitaciones() != Precipitaciones.lluvia) {
    		resultado = true;
    	}
    	return resultado;
    }
    
    private boolean TemperaturaTurismo(PronosticoMeteorologico pronostico) {
    	boolean resultado = false;
    	if(pronostico.getTemperatura() >= 15 && pronostico.getTemperatura() < 25) {
    		resultado = true;
    	}
    	return resultado;
    }
    
    private boolean esClimaNevado(PronosticoMeteorologico pronostico) {
        boolean resultado = false;
    	if(pronostico.getTemperatura() < 0
                && pronostico.getPorcentajeHumedadRelativa() < 15
                && PrecipitacionesNieveLLuvia(pronostico)){
    		resultado = true;
    	}
    	return resultado;
    }

    private boolean esClimaEsquiable(PronosticoMeteorologico pronostico) {
        boolean resultado = false;
    	
    	if(pronostico.getTemperatura() < 0
                && pronostico.getPorcentajeHumedadRelativa() < 15
                && NoPrecipitacionesNieveLLuvia(pronostico)) {
    		resultado = true;
    	}
    	return resultado;
    }
    	
    

    private boolean esClimaSenderismo(PronosticoMeteorologico pronostico) {
        boolean resultado = false;
    	if(pronostico.getTemperatura() >= 0 && pronostico.getTemperatura() < 15
                && pronostico.getPrecipitaciones() != Precipitaciones.lluvia) {
    		resultado = true;
    	}
    	return resultado;
    }

    
    private boolean esClimaTurismo(PronosticoMeteorologico pronostico) {
       boolean resultado = false;
       if(TemperaturaTurismo(pronostico)
                && (NoPrecipitacionesNubesLLuvia(pronostico))
                && pronostico.getPorcentajeHumedadRelativa() <= 60) {
    	   resultado = true;
       }
       return resultado;
    }

    private boolean esClimaCañas(PronosticoMeteorologico pronostico) {
        boolean resultado = false;
        if(pronostico.getTemperatura() >= 25 && pronostico.getTemperatura() < 35
                && pronostico.getPrecipitaciones() != Precipitaciones.lluvia) {
        	resultado = true;
        }
        return resultado;
    }

    private boolean esClimaPlayaPiscina(PronosticoMeteorologico pronostico) {
        boolean resultado = false;
    	if(pronostico.getTemperatura() > 30
                && pronostico.getPrecipitaciones() != Precipitaciones.lluvia) {
    		resultado = true;
    	}
    	return resultado;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Recogemos datos del usuario
            System.out.println("Introduce los datos del usuario:");
            System.out.print("DNI (número, 8 dígitos): ");
            int dniNum = scanner.nextInt();
            System.out.print("Letra del DNI: ");
            char dniLetra = scanner.next().charAt(0);
            System.out.print("¿El usuario está sano? (true/false): ");
            boolean sano = scanner.nextBoolean();
            System.out.print("¿El usuario ha estado en contacto con infectados? (true/false): ");
            boolean contactoConInfectado = scanner.nextBoolean();
            System.out.print("¿El usuario ha superado el COVID? (true/false): ");
            boolean covidSuperado = scanner.nextBoolean();
            System.out.print("¿El usuario tiene cartilla de vacunación? (true/false): ");
            boolean tieneCartillaVacunacion = scanner.nextBoolean();

            Usuario usuario = new Usuario(dniNum, dniLetra, sano, contactoConInfectado, covidSuperado, tieneCartillaVacunacion);

            // Recogemos datos del pronóstico meteorológico
            System.out.println("\nIntroduce los datos del pronóstico meteorológico:");
            System.out.print("Temperatura (en grados Celsius): ");
            int temperatura = scanner.nextInt();
            System.out.print("Porcentaje de humedad relativa: ");
            int porcentajeHumedadRelativa = scanner.nextInt();
            System.out.print("Precipitaciones (lluvia, nieve, nubes): ");
            String tipoPrecipitaciones = scanner.next();
            Precipitaciones precipitaciones = Precipitaciones.valueOf(tipoPrecipitaciones.toLowerCase());

            PronosticoMeteorologico pronostico = new PronosticoMeteorologico(temperatura, porcentajeHumedadRelativa, precipitaciones);

            // Recogemos datos del espacio de ocio
            System.out.println("\nIntroduce los datos del espacio de ocio:");
            System.out.print("Aforo para esquí: ");
            int aforoEsqui = scanner.nextInt();
            System.out.print("Aforo para senderismo: ");
            int aforoSenderismo = scanner.nextInt();
            System.out.print("Aforo para establecimientos: ");
            int aforoEstablecimientos = scanner.nextInt();
            System.out.print("Aforo para piscina: ");
            int aforoPiscina = scanner.nextInt();
            System.out.print("¿Tiene restricciones de confinamiento? (true/false): ");
            boolean tieneRestriccionesConfinamiento = scanner.nextBoolean();

            EspacioDeOcio espacio = new EspacioDeOcio(aforoEsqui, aforoSenderismo, tieneRestriccionesConfinamiento, aforoEstablecimientos, aforoPiscina, pronostico);

            // Creamos una instancia de RecomendadorActividades
            RecomendadorActividades recomendador = new RecomendadorActividades();

            // Obtenemos y mostramos la recomendación
            String recomendacion = recomendador.recomendacionActividad(usuario, espacio);
            System.out.println("\nRecomendación de actividad: " + recomendacion);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
