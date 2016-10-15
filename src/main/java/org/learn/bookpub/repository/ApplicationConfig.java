
package org.learn.bookpub.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@Import(InfrastructureConfig.class)
@EnableJpaRepositories
public class ApplicationConfig {

}
