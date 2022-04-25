package proyectosos_2_235666;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {

    public static Scanner scanner = new Scanner(System.in);

    public static Tareas tareas[] = new Tareas[25];

    public static int cProceso = 0;

    public static int mTotal = 50000;
    public static int mUsada = 0;
    public static int mLibre = 50000;

    public static int cProcesos = 0;

    public static void main(String[] args) {

        tareas[0] = new Tareas(1, 5760, "Detenido");
        tareas[1] = new Tareas(2, 4190, "Detenido");
        tareas[2] = new Tareas(3, 3290, "Detenido");
        tareas[3] = new Tareas(4, 2030, "Detenido");
        tareas[4] = new Tareas(5, 2550, "Detenido");
        tareas[5] = new Tareas(6, 6990, "Detenido");
        tareas[6] = new Tareas(7, 8940, "Detenido");
        tareas[7] = new Tareas(8, 740, "Detenido");
        tareas[8] = new Tareas(9, 3930, "Detenido");
        tareas[9] = new Tareas(10, 6890, "Detenido");
        tareas[10] = new Tareas(11, 6580, "Detenido");
        tareas[11] = new Tareas(12, 3820, "Detenido");
        tareas[12] = new Tareas(13, 9140, "Detenido");
        tareas[13] = new Tareas(14, 420, "Detenido");
        tareas[14] = new Tareas(15, 220, "Detenido");
        tareas[15] = new Tareas(16, 7540, "Detenido");
        tareas[16] = new Tareas(17, 3210, "Detenido");
        tareas[17] = new Tareas(18, 1380, "Detenido");
        tareas[18] = new Tareas(19, 9350, "Detenido");
        tareas[19] = new Tareas(20, 3610, "Detenido");
        tareas[20] = new Tareas(21, 7540, "Detenido");
        tareas[21] = new Tareas(22, 2710, "Detenido");
        tareas[22] = new Tareas(23, 8390, "Detenido");
        tareas[23] = new Tareas(24, 5950, "Detenido");
        tareas[24] = new Tareas(25, 760, "Detenido");
        sendMessage();
        pFor();
    }

    public static void sFor() {

        for (int i = 0; i < tareas.length; i++) {
            if (tareas[i].getBloqueMemoria() == 1) {
                tareas[i].setEstado("Terminado");
                tareas[i].setBloqueMemoria(0);
                
                mUsada -= tareas[i].getTamaño();
                mLibre = mTotal - mUsada;

                for (int j = 0; j < tareas.length; j++) {
                    if (tareas[j].getEstado().equalsIgnoreCase("Ejecutando")) {
                        if (!((tareas[j].getBloqueMemoria() - 1) <= 0)) {
                            tareas[j].setBloqueMemoria(tareas[j].getBloqueMemoria() - 1);
                        }
                    }
                }
                cProceso -= 1;
                sendMessage();
                pFor();
            }
        }
    }

    public static void pFor() {

        for (int i = 0; i < tareas.length; i++) {

            if (mLibre >= tareas[i].getTamaño()) {
                if (tareas[i].getEstado().equalsIgnoreCase("Detenido") || tareas[i].getEstado().equalsIgnoreCase("Espera")) {
                    cProceso++;

                    tareas[i].setEstado("Ejecutando");
                    tareas[i].setBloqueMemoria(cProceso);

                    mUsada = mUsada + tareas[i].getTamaño();
                    mLibre = mTotal - mUsada;

                    sendMessage();
                }
            } else if ((tareas[i].getEstado().equalsIgnoreCase("Detenido"))) {
                tareas[i].setEstado("Espera");
                sendMessage();
            }
        }

        for (int i = 0; i < tareas.length; i++) {
            if (tareas[i].getEstado().equalsIgnoreCase("Terminado")) {
                cProcesos++;
            }
        }

        if (cProcesos >= 25) {
            sendMessage();
            System.out.println("");
            System.out.println("* LA EJECUCION TERMINO *");
            System.exit(0);
        }

        cProcesos = 0;

        sFor();
    }

    public static void sendMessage() {
        int j = 0;
        System.out.println("");
        System.out.printf("%9s %9s %9s %20s %12s %12s %n", "Estado del proceso:", "Numumero:", "Tamaño:", "Bloque de memoria:", "Tamaño:", "Proceso:");
        for (int i = 0; i < tareas.length; i++) {
            if (tareas[i].getEstado().equalsIgnoreCase("Ejecutando")) {
                if (tareas[i].getBloqueMemoria() <= 0) {
                    System.out.printf("%10s %13d %12d %20d %11d %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño(), tareas[i].getTamaño(), tareas[i].getNumero());
                } else {
                    System.out.printf("%10s %13d %12d %12s %20d %11d %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño(), tareas[i].getBloqueMemoria(), tareas[i].getTamaño(), tareas[i].getNumero());
                }

            } else {
                if (tareas[i].getBloqueMemoria() <= 0) {
                    System.out.printf("%10s %13d %12d %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño());
                } else {
                    System.out.printf("%10s %13d %12d %12s %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño(), tareas[i].getBloqueMemoria());
                }
            }

        }

        System.out.println("");

        System.out.println("Memorial total: " + mTotal);
        System.out.println("Memoria usada: " + mUsada);
        System.out.println("Memoria libre: " + mLibre);
        System.out.println("Presione *Enter*, para continuar.");
        scanner.nextLine();

    }
}
