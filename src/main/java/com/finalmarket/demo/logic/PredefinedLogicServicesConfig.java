package com.finalmarket.demo.logic;

import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PredefinedLogicServicesConfig {
    @Bean
    PredefinedLogicService antiFraud() {
        return new PredefinedLogicService() {
            @Override
            public void execute(@NotNull PredefinedLogic predefinedLogic) {
                // logic
            }

            @Override
            public boolean isApplicable(@NotNull PredefinedLogic predefinedLogic) {
                return predefinedLogic == PredefinedLogic.RUN_ANTI_FRAUD;
            }
        };
    }

    @Bean
    PredefinedLogicService removeOldTx() {
        return new PredefinedLogicService() {
            @Override
            public void execute(@NotNull PredefinedLogic predefinedLogic) {
                // logic
            }

            @Override
            public boolean isApplicable(@NotNull PredefinedLogic predefinedLogic) {
                return predefinedLogic == PredefinedLogic.REMOVE_OUTDATED_ORDERS;
            }
        };
    }
}
