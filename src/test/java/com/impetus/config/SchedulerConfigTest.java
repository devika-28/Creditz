package com.impetus.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class SchedulerConfigTest {

	private SchedulerConfig createTestSubject() {
		return new SchedulerConfig();
	}

	@Test
	public void testConfigureTasks() throws Exception {
		SchedulerConfig testSubject;
		ScheduledTaskRegistrar scheduledTaskRegistrar = new ScheduledTaskRegistrar();

		// default test
		testSubject = createTestSubject();
		testSubject.configureTasks(scheduledTaskRegistrar);
	}
}