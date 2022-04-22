package api.healtieDeneme.healtie.mappers;

import api.healtieDeneme.healtie.entities.concretes.Category;
import api.healtieDeneme.healtie.entities.dtos.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public CategoryDto entityToDto(Category entity){
        CategoryDto dto=new CategoryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<CategoryDto> entityListToDtoList(List<Category> categoryEntity) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryEntity) {
            CategoryDto categoryDto = new CategoryDto(
                    category.getId(),
                    category.getName()
            );
            categoryDtoList.add(categoryDto);


        }
        return categoryDtoList;
    }


    public Category dtoToEntity(CategoryDto dto){
        Category entity=new Category();
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }


}
