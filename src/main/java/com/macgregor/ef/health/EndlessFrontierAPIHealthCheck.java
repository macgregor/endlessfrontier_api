package com.macgregor.ef.health;

import com.codahale.metrics.health.HealthCheck;

public class EndlessFrontierAPIHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
