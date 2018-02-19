package ThoughtWorks.Constants;

public class ClockUtil {

	public static int addTime(int currentTime, int duration) {

		int result = 0;
		int curHour 	= currentTime / 100;
		int curMinutes 	= currentTime % 100;
//		int talkDurationHour = duration / 100;
		int talkDurationMinues = duration % 100;
		
		int resultMinutes = curMinutes + talkDurationMinues;
		int additionalhour = resultMinutes / 60;
		
		int resultMin = resultMinutes % 60;
		int resultHour = curHour + additionalhour;
		result = (resultHour * 100) + resultMin;
		return result;
	}
}
