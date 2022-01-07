package com.revature.app;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.controllers.RequestsController;

public class TRMSApp {


	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> {

			config.enableCorsForAllOrigins();
		}).start();

		app.routes(() -> {
			// localhost:8080/request
			path("/request", () -> {
				post(RequestsController::submitReimbursementRequest);

				path("/{id}", () -> {// /requestor
					get(RequestsController::getRequestsByRequestor);
				});
			});

		});
	}

}
