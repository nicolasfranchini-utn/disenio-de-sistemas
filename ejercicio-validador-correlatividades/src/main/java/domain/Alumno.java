package domain;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void aprobar(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public boolean tieneAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}