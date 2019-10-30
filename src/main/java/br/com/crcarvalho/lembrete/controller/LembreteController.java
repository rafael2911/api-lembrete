package br.com.crcarvalho.lembrete.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crcarvalho.lembrete.controller.exception.LembreteNaoEncontradoException;
import br.com.crcarvalho.lembrete.entity.Lembrete;
import br.com.crcarvalho.lembrete.repository.LembreteRepository;

@RestController
@RequestMapping("lembretes")
@CrossOrigin
public class LembreteController {
	
	@Autowired
	private LembreteRepository lembreteRepository;
	
	@GetMapping
	public List<Lembrete> findAll(){
		return lembreteRepository.findAll();
	}
	
	@PostMapping
	public Lembrete toSave(@RequestBody Lembrete lembrete) {
		return lembreteRepository.save(lembrete);
	}
	
	@GetMapping("{id}")
	public Lembrete findById(@PathVariable("id") Long id) {
		return lembreteRepository.findById(id).orElseThrow(
				() -> new LembreteNaoEncontradoException("Lembrete não encontrado.")
			);
	}
	
	@DeleteMapping("{id}")
	public Lembrete toRemove(@PathVariable("id") Long id){
		Lembrete lembrete = lembreteRepository.findById(id).orElseThrow(
				() -> new LembreteNaoEncontradoException("Lembrete não encontrado.")
			);
		
		lembreteRepository.delete(lembrete);
		
		return lembrete;
	}
	
	@PutMapping("{id}")
	@Transactional
	public Lembrete toUpdate(@RequestBody Lembrete lembrete, @PathVariable("id") Long id) {
		Lembrete lembreteRegistered = lembreteRepository.findById(id).orElseThrow(
				() -> new LembreteNaoEncontradoException("Lembrete não encontrado.")
			);
		
		lembreteRegistered.setConteudo(lembrete.getConteudo());
		lembreteRegistered.setArquivado(lembrete.isArquivado());
		lembreteRegistered.setPrioridade(lembrete.getPrioridade());
		lembreteRegistered.setModificado(LocalDateTime.now());
		
		return lembreteRegistered;
	}
	
}
