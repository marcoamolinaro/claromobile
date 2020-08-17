package br.molinaro.hitss.mobileclaro.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.molinaro.hitss.mobileclaro.domain.Mobile;
import br.molinaro.hitss.mobileclaro.dto.MobileDTO;
import br.molinaro.hitss.mobileclaro.services.MobileService;
import br.molinaro.hitss.mobileclaro.util.Util;

@RestController
@RequestMapping(value = "/claro/mobile")
@CrossOrigin
public class MobileResource {

	@Autowired
	private MobileService mobileService;
	
	@GetMapping
	public ResponseEntity<List<MobileDTO>> findAll() {
		List<Mobile> mobiles = (List<Mobile>) mobileService.findAll();
		
		List<MobileDTO> mobilesDTO = 
				mobiles.stream().map(r -> new MobileDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(mobilesDTO);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<MobileDTO> findByCode(@PathVariable String code) {
		UUID uuidCode = UUID.fromString(code);
		Mobile mobile = mobileService.findByCode(uuidCode);
		return ResponseEntity.ok().body(new MobileDTO(mobile));
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody MobileDTO mobileDTO, BindingResult result) {
		UUID Id;
				
		if (mobileDTO.getCode() == null) {
			Id = Util.generateUUID();
			mobileDTO.setCode(Id);
		}

		Mobile mobile = mobileService.fromDTO(mobileDTO);
		
		mobile = mobileService.insert(mobile);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(mobile.getCode()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
