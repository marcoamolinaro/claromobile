package br.molinaro.hitss.mobileclaro.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/claro/mobile")
public class MobileResource {
	@GetMapping
	public String listar() {
		return "REST está funcionando!";
	}
}
