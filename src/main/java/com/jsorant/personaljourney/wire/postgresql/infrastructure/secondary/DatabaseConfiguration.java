package com.jsorant.personaljourney.wire.postgresql.infrastructure.secondary;

import com.jsorant.personaljourney.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.jsorant.personaljourney" }, enableDefaultTransactions = false)
@ExcludeFromGeneratedCodeCoverage
class DatabaseConfiguration {}
