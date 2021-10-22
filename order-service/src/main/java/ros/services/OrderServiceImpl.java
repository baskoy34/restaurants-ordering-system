package ros.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ros.dtos.ErrandDto;
import ros.mapper.ErrandMapper;
import ros.models.Desk;
import ros.models.Errand;
import ros.repositorys.ErrandRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl {
   private final ErrandRepository errandRepository;
   private final ErrandMapper errandMapper;

   public  ErrandDto postOrder(ErrandDto errandDto){
       Errand errand=errandMapper.dtoToErrand(errandDto);
       Desk desk=new Desk();
       desk.setId(1L);
       errand.setDesk(desk);
       errandRepository.save(errand);
       errandDto.setId(errand.getId());
       return errandDto;
   }

    public List<ErrandDto> getOrders(long deskId) {
        List<Errand> errands= errandRepository.findByDesk_Id(deskId);
        List<ErrandDto> errandDto=errandMapper.errandToDtoList(errands);
        return errandDto;
    }
}
