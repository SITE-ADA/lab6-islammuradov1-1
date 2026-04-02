package az.edu.ada.wm2.lab6.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private UUID id;
    private String productName;
    private BigDecimal price;
    private LocalDate expirationDate;
    @Builder.Default
    private LinkedList<String> categoryNames = new LinkedList<>();
}
