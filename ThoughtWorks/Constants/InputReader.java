package ThoughtWorks.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class InputReader implements Reader{

	@Override
	public List<String> inputReader() {
			String fileName = ConstantFile.getProp("inputfile");
			List<String> inputList = new ArrayList<String>();
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String strLine = null;
				while ((strLine = br.readLine()) != null) {
					inputList.add(strLine);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return inputList;
	}

	@Override
	public List<JSONObject> parse(List<String> input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		List<JSONObject> validTalks = new ArrayList<JSONObject>();
		try {

			int maxTalkTime = Integer.parseInt(ConstantFile.getProp("maxTalkMinutes"));
			int minTalkTime = Integer.parseInt(ConstantFile.getProp("minTalkMinutes"));
//			System.out.println(maxTalkTime);
//			System.out.println(minTalkTime);
			int talktime = 0;
			// Iterate list and validate time.
			for (String talk : input) {
				talk = talk.replaceAll("\\s+", " ").trim();
				Pattern pattern = Pattern.compile("(.*)(\\s){1}([0-2]?[0-9]?[0-9]{1}min|lightning)\\b");
				Matcher matcher = pattern.matcher(talk);
				if (!matcher.matches()) {
					System.out.println("Talk : "+ talk + "not valid");
					continue;
				}

				talktime = calculateTalkTime(matcher.group(3));
				if (talktime <= maxTalkTime && talktime >= minTalkTime) {
					// Add talk to the valid talk List.
					JSONObject job = new JSONObject();
					job.put("title", matcher.group(1));
					job.put("duration", talktime);
					validTalks.add(job);
				} else {
					System.out.println("Talk:[" + talk + "] was ignored. The talk time was out of bounds");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validTalks;
	}
	
	private int calculateTalkTime(String timeString) {
//			System.out.println(timeString);
			String minuteSuffix 	= ConstantFile.getProp("minuteSuffix").trim();
			String lightningSuffix 	= ConstantFile.getProp("lightningSuffix").trim();
//			System.out.println(minuteSuffix);
//			System.out.println(lightningSuffix);
			int talktime = 0;
			try {
				if (timeString.endsWith(minuteSuffix)) {
					talktime = Integer.parseInt(timeString.substring(0, timeString.indexOf(minuteSuffix)));
//					System.out.println(timeString.indexOf(minuteSuffix) + " index "+talktime);
				} else if (timeString.endsWith(lightningSuffix)) {
					talktime = Integer.parseInt(ConstantFile.getProp("lightningMinutes"));
//					System.out.println(talktime);
				}
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			return talktime;
	}
	
}
