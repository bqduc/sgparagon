package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.TaxGroup;
import net.brilliant.framework.repository.NameRepository;

@Repository
public interface TaxGroupRepository extends NameRepository<TaxGroup, Long>{
}
