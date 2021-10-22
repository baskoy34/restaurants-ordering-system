package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ros.dtos.CategoryDto;
import ros.helpers.ErrorHandling;
import ros.models.Category;
import ros.repositorys.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements IGenericService<CategoryDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDto findById(Long id) throws ErrorHandling{
        try{
            Category category = categoryRepository.findById(id).get();
            if(category != null)
                return modelMapper.map(category,CategoryDto.class);
            else{
                return null;
            }
        }catch (Exception e){
            throw new ErrorHandling(e.toString(),"CategoryService");
        }
    }

    @Override
    public void deleteById(Long id) throws ErrorHandling {
        try{
            Category category = categoryRepository.findById(id).get();
            if(category != null){
                category.setActive(false);
                categoryRepository.save(category);
            }
            else{
                throw new ErrorHandling("Category ID not found.","CategoryService");
            }
        }catch (Exception e){
            throw new ErrorHandling(e.toString(),"CategoryService");
        }
    }

    @Override
    public CategoryDto Update(CategoryDto entity)throws ErrorHandling {
        try{
            Category category = modelMapper.map(entity,Category.class);
            category = categoryRepository.save(category);
            return modelMapper.map(category,CategoryDto.class);
        }catch (Exception e){
            throw new ErrorHandling(e.toString(),"CategoryService");
        }
    }

    @Override
    public List<CategoryDto> findAll(Long id) throws ErrorHandling{
        try {
            List<Category> categories = categoryRepository.findAllByStore(id);
            List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

            for (Category category:categories) {
                categoryDtos.add(modelMapper.map(category,CategoryDto.class));
            }
            return categoryDtos;
        }catch (Exception e){
            throw new ErrorHandling("Category listing error","CategoryService");
        }
    }

    @Override
    public CategoryDto Add(CategoryDto entity) throws ErrorHandling {
        try{
            Category category = modelMapper.map(entity,Category.class);
            category = categoryRepository.save(category);
            return modelMapper.map(category,CategoryDto.class);
        }catch (Exception e){
            throw new ErrorHandling(e.toString(),"CategoryService");
        }
    }
}
