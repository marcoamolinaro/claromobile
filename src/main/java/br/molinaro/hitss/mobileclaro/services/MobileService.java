package br.molinaro.hitss.mobileclaro.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.molinaro.hitss.mobileclaro.domain.Mobile;
import br.molinaro.hitss.mobileclaro.dto.MobileDTO;
import br.molinaro.hitss.mobileclaro.repositories.MobileRepository;

@Service
public class MobileService {

	@Autowired
	private MobileRepository mobileRepository;
	
	public Iterable<Mobile> findAll() {
		return mobileRepository.findAll();
	}
	
	public Mobile findByCode(UUID code) {
		return mobileRepository.findByCode(code);
	}
	
	public Mobile insert(Mobile mobile) {
		return mobileRepository.save(mobile);
	}
	
	public Mobile fromDTO(MobileDTO mobileDTO) {
		return new Mobile(
				mobileDTO.getCode(),
				mobileDTO.getModel(),
				mobileDTO.getPrice(),
				mobileDTO.getBrand(),
				mobileDTO.getPhoto(),
				mobileDTO.getDate());
	}
}
