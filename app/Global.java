import manager.IntializationManager;
import models.Country;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

import com.google.inject.Inject;

public class Global extends GlobalSettings {
	
	
	@Inject
	private static IntializationManager iniIntializationManager;
	
	public void onStart(Application app) {
		Logger.info("Application has started");
	}
	
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}
}