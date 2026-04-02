package az.edu.ada.wm2.lab6.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import az.edu.ada.wm2.lab6.model.Category;
import az.edu.ada.wm2.lab6.model.Product;
import az.edu.ada.wm2.lab6.model.dto.ProductRequestDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;
import az.edu.ada.wm2.lab6.repository.CategoryRepository;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Mapping(target = "categories", source = "categoryIds", qualifiedByName = "mapCategoryIdsToCategories")
    @Mapping(target = "id", ignore = true)
    public abstract Product toEntity(ProductRequestDto dto);

    @Mapping(target = "categoryNames", source = "categories", qualifiedByName = "mapCategoriesToCategoryNames")
    public abstract ProductResponseDto toResponseDto(Product product);

    @Named("mapCategoryIdsToCategories")
    protected List<Category> mapCategoryIdsToCategories(List<UUID> categoryIds) {
        if (categoryIds == null) {
            return new ArrayList<>();
        }
        return categoryIds.stream()
                .map(id -> categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found: " + id)))
                .collect(Collectors.toList());
    }

    @Named("mapCategoriesToCategoryNames")
    protected List<String> mapCategoriesToCategoryNames(List<Category> categories) {
        if (categories == null) {
            return new ArrayList<>();
        }
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
}
