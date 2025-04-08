package domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {

    @Test
    public void testInscripcionAprobada() {
        // Materias
        Materia algoritmos = new Materia("Algoritmos");
        Materia ssl = new Materia("SSL");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);
        paradigmas.agregarCorrelativa(ssl);

        // Alumno que tiene aprobadas las correlativas
        Alumno alumno = new Alumno("Nicolas");
        alumno.aprobar(algoritmos);
        alumno.aprobar(ssl);

        // Inscripción a Paradigmas
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));

        assertTrue(inscripcion.aprobada(), "La inscripción debería ser aprobada");
    }

    @Test
    public void testInscripcionRechazada() {
        // Materias
        Materia algoritmos = new Materia("Algoritmos");
        Materia ssl = new Materia("SSL");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);
        paradigmas.agregarCorrelativa(ssl);

        // Alumno con solo una correlativa aprobada
        Alumno alumno = new Alumno("Nicolas");
        alumno.aprobar(algoritmos); // Falta SSL

        // Inscripción a Paradigmas
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));

        assertFalse(inscripcion.aprobada(), "La inscripción debería ser rechazada por falta de correlativas");
    }
}
