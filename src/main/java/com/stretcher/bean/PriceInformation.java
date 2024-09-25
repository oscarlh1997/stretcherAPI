package com.stretcher.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PriceInformation {

    @Schema(description = "the subtotal", defaultValue = "0,00")
    private double subtotal;

    @Schema(description = "the iva", defaultValue = "0,00")
    private double iva;

    @Schema(description = "the total", defaultValue = "0,00")
    private double total;

}
