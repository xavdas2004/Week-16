package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest{
	/**
	 * 
	 * @return
	 */
	protected String createOrderBody() {
		//@formatter off
		String body =
			   /* "{"
			    + "\"color\":\"EXT_OLIVE_GREEN\","
			    + "\"customer\":\"FOSTER_BUSINGE\","
			    + "\"engine\":\"2_0_HYBRID\","
			    + "\"model\":\"GRAND_CHEROKEE\","
			    + "\"tires\":\"295_MICHELIN\""
			    + "}";
			    */
				"{\n"
				+ "  \"customer\":\"ROTH_GARTH\",\n"
				+ "  \"model\":\"WRANGLER\",\n"
				+ "  \"trim\":\"Rubicon\",\n"
				+ "  \"doors\":4,\n"
				+ "  \"color\":\"EXT_SNAZZBERRY\",\n"
				+ "  \"engine\":\"2_0_TURBO\",\n"
				+ "  \"tire\":\"255_GOODYEAR\",\n"
				+ "  \"options\":[\n"
				+ "    \"DOOR_WARRIOR_MIRROR_MT\",\n"
				+ "    \"EXT_AEV_LIFT\",\n"
				+ "    \"EXT_WARN_WINCH\",\n"
				+ "    \"EXT_WARN_BUMPER_FRONT\",\n"
				+ "    \"EXT_WARN_BUMPER_REAR\",\n"
				+ "    \"EXT_ARB_COMPRESSOR\"\n"
				+ "  ]\n"
				+ "}";	
		//@formatter on
		return body;
}
	
}

