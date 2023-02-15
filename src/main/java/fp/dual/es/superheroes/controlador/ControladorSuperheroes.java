package fp.dual.es.superheroes.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> selecionarSuperheroesPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.servicioSuperheroe.seleccionarPorId(id), HttpStatus.OK);
        } catch (SuperheroeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/insertar")
    public ResponseEntity<String> insertarSuperheroe(@RequestBody Superheroe superheroe) {
        try {
            this.servicioSuperheroe.insertarSuperheroe(superheroe);

            return new ResponseEntity<>("Se ha creado el superhéroe "
                    + superheroe.getNameSuper() + "correctamente.",
                    HttpStatus.OK);
        } catch (SuperheroeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<String> actualizarSuperheroe(@RequestBody Superheroe superheroe) throws Exception {
        try {
            this.servicioSuperheroe.actualizarSuperheroe(superheroe);

            return new ResponseEntity<>("El superhéroe "
                    + superheroe.getNameSuper() + " ha sido actualizado correctamente.",
                    HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/borrar/{id}")
    public ResponseEntity<Integer> borrarSuperheroe(@PathVariable Integer id) {
        Integer numBorrados = this.servicioSuperheroe.borrarSuperheroe(id);

        return ResponseEntity.ok(numBorrados);
    }
}
