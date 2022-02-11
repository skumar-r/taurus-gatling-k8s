package com.rsk.gatling.test

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt

class GoogleTestSimulation extends Simulation {
	val protocol: HttpProtocolBuilder = http.baseUrl("https://ssl.gstatic.com/")
	val scn: ScenarioBuilder = scenario("Load testing of Google")
		.exec(
			http("Sample test of Google.com")
				.get("gb/images/a/ea554714e7.png")
				.check(status.is(200))
		)

	//2,4,6,8,10
	setUp(scn.inject(
		incrementConcurrentUsers(2)
			.times(5)
			.eachLevelLasting(2.seconds)
			.separatedByRampsLasting(2.seconds)
			.startingFrom(2)
	)
		.protocols(protocol))
		.maxDuration(1800)
		.assertions(global.responseTime.max.lt(20000), global.successfulRequests.percent.gt(95))
}