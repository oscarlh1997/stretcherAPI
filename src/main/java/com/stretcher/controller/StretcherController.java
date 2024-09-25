package com.stretcher.controller;


import com.stretcher.bean.PriceInformation;
import com.stretcher.service.StretcherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stretcher")
public class StretcherController {


	private final StretcherService stretcherService;

	public StretcherController(StretcherService stretcherService) {
		this.stretcherService = stretcherService;
	}

	@Operation(summary = "Gets price by type and size", description = "Retrieves price by type and size",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved price",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
					@ApiResponse(responseCode = "404", description = "Error retrieving prices")
			})
	@GetMapping("/{stretcherType}")
	public PriceInformation getUserById(

			@Parameter(description = "stretcherType", required = true,
					schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"BAS_5", "BAS_6_2T", "BAS_6C", "BAS_6T"}))
			@PathVariable String stretcherType,
			@Parameter(description = "ancho", required = true)  double width,
			@Parameter(description = "alto", required = true) double height) {

        return stretcherService.getPriceInformation(stretcherType,width,height);
	}

}
