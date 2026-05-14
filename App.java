public class App {
    public static void main(String[] args) {
        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        Tarea[] tareas = new Tarea[matriz.length];
        Thread[] hilos = new Thread[matriz.length];

        // Creación e inicio de hilos
        for (int i = 0; i < matriz.length; i++) {
            tareas[i] = new Tarea(matriz[i]);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }

        int totalGlobal = 0;

        System.out.println("Iniciando búsqueda concurrente del término: \"Java\"");
        try {
            for (int i = 0; i < hilos.length; i++) {
                hilos[i].join(); // Esperamos a que cada hilo termine
                int parcial = tareas[i].getCount();
                totalGlobal += parcial;
                System.out.printf("Hilo %d finalizado. Encontrados: %d%n", i, parcial);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("Resultado Total: La palabra \"Java\" aparece %d veces%n", totalGlobal);
    }
}