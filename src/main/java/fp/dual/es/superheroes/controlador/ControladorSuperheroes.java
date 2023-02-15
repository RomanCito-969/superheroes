package fp.dual.es.superheroes.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fp.dual.es.superheroes.persistencia.modelo.Superheroe;
import fp.dual.es.superheroes.servicio.ServicioSuperheroes;
import fp.dual.es.superheroes.servicio.excepciones.SuperheroeException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/superheroes")
public class ControladorSuperheroes {

    private ServicioSuperheroes servicioSuperheroe;

    public ControladorSuperheroes(ServicioSuperheroes servicioSuperheroe) {
        this.servicioSuperheroe = servicioSuperheroe;
    }

    @GetMapping
    public ResponseEntity<List<Superheroe>> getSuperheroes() {
        List<Superheroe> superheroes = servicioSuperheroe.getSuperheroes();
        log.info("Lista de Superheroes.");
        return ResponseEntity.ok(superheroes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> selecionarSuperheroesPorId(@PathVariable Integer id) throws SuperheroeException {
        try {

        } catch (SuperheroeException e) {
            return new ResponseEntity<>(e.getMessage());
        }
    }

    @PostMapping(path = "/insertar")
    public ResponseEntity<Integer> insertarSuperheroe(@RequestBody Superheroe superheroe) throws Exception {
        Integer superheroeInsertado = null;
        try {
            superheroeInsertado = this.servicioSuperheroe.insertarSuperheroe(superheroe);
        } catch (RuntimeException e) {
            log.debug(e.getMessage());
            e.printStackTrace();
        }

        return ResponseEntity.ok(superheroeInsertado);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Integer> actualizarSuperheroe(@RequestBody Superheroe superheroe) throws Exception {
        Integer numActualizados = null;
        try {
            numActualizados = this.servicioSuperheroe.actualizarSuperheroe(superheroe);
        } catch (RuntimeException e) {
            log.debug(e.getMessage());
            e.printStackTrace();
        }

        return ResponseEntity.ok(numActualizados);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public ResponseEntity<Integer> borrarSuperheroe(@PathVariable Integer id) {
        Integer numBorrados = this.servicioSuperheroe.borrarSuperheroe(id);

        return ResponseEntity.ok(numBorrados);
    }
}
