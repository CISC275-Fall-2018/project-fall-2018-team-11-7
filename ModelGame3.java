
public class ModelGame3 extends Model{
	private int Score=0;
	String[][] questions = {{"What do horseshoe crabs like to eat?", "clams","grass","birds"},{"Where do birds like to live?","water","trees", "burrows"}};
	int questionNum = 0;
	
	public ModelGame3(int width, int height) {
		super(width, height);
	}
	
	int getScore() {
		return Score;
	}
	String askQuestion() {
		String q = questions[questionNum][0];
		return q;
	}
	String[] getAnswerChoices() {
		String[] ans = {questions[questionNum][1], questions[questionNum][2],questions[questionNum][3]};
		return ans;
	}
}
