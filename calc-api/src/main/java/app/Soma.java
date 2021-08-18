package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma {
    @Path("/soma/{a}/{b}")
    @GET
    public String sum(@PathParam String a, @PathParam String b) {
        try {
            double sum = Double.parseDouble(a) + Double.parseDouble(b);

            return String.format("%.2f", sum);
        } catch (NumberFormatException nfe) {

            if(isInvalid(a) && isInvalid(b) == false){
                throw new BadRequestException(String.format("Parâmetro inválido: %s", a));
            } else if(isInvalid(a) == false && isInvalid(b)){
                throw new BadRequestException(String.format("Parâmetro inválido: %s", b));
            } 

            throw new BadRequestException(String.format("Parâmetros inválidos: %s e %s.", a, b));
        }
    }

    private Boolean isInvalid(String x){
        try{
            Double.parseDouble(x);
            return false;
        }catch(NumberFormatException nfe){
            return true;
        }
    }
}
