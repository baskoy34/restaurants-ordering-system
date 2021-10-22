package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.DeskDto;
import ros.helpers.AuciliaryFunctions;
import ros.models.Desk;
import ros.repositorys.DeskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeskService implements IGenericService<DeskDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuciliaryFunctions auciliaryFunctions;

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public DeskDto findById(Long id) {
        Desk desk = deskRepository.findById(id).get();
        if (desk != null)
            return modelMapper.map(desk,DeskDto.class);
        else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        Desk desk = deskRepository.findById(id).get();
        if (desk != null){
            desk.setActive(false);
            deskRepository.save(desk);
        }
        else{
            // close
        }
    }

    @Override
    public DeskDto Update(DeskDto entity) {
        Desk desk = modelMapper.map(entity,Desk.class);
        desk = deskRepository.save(desk);
        return modelMapper.map(desk,DeskDto.class);
    }

    @Override
    public List<DeskDto> findAll(Long id) {
        List<Desk> desks = deskRepository.findAllByStore(id);
        List<DeskDto> deskDtos = new ArrayList<DeskDto>();

        for (Desk desk:desks) {
            deskDtos.add(modelMapper.map(desk,DeskDto.class));
        }
        return deskDtos;
    }

    @Override
    public DeskDto Add(DeskDto entity) throws Exception {
        entity.setQrCode(auciliaryFunctions.generateQRCodeImageString("aadidas")); // Change
        Desk desk = modelMapper.map(entity,Desk.class);
        desk = deskRepository.save(desk);
        return modelMapper.map(desk,DeskDto.class);
    }


}