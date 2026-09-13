package br.com.fiap.gaia.controller;

import br.com.fiap.gaia.dao.RecompensaDao;
import br.com.fiap.gaia.model.Recompensa;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {

    private final RecompensaDao dao;

    public RecompensaController() throws Exception {
        this.dao = new RecompensaDao();
    }

    @GetMapping
    public List<Recompensa> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/{id}")
    public Recompensa buscarPorId(@PathVariable int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recompensa cadastrar(@RequestBody Recompensa recompensa) throws Exception {
        dao.cadastrar(recompensa);
        return recompensa;
    }

    @PutMapping("/{id}")
    public Recompensa atualizar(@PathVariable int id, @RequestBody Recompensa recompensa) throws Exception {
        recompensa.setIdRecompensa(id);
        return dao.atualizar(recompensa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) throws Exception {
        dao.deletar(id);
    }
}
