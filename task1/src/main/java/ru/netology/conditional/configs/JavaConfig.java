package ru.netology.conditional.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.conditional.profile.DevProfile;
import ru.netology.conditional.profile.ProductionProfile;
import ru.netology.conditional.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean(name = "devProfile")
    @ConditionalOnProperty(name = "netology.profile.dev", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean(name = "productionProfile")
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
