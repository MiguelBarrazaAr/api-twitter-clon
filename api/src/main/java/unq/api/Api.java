package unq.api;

import io.javalin.Javalin;

public class Api

{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
    }
}
