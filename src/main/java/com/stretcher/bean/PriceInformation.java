package com.stretcher.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;


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
