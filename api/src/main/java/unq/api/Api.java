package unq.api;

import org.unq.ui.model.TwitterSystem;

import io.javalin.Javalin;
import unq.api.controller.UserController;

public final class Api {
	TwitterSystem system;
	Javalin app;
	UserController users;

	public Api() {
		this.system = new TwitterSystem();
		this.users = new UserController();
	}

	public void run(int port) {
		this.app = Javalin.create().start(port);
		this.app.get("/", ctx -> ctx.result("Hello World"));
		this.app.get("/user/:id", ctx -> this.users.getUser(ctx, this.system));
		this.app.post("/register/", ctx -> this.users.register(ctx, this.system));
	}

}
