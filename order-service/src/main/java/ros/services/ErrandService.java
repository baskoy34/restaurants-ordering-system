package ros.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ros.dtos.ErrandDto;

public interface ErrandService {
    Page<ErrandDto> getPagination(Pageable pageable);
    ErrandDto save(ErrandDto errandDto);
    ErrandDto update(Long id, ErrandDto ticketDto);
    ErrandDto getById(Long id);
    void deleteErrand(long id);
}
