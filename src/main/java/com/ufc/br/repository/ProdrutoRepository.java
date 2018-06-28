package com.ufc.br.repository;

import org.springframework.data.repository.CrudRepository;
import com.ufc.br.model.*;

public interface ProdrutoRepository extends CrudRepository<Produto,Long> {
	
	
}
