public class Tarea implements Runnable{
    private String[] datos;
    private int count;
    private int countFinal;

    public Tarea(String[] datos){
        this.datos = datos;
    }

    @Override
    public synchronized void  run() {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].equals("Java")) {
                count++;
            }
            countFinal = count + countFinal;
        }
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {}

    public String[] getDatos() {
        return datos;
    }
    public void setDatos(String[] datos) {}

    public int getCountFinal() {
        return countFinal;
    }
}