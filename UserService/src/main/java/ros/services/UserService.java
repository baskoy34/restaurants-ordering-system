package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.UserDto;
import ros.models.User;
import ros.repositorys.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IGenericService<UserDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            return modelMapper.map(user,UserDto.class);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            user.setActive(false);
            userRepository.save(user);
        }else{
            //-------------
        }
    }

    @Override
    public UserDto Update(UserDto entity) {
        User user = modelMapper.map(entity,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> findAll(Long id) {
        return null;
    }

    public List<UserDto> findAllUserStore(long storeId) {
        List<User> users = userRepository.findByStore(storeId);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users){
            userDtos.add(modelMapper.map(user,UserDto.class));
        }
        return userDtos;
    }

    public List<UserDto> findAllUserCompany(long companyId) {
        List<User> users = userRepository.findByStoreCompany(companyId);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users){
            userDtos.add(modelMapper.map(user,UserDto.class));
        }
        return userDtos;
    }

    @Override
    public UserDto Add(UserDto entity) {
        User user = modelMapper.map(entity,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserDto.class);
    }

}
