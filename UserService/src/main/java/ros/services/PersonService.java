package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.PersonDto;
import ros.models.Person;
import ros.repositorys.PersonRepository;

import java.util.List;

@Service
public class PersonService implements IGenericService<PersonDto>{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id).get();
        if(person != null)
            return modelMapper.map(person,PersonDto.class);
        else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        //User Active Close To Delete
    }

    @Override
    public PersonDto Update(PersonDto entity) {
        Person person = modelMapper.map(entity,Person.class);
        person = personRepository.save(person);
        return modelMapper.map(person,PersonDto.class);
    }

    @Override
    public List<PersonDto> findAll(Long id) {
        // User List
        return null;
    }

    @Override
    public PersonDto Add(PersonDto entity){
        Person person = modelMapper.map(entity, Person.class);
        person = personRepository.save(person);
        return modelMapper.map(person,PersonDto.class);
    }
}
