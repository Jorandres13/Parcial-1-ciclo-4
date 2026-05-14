public class Tarea implements Runnable {
    private final String[] datos;
    private int count = 0;

    public Tarea(String[] datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        // No hace falta 'synchronized' aquí porque cada hilo
        // tiene su propia instancia de Tarea (no comparten variables).
        for (String lenguaje : datos) {
            if ("Java".equals(lenguaje)) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}