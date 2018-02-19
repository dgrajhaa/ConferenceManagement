package ThoughtWorks.Constants;

import java.util.List;

import org.json.JSONObject;

public interface Reader {

	public List<String> inputReader();
	public List<JSONObject> parse(List<String> input);
}
