package com.mj.espressouitestexample

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieActivityTest::class,
    SecondaryActivityTest::class
)
class ActivityTestSuite