package proyectosos_2_235666;

public class Tareas {

    int Proceso = 0, tamaño = 0, bloqueMemoria = 0;
    String estado;

    public Tareas() {
    }

    public Tareas(int numero, int tamaño, String estado) {
        this.Proceso = numero;
        this.tamaño = tamaño;
        this.estado = estado;
    }

    public int getBloqueMemoria() {
        return bloqueMemoria;
    }

    public void setBloqueMemoria(int bloqueMemoria) {
        this.bloqueMemoria = bloqueMemoria;
    }

    public int getProceso() {
        return Proceso;
    }

    public void setProceso(int Proceso) {
        this.Proceso = Proceso;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "N. Proceso: " + Proceso + ", Tamaño del Proceso: " + tamaño + ", Estado del proceso : " + estado;
    }

}
