package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma {
    @Path("/soma/{a}/{b}")
    @GET
    public String routeSum(@PathParam String a, @PathParam String b) throws BadRequestException {
        try {
            double sum = soma(a,b);

            return String.format("%.2f", sum);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(iae.getMessage());
        }
    }

    public double soma(String a, String b) throws IllegalArgumentException {
        double sum;
        
        try {
            sum = Double.parseDouble(a) + Double.parseDouble(b);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(String.format("Parâmetros inválidos: %s e %s.", a, b));
        }

        if(isInvalid(a) && isInvalid(b) == false){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", a));
        } else if(isInvalid(a) == false && isInvalid(b)){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", b));
        } 

        return sum;
    }

    private Boolean isInvalid(String number){
        try{
            Double.parseDouble(number);
            return false;
        }catch(IllegalArgumentException  iae){
            return true;
        }
    }
}
