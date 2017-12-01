package com.demo.util;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@SuppressWarnings("deprecation")
public class JSONUtility {
	private static final ObjectMapper writeMapper = new ObjectMapper();
	private static final ObjectMapper readMapper = new ObjectMapper();
	
	public JSONUtility() {
	}
	
	static {
		writeMapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
	}

	public Object getObjectFromJSON(String jsonString, Class<?> className) {
		Object readValue = null;
		try {
			readValue = readMapper.readValue(jsonString, className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readValue;
	}

	/*
	 * This method will convert Java Object to JSON string. The object need to be a simple POJO.
	 */
	public String getJSONFromObject(Object object) {
		String jsonData = null;
		try {
			jsonData = writeMapper.writeValueAsString(object);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonData;
	}

	public static void main(String[] args) {
		// String test = "{\"USER_SELECTIONS\":[{\"q_id\":\"1\",\"ans\":\"1\"},{\"q_id\":\"2\",\"ans\":\"3\"},{\"q_id\":\"3\",\"ans\":\"1\"}]}";
		//TODO: we need it..
		//JSONUtility.getUserSelectionMap(test);
	}

	public JsonNode getRootNodeFromJSON(String jsonString) {
		JsonNode readValue = null;
		try {
			ObjectMapper mapper = new ObjectMapper();

			readValue = mapper.readValue(jsonString, JsonNode.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return readValue;
	}

}
