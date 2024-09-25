package com.stretcher.service;


import com.stretcher.bean.PriceInformation;
import org.springframework.stereotype.Service;

@Service
public class StretcherService {

    public PriceInformation getPriceInformation(String type, double width, double height) {
        PriceInformation priceInformation = new PriceInformation();

        return switch (type) {
            case "BAS_5" -> getBAS_5PriceInformation(width, height);
            case "BAS_6_2T" -> getBAS_6_2TPriceInformation(width, height);
            case "BAS_6C" -> getBAS_6CPriceInformation(width, height);
            case "BAS_6T" -> getBAS_6TPriceInformation(width, height);
            default -> priceInformation;
        };


    }


    private PriceInformation getBAS_5PriceInformation(double width, double height){
        double subTotalCalculation = (width + height) * 0.68;
        double ivaCalculation = subTotalCalculation * 0.21;

        return PriceInformation.builder().
                subtotal(roundUp(subTotalCalculation)).
                total(roundUp(subTotalCalculation + ivaCalculation)).
                iva(roundUp(ivaCalculation)).build();
    }

    private PriceInformation getBAS_6_2TPriceInformation(double width, double height){
        double subTotalCalculation;
        if (width<height)   {
            subTotalCalculation = (width + height) * 0.74 + width * 0.74 ;
        }
        else    {
            subTotalCalculation = (width + height) * 0.74 + height * 0.74;
        }
        double ivaCalculation = subTotalCalculation * 0.21;

        return PriceInformation.builder().
                subtotal(roundUp(subTotalCalculation)).
                total(roundUp(subTotalCalculation + ivaCalculation)).
                iva(roundUp(ivaCalculation)).build();
    }

    private PriceInformation getBAS_6CPriceInformation(double width, double height){
        double subTotalCalculation = (width + height) * 1.11;
        double ivaCalculation = subTotalCalculation * 0.21;

        return PriceInformation.builder().
                subtotal(roundUp(subTotalCalculation)).
                total(roundUp(subTotalCalculation + ivaCalculation)).
                iva(roundUp(ivaCalculation)).build();
    }

    private PriceInformation getBAS_6TPriceInformation(double width, double height){
        double subTotalCalculation;
        if (width<height)   {
            subTotalCalculation = (width + height) * 0.74 + width * 0.37 ;
        }
        else    {
            subTotalCalculation = (width + height) * 0.74 + height * 0.37;
        }
        double ivaCalculation = subTotalCalculation * 0.21;

        return PriceInformation.builder().
                subtotal(roundUp(subTotalCalculation)).
                total(roundUp(subTotalCalculation + ivaCalculation)).
                iva(roundUp(ivaCalculation)).build();
    }


    private static double roundUp(double value) {
        return Math.ceil(value * 100) / 100;
    }


}
