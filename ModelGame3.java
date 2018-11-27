
public class ModelGame3 extends Model{
	private int Score=0;
	int questionNum = 0;
	int[] answerKey = {3,1,2};
	static int resetQChoice = 0;
	
	public ModelGame3(int width, int height) {
		super(width, height);
	}
	
	int getScore() {
		return Score;
	}
	public int getQNum() {
		return questionNum;
	}
	
	public void update(int qchoice) {
		if(qchoice != 0) {
			System.out.println("Hello");
			if(answerKey[questionNum]==qchoice) {
				Score += 1;
			}
			questionNum += 1;
			System.out.println(questionNum);
			
		}
	}
}
