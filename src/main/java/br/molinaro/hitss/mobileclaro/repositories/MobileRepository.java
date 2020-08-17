package br.molinaro.hitss.mobileclaro.repositories;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.molinaro.hitss.mobileclaro.domain.Mobile;

public interface MobileRepository extends CrudRepository <Mobile, UUID>{
	@Transactional(readOnly = true)
	 @Cacheable("mobiles")
	public Mobile findByCode(UUID code);
}
