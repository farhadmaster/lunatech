
import com.google.inject.AbstractModule;

public class SimpleModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(Global.class);
	}
}