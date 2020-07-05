/**
 * 
 */
package net.brilliant.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.brilliant.global.GlobalConstants;

/**
 * @author bqduc
 *
 */
//@EnableScheduling
@EnableAsync
@EnableCaching
@Configuration
@EnableJpaRepositories(basePackages = { GlobalConstants.QNS_PACKAGE_ORIGIN, GlobalConstants.QNS_PACKAGE, GlobalConstants.QNS_PACKAGE_EX })
@ComponentScan(basePackages = { GlobalConstants.QNS_PACKAGE_ORIGIN, GlobalConstants.QNS_PACKAGE, GlobalConstants.QNS_PACKAGE_EX })
@EntityScan(basePackages = { GlobalConstants.QNS_PACKAGE_ORIGIN, GlobalConstants.QNS_PACKAGE, GlobalConstants.QNS_PACKAGE_EX })
@EnableTransactionManagement
@Import(value = {
		ServletsConfiguration.class, 
		//AuditingConfiguration.class, 
		//SecurityConfiguration.class,
		//QuartzJobSchedulerConfiguration.class 
})
public class BaseConfiguration {
}