package unq.api.controller;

import org.unq.ui.model.TwitterSystem;
import org.unq.ui.model.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;

public class UserController extends Controller {
	ObjectMapper mapper;
	
	public UserController() {   
		this.mapper = new ObjectMapper();
	}
	
	public Context getUser(Context ctx, TwitterSystem system) {
		String id = ctx.pathParam("id");
		return ctx.result("obteniendo usuario "+id);
	}

	public Context register(Context ctx, TwitterSystem system) {
		String params = ctx.body();
		try {
			JsonNode node = mapper.readTree(params);
			String name = node.get("name").asText();
			String email = node.get("email").asText();
			String password = node.get("password").asText();
			String image = node.get("image").asText();
			system.register(name, email, password, image);
			return this.resultOk(ctx);
		} catch (JsonProcessingException e) {
			return ctx.result("error");
		}
		
	}

	
}
