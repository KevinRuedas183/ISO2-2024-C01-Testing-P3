package repaso1;

import java.util.Scanner;

public class Main {
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