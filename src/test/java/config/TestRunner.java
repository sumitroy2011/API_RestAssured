package config;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"stepdefs"},
		features = {"src/test/features"},
		tags =  {"@complete"},
		plugin = { "pretty" },
		monochrome = true
		)
public class TestRunner {}