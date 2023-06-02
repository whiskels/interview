package com.finalmarket.demo.logic;

import jakarta.validation.constraints.NotNull;

public interface PredefinedLogicService {
    void execute(@NotNull PredefinedLogic predefinedLogic);

    boolean isApplicable(@NotNull PredefinedLogic predefinedLogic);
}
