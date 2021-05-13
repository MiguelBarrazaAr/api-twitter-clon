package unq.api;

import org.unq.ui.model.TwitterSystem;

import io.javalin.Javalin;

public final class Api {
	TwitterSystem system;
	Javalin app; 

	public Api() {
		this.system = new TwitterSystem();
	}

	public void run(int port) {
		this.app = Javalin.create().start(port);
		this.app.get("/", ctx -> ctx.result("Hello World"));
	}

}
