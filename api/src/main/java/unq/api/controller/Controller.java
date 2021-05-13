package unq.api.controller;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;

public class Controller {
	public Context resultOk(Context ctx) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "ok");
		return ctx.status(201).json(map); 
	}
}
