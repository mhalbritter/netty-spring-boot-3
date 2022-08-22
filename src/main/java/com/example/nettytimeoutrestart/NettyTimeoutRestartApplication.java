package com.example.nettytimeoutrestart;

import com.example.nettytimeoutrestart.NettyTimeoutRestartApplication.Hints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.context.aot.BindingReflectionHintsRegistrar;

@SpringBootApplication
@ImportRuntimeHints(Hints.class)
public class NettyTimeoutRestartApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(NettyTimeoutRestartApplication.class).bannerMode(Banner.Mode.OFF).web(WebApplicationType.NONE).run(args);
	}

	@Bean
	ApplicationRunner onInit(ApiAccessor accessor) {
		return args -> System.out.println(accessor.access().block());
	}

	static class Hints implements RuntimeHintsRegistrar {
		private final BindingReflectionHintsRegistrar reflectionHintsRegistrar = new BindingReflectionHintsRegistrar();

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			reflectionHintsRegistrar.registerReflectionHints(hints.reflection(), Headers.class, GetResponse.class);
		}
	}
}
