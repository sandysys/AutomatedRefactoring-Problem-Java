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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    protected EnumSet<Job> jobs;
    protected int jobsCompleted = 0;
    protected int jobsSkipped = 0;

    protected static String MANAGER_JOBS = "managejobs";
    protected static String PROGRAMMER_JOBS = "programmerjobs";
    protected static Map<String, EnumSet<Job>> enumSetMap = new HashMap<String, EnumSet<Job>>();

    static {

        enumSetMap.put(MANAGER_JOBS, EnumSet.of(Job.MANAGE, Job.MARKET, Job.SELL));
        enumSetMap.put(PROGRAMMER_JOBS, EnumSet.of(Job.TEST, Job.PROGRAM, Job.INTEGRATE, Job.DESIGN));
    }


    public Employee(String jobType) {
        this.jobs = enumSetMap.get(jobType);
    }

    public int jobsCompletedCount() {
        return jobsCompleted;
    }

    public int jobsSkippedCount() {
        return jobsSkipped;
    }

    public void performJob(Job job) {
        if (responsibilities().contains(job))
            jobsCompleted++;
        else
            jobsSkipped++;
    }

    private EnumSet<Job> responsibilities() {
        return jobs;
    }
}
