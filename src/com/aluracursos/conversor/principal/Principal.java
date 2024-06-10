package com.aluracursos.conversor.principal;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int opcion = 0;

        ConsultaDivisa consulta = new ConsultaDivisa();
        Divisas divisas = consulta.busquedaDivisa("USD");
        if (divisas == null) {
            System.out.println("Error al obtener las divisas");
            return;
        }
        System.out.println("Tasas de conversión actuales: " + divisas);

        // Las comillas triples se usan para realizar un estring multilinea
        String menu = """                
                ****************************************************************
                Sea bienvenido/a al conversor de Moneda
                
                1) Dòlar =>> Peso argentino
                2) Peso argentino =>> Dòlar
                3) Dòlar =>> Real brasileño
                4) Real brasileño =>> Dòlar
                5) Dòlar =>> Peso colombiano
                6) Peso colombiano =>> Dòlar
                7) Salir.
                ELija una opciòn vàlida:
                ****************************************************************
                """;

        // EL system.in, es para que el espere un valor de entrada
        Scanner teclado = new Scanner(System.in);
        while (opcion != 7){
            System.out.println(menu);
            opcion = teclado.nextInt();

            System.out.print("Ingrese el valor que deseas convertir: ");
            float cantidad = teclado.nextFloat();

            switch (opcion){
                case 1:
                    System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + (cantidad * divisas.ARS()) + " [ARS]");
                    break;
                case 2:
                    System.out.println("El valor " + cantidad + " [ARS] corresponde al valor final de =>>> " + (cantidad / divisas.ARS()) + " [USD]");
                    break;
                case 3:
                    System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + (cantidad * divisas.BRL()) + " [BRL]");
                    break;
                case 4:
                    System.out.println("El valor " + cantidad + " [BRL] corresponde al valor final de =>>> " + (cantidad / divisas.BRL()) + " [USD]");
                    break;
                case 5:
                    System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + (cantidad * divisas.COP()) + " [COP]");
                    break;
                case 6:
                    System.out.println("El valor " + cantidad + " [COP] corresponde al valor final de =>>> " + (cantidad / divisas.COP()) + " [USD]");
                    break;
                case 7:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestro servicio");
                    break;
                default:
                    System.out.println("Opciòn no vàlida");
            }
        }
    }
}






