package help.lixin.samples.controller;

import java.util.List;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import help.lixin.samples.model.Address;
import help.lixin.samples.model.User;

@RestController
public class HelloController implements EnvironmentAware {

	private Environment environment;

	@GetMapping("/test")
	public String hello() {
		User user = Binder.get(environment)
		                  .bind("user", User.class)
		                  .get();
		System.out.println(user);
		
		
		List<Address>  address = Binder.get(environment)
				                       .bind("user.address", Bindable.listOf(Address.class))
				                       .get();
		System.out.println(address);
		
		
		return "Hello World!!!";
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
