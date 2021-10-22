package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.StoreDto;
import ros.models.Company;
import ros.models.Store;
import ros.repositorys.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService implements IGenericService<StoreDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public StoreDto findById(Long id) {
        Store store = storeRepository.findById(id).get();
        if(store != null)
            return modelMapper.map(storeRepository.findById(id).get(), StoreDto.class);
        else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        Store store = storeRepository.findById(id).get();
        if(store != null){
            store.setActive(false);
            storeRepository.save(store);
        }
    }

    @Override
    public StoreDto Update(StoreDto entity) {
        Store store = modelMapper.map(entity,Store.class);
        store = storeRepository.save(store);
        return modelMapper.map(store,StoreDto.class);
    }

    @Override
    public List<StoreDto> findAll(Long id) {
        List<Store> stores = storeRepository.findByCompany(id);
        List<StoreDto> storeDtos = new ArrayList<StoreDto>();
        for (Store store:stores) {
            storeDtos.add(modelMapper.map(store,StoreDto.class));
        }
        return storeDtos;
    }

    @Override
    public StoreDto Add(StoreDto entity) {
        Store store = modelMapper.map(entity, Store.class);
        store = storeRepository.save(store);
        return modelMapper.map(store,StoreDto.class);
    }
}
