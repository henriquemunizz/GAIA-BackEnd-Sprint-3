package br.com.fiap.gaia.controller;

import br.com.fiap.gaia.dao.MissaoDao;
import br.com.fiap.gaia.model.Missao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoDao dao;

    public MissaoController() throws Exception {
        this.dao = new MissaoDao();
    }

    @GetMapping
    public List<Missao> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/{id}")
    public Missao buscarPorId(@PathVariable int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @GetMapping("/dificuldade/{dificuldade}")
    public List<Missao> buscarPorDificuldade(@PathVariable int dificuldade) throws Exception {
        return dao.buscarPorDificuldade(dificuldade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Missao cadastrar(@RequestBody Missao missao) throws Exception {
        dao.cadastrar(missao);
        return missao;
    }

    @PutMapping("/{id}")
    public Missao atualizar(@PathVariable int id, @RequestBody Missao missao) throws Exception {
        missao.setIdMissao(id);
        return dao.atualizar(missao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) throws Exception {
        dao.deletar(id);
    }
}
