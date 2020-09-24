package Game;

public class Score {
	//Total Scoreを初期化
	private static int total = 0;
	//プレイヤーのスコアを初期化
	private static int score = 0;
	//ミスカウント
	private static int miss = 0;
	//クリアスコア
	private static int clearScore;
	//ボーダースコア
	private static int borderScore;
	//ゲーム中の挑戦で入力された文字数カウントの合計
	private static int challengeScore;
	//プレイヤーのHP
	private static int hp = 0;

	//初期化
	public static void init() {
		total = 0;
		score = 0;
		challengeScore = 0;
		hp = 0;
	}

	//HPの設定
	public static void setHp(int hp) {
		Score.hp = hp;
	}

	public static void damage() {
		Score.hp -= 10;
	}

	public static int getHp() {
		return hp;
	}

	//Total Scoreの設定
	public static void setTotal() {
		total += getScore();
	}

	public static int getTotal() {
		return total;
	}

	//Scoreの設定
	public static void setScore(int score) {
		Score.score += score;
	}

	public static int getScore() {
		return score;
	}

	//難易度によるクリアボーダー設定
	public static void setCscore(int clearScore) {
		Score.clearScore = clearScore;
	}

	public static int getCscore() {
		return clearScore;
	}

	public static void setBmiss(int borderScore) {
		Score.borderScore = borderScore;
	}

	public static int getBmiss() {
		return borderScore;
	}

	//Miss設定
	public static void setMiss(int miss ) {
		Score.miss += miss ;
	}

	public static int getMiss() {
		return miss;
	}

	//ゲーム中の挑戦での設定
	public static void addChallengeScore(int wordLength) {
		challengeScore += wordLength;
	}

	public static int getChallengeScore() {
		return challengeScore;
	}
}