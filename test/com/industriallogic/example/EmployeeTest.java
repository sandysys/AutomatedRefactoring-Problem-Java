/// ***************************************************************************
/// Copyright (c) 2009, Industrial Logic, Inc., All Rights Reserved.
///
/// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
/// used by students during Industrial Logic's workshops or by individuals
/// who are being coached by Industrial Logic on a project.
///
/// This code may NOT be copied or used for any other purpose without the prior
/// written consent of Industrial Logic, Inc.
/// ****************************************************************************

package com.industriallogic.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
	@Test
	public void noJobsPerformed() {
		Employee deadBeat = new Employee(Employee.MANAGER_JOBS);
		assertEquals(0, deadBeat.jobsCompletedCount());
		assertEquals(0, deadBeat.jobsSkippedCount());
	}
	
	@Test
	public void threeJobsPerformedNoneSkippedByManager() {
        Employee productiveManager = new Employee(Employee.MANAGER_JOBS);
		productiveManager.performJob(Job.MANAGE);
		productiveManager.performJob(Job.MARKET);
		productiveManager.performJob(Job.SELL);
		assertEquals(3, productiveManager.jobsCompletedCount());
		assertEquals(0, productiveManager.jobsSkippedCount());
	}
	
	@Test
	public void oneJobDoneOneJobSkippedByManager() {
		Employee unbusyManager = new Employee(Employee.MANAGER_JOBS);
		unbusyManager.performJob(Job.TEST);
		unbusyManager.performJob(Job.SELL);
		assertEquals(1, unbusyManager.jobsCompletedCount());
		assertEquals(1, unbusyManager.jobsSkippedCount());
	}
	
	@Test
	public void noJobsDone() {
		Employee deadBeat = new Employee(Employee.PROGRAMMER_JOBS);
		assertEquals(0, deadBeat.jobsCompletedCount());
		assertEquals(0, deadBeat.jobsSkippedCount());
	}
	
	@Test
	public void threeJobsPerformedNoneSkippedByProgrammer() {
		Employee productiveProgrammer = new Employee(Employee.PROGRAMMER_JOBS);
		productiveProgrammer.performJob(Job.TEST);
		productiveProgrammer.performJob(Job.PROGRAM);
		productiveProgrammer.performJob(Job.INTEGRATE);
		assertEquals(3, productiveProgrammer.jobsCompletedCount());
		assertEquals(0, productiveProgrammer.jobsSkippedCount());
	}
	
	@Test
	public void oneJobDoneOneJobSkippedByProgrammer() {
		Employee unbusyProgrammer = new Employee(Employee.PROGRAMMER_JOBS);
		unbusyProgrammer.performJob(Job.TEST);
		unbusyProgrammer.performJob(Job.SELL);
		assertEquals(1, unbusyProgrammer.jobsCompletedCount());
		assertEquals(1, unbusyProgrammer.jobsSkippedCount());
	}	
}
