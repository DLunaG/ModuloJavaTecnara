package dia14.flujoDeDatos;


import java.util.List;

public class GestorDescargas {

    List<Descarga> listaDescargas;
    public static final int TIEMPO_MAX = 5000;

    public GestorDescargas(List<Descarga> listaDescargas){
        this.listaDescargas = listaDescargas;
    }

    public void realizarDescargas(){
        for (Descarga descarga: listaDescargas){
            descarga.start();
        }
        for(Descarga descarga:listaDescargas){
            try {
                descarga.join();
            }catch(InterruptedException ie){
                System.out.println("InterruptedException: " + ie.toString());
            }
        }
    }

    public String resultadosOrdenacionTiempoDeDescarga(){
        ComparadorTiempoDescarga ctd = new ComparadorTiempoDescarga();
        listaDescargas.sort(ctd);
        StringBuilder sb = new StringBuilder("\033[0;1m>Lista de portales ordenado por tiempo de descarga<\n\033[0;0m");
        int posicion = 1;
        for(Descarga descarga: listaDescargas){
            if(descarga.getTiempoDeDescarga() > this.TIEMPO_MAX){
                sb.append("\u001B[31m-TIEMPO RECOMENDADO EXCEDIDO- \u001B[30m ");
            }
            sb.append("Posición ").append(posicion).append(": portal ").append(descarga.getNombrePortal()).append(" con ")
                    .append(descarga.getTiempoDeDescarga()).append(" milisegungos de descarga.\n");
            posicion++;
        }
        return sb.toString();
    }
}
