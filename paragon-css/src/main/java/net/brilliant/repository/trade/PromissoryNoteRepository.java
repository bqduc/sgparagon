package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.PromissoryNote;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface PromissoryNoteRepository extends BaseRepository<PromissoryNote, Long>{
}
