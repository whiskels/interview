package com.finalmarket.demo.logic;


import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MainService implements PredefinedLogicService {
    private final List<PredefinedLogicService> services;

    @Value("${com.finalmarket.logic.scheduled.values:RUN_ANTI_FRAUD}")
    private Set<PredefinedLogic> scheduledLogic;

    @Scheduled(cron = "${com.finalmarket.logic.scheduled.cron:*/1 * * * * *}")
    private void runScheduledTransactions() {
        scheduledLogic.forEach(this::executeInTransaction);
    }

    @Override
    public void execute(@NotNull PredefinedLogic predefinedLogic) {
        executeInTransaction(predefinedLogic);
    }

    @Transactional
    private void executeInTransaction(PredefinedLogic predefinedLogic) {
        for (PredefinedLogicService service : services) {
            if (service.isApplicable(predefinedLogic)) {
                service.execute(predefinedLogic);
                break;
            }
        }
        throw new IllegalArgumentException("No service found for logic: " + predefinedLogic);
    }

    @Override
    public boolean isApplicable(@NotNull PredefinedLogic predefinedLogic) {
        return true;
    }
}
