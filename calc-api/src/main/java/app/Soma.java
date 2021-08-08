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
            throw new BadRequestException(String.format("Parâmetro inválido."));
        }
    }
}
