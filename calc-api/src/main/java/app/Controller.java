package app;

import io.jooby.annotations.*;

@Path("/")
public class Controller {

  @GET
  public String welcome() {
    return "Welcome to Calculator API!";
  }
}
