package Model;
import java.io.IOException;
import java.util.ArrayList;

import GameObjects.GameObjects;
import GameObjects.Tree;

public class ModelGame3 extends Model{
	private int Score=0;
	int questionNum = 0;
	int[] answerKey = {2,3,2,3,1};
	static int resetQChoice = 0;
	ArrayList<GameObjects> objects = new ArrayList<GameObjects>();
	/**
	 * Model constructor for game 3, used to set proper coordinates based
	 * on the frameWidth and frameHeight of the screen
	 * @param width int, width of screen
	 * @param height int, hieght of screen
	 * @throws IOException
	 */
	public ModelGame3(int width, int height) throws IOException {
		super(width, height);
		tutorial = true;
		objects.add(new Tree((int)(0),(int)(0),(int)(frameWidth/3),(int)(frameWidth/2.5)));
	}
	/**
	 * returns the score of the game
	 * @return Score int, current score of the game
	 */
	public int getScore() {
		return Score;
	}
	/**
	 * returns the question number
	 * @return questionNum int, the question number
	 */
	public int getNum() {
		return questionNum;
	}
	/**
	 * sets the question number
	 * @param i int, new question number
	 */
	public void setNum(int i) {
		this.questionNum = i;
	}
	/**
	 * updates the question and the score of the game
	 * @param qchoice int, answer given for the game
	 */
	public void update(int qchoice) {
		if(qchoice != 0) {
			if(answerKey[questionNum]==qchoice) {
				Score += 10;
			}
			questionNum += 1;
			tutorial = false;
		}
	}
	/**
	 * returns the list of objects
	 * @return objects ArrayList<GameObjects> list of objects 
	 */
	public ArrayList<GameObjects> getObjects() {
		return objects;
	}
}
