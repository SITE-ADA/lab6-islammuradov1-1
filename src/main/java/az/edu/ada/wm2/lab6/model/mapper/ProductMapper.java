package az.edu.ada.wm2.lab6.model.mapper;

import java.util.LinkedList;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import az.edu.ada.wm2.lab6.model.Category;
import az.edu.ada.wm2.lab6.model.Product;
import az.edu.ada.wm2.lab6.model.dto.ProductRequestDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryNames", source = "categories")
    ProductResponseDto toResponseDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Product toEntity(ProductRequestDto dto);

    default LinkedList<String> mapCategoriesToNames(LinkedList<Category> categories) {
        if (categories == null) {
            return new LinkedList<>();
        }
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    default LinkedList<String> mapCategoriesToNames(java.util.Set<Category> categories) {
        if (categories == null) {
            return new LinkedList<>();
        }
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
