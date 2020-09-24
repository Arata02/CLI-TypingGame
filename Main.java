package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
	//key入力用の変数
	public static String str = "";
	public static int select = 0;
	//部屋のループカウント
	public int count = 2;
	//分岐用変数
	public static Random rnd = new Random();
	//難易度
	private int mode;

	//メイン
	public static void main(String[] args) {
		Main story = new Main();
		story.playStory();
	}

	//ゲーム進行
	public void playStory() {
		init();

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$                       $");
		System.out.println("$     Type Dungeon      $");
		System.out.println("$                       $");
		System.out.println("$     Author: Kaiki     $");
		System.out.println("$                       $");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");

		System.out.println("");
		System.out.println("");
		startPage();
		modeSelect();
		prologue();
		stage1a();
		stage1b();
		for(; count <= 3;) {
			stage23();
			count++;
		}
		challenge();
		boss();
	}

	//初期化
	public void init() {
		Score.init();
		this.count = 2;
		this.mode = 0;
		Equip.initItem();
		Equip.initWeapon();
	}

	//Mode設定
	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getMode() {
		return this.mode;
	}

	//スタートページ
	public void startPage() {
		System.out.println("1:ルール表示\n2:ゲームスタート");
		System.out.println("");
		System.out.print("選択してください:");
		try {
			@SuppressWarnings("resource")
			int i = new Scanner(System.in).nextInt();
			if(i == 1) {
				System.out.println("");
				System.out.println("");
				System.out.println("$$$                 ルール                     $$$");
				System.out.println("      画面の表示に従ってプレイしてください");
				System.out.println("     敵とのバトルに負けるとゲームオーバーです");
				System.out.println("        また、途中試練の部屋があります");
				System.out.println("    ここでの挑戦に失敗してもゲームオーバーです");
				System.out.println("             1番奥の部屋まで行き");
				System.out.println("     ボスとの戦いで勝利すればゲームクリアです");
				System.out.println("$$$                                            $$$");
				System.out.println("");
				System.out.println("");
				System.out.println("$$$                 クリア条件                 $$$");
				System.out.println(" 2～3部屋目 Normal: Scoreが100以上かつHPが10以上");
				System.out.println("              Hard: Scoreが300以上かつHPが10以上");
				System.out.println("大きな扉のある部屋: 180秒で250以上のタイプ");
				System.out.println("            Boss戦: Missが30未満かつHPが10以上");
				System.out.println("$$$                                            $$$");
				System.out.println("");
				System.out.println("");
				System.out.println("ゲームスタート!");
				System.out.println("");
			}else if(i == 2) {
				System.out.println("");
				System.out.println("ゲームスタート!");
				System.out.println("");
			}else {
				System.out.println("");
				System.out.println("無効な入力です");
				System.out.println("");
				startPage();
			}
		}catch(Exception e) {
			System.out.println("");
			System.out.println("無効な入力です");
			System.out.println("");
			startPage();
		}
	}


	//難易度選択
	public void modeSelect() {
		System.out.println("難易度を選択してください。");
		System.out.println("1:Normal 2:Hard");
		System.out.println("");
		System.out.print("選択してください:");

		try {
			@SuppressWarnings("resource")
			int i = new Scanner(System.in).nextInt();
			setMode(i);

			if(i == 1) {
				System.out.println("");
				System.out.println("Normalを選択しました");
				Score.setHp(100);
				Score.setCscore(100);
				Score.setBmiss(50);
			}
			else if(i == 2) {
				System.out.println("");
				System.out.println("Hardを選択しました");
				Score.setHp(150);
				Score.setCscore(300);
				Score.setBmiss(30);
			}else {
				System.out.println("");
				System.out.println("無効な入力です");
				modeSelect();
			}
		}
		catch(Exception e) {
			System.out.println("");
			System.out.println("無効な入力です");
			modeSelect();
		}
	}

	//プロローグ
	public static void prologue() {
		int i = 0;
		while( i <= 3) {
			System.out.println("");
			i++;
		}
		System.out.println("ここは自分のタイピング能力が物をいう世界...");
		System.out.println("タイピングで敵を圧倒し、敵を打ち負かせ!");
		i = 0;
		while( i <= 3) {
			System.out.println("");
			i++;
		}
	}

	//ステージ1a
	public void stage1a() {
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("最初の部屋に来ました");
		System.out.println("");
		System.out.println("現在のHP: " + Score.getHp());
		System.out.println("");
		System.out.println("部屋を探索します...");
		int i = rnd.nextInt(100);
		if (i > 50) {
			System.out.println("");
			System.out.println("何もなかった");
			System.out.println("");
		} else {
			//武器ゲット
			int num = new Random().nextInt(2);
			if(num == 0) {
				Equip.setWeapon();
				System.out.println("Scoreが+" + Equip.getWeapon() + "されます");
				System.out.println("");
			}else if(num == 1) {
				iEvent();
			}
		}
	}

	//ステージ1b
	public void stage1b() {
		System.out.println("");
		System.out.println("次の部屋に進みますか?");
		System.out.println("1:はい 2:もう1度探索する");
		System.out.println("");
		System.out.print("選択してください:");
		try {
			@SuppressWarnings("resource")
			int j = new Scanner(System.in).nextInt();
			if(j == 1) {
				System.out.println("");
				System.out.println("次の部屋に進みます");
			}else if(j == 2) {
				System.out.println("");
				System.out.println("この部屋にはもう何もないようだ");
				System.out.println("");
				System.out.println("次の部屋に進みます");
			}else {
				System.out.println("");
				System.out.println("無効な入力です");
				stage1b();
			}
		}catch(Exception e) {
			System.out.println("");
			System.out.println("無効な入力です");
			stage1b();
		}
	}

	//ステージ2,3
	public void stage23() {
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("");
		System.out.println(count +"つ目の部屋に来ました");
		System.out.println("");
		System.out.println("現在のHP: " + Score.getHp());
		System.out.println("");
		System.out.println("どうしますか");
		System.out.println("1:探索する\n2:前の部屋へ戻る");
		System.out.println("");
		System.out.print("選択してください:");
		input_Key();
		switch (select) {
		case 1:
			System.out.println("");
			System.out.println("部屋を探索します...");
			int i = rnd.nextInt(100);
			if (i > 50) {
				System.out.println("");
				System.out.println("敵と遭遇した!");
				System.out.println("");
				System.out.println("////////////////////////");
				System.out.println("////////////////////////");
				System.out.println("////////////////////////");
				System.out.println("////////////////////////");
				System.out.println("////////////////////////");
				System.out.println("");
				battle();
				Score.setTotal();
				Score.setScore(-(Score.getScore()));
				Score.setMiss(-(Score.getMiss()));
				int j = rnd.nextInt(100);
				if(j > 50) {
					System.out.println("");
					System.out.println("敵は何もドロップしなかった...");
				}else {
					iEvent();
				}
			} else {
				iEvent();
			}
			break;
		case 2:
			System.out.println("");
			System.out.println("前の部屋へは戻れないようだ");
			break;
		}

		System.out.println("");
		System.out.println("現在のHP: " + Score.getHp());
		System.out.println("");
		System.out.println("どうしますか");
		System.out.println("1:探索する");
		System.out.println("");
		System.out.print("選択してください:");
		input_Key();
		System.out.println("");
		System.out.println("部屋を探索します...");
		Random rnd = new Random();
		int i = rnd.nextInt(100);
		if (i > 50) {
			System.out.println("");
			System.out.println("何もなかった");
		} else {
			System.out.println("");
			System.out.println("敵と遭遇した!");
			System.out.println("");
			System.out.println("////////////////////////");
			System.out.println("////////////////////////");
			System.out.println("////////////////////////");
			System.out.println("////////////////////////");
			System.out.println("////////////////////////");
			System.out.println("");
			battle();
			Score.setTotal();
			Score.setScore(-(Score.getScore()));
			Score.setMiss(-(Score.getMiss()));
			int j = rnd.nextInt(100);
			if(j > 50) {
				System.out.println("");
				System.out.println("敵は何もドロップしなかった...");
			}else {
				iEvent();
			}
		}
		System.out.println("");
		System.out.println("次の部屋に進みますか?");
		System.out.println("1:はい");
		System.out.println("");
		System.out.print("選択してください:");
		input_Key();
		switch(select) {
		case 1:
			System.out.println("");
			System.out.println("次の部屋に進みます");
			break;

		default:
			System.out.println("");
			System.out.println("この部屋には何もないようだ");
			System.out.println("次の部屋に進みます");
		}
	}

	//ステージ4(ゲーム中の挑戦)
	public void challenge() {
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("4つ目の部屋に来ました");
		System.out.println("");
		System.out.println("大きな扉がある");
		System.out.println("どうやら180秒の間に250以上のタイプをすることで扉が開くようだ");

		SubThread st = new SubThread();

		st.start();
		CountDownTimer.initTime();

		try {
			Thread.sleep(180000);
			//デバック
			//Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		st.stopRunning();
		System.out.println("");
		System.out.println("Time Up!");

		System.out.println("");
		System.out.println("Total Number of Inputs: " + Score.getChallengeScore());
		Score.setMiss(-(Score.getMiss()));

		if(Score.getChallengeScore() >= 250) {
			System.out.println("");
			System.out.println("扉が開いた!");
		}else {
			out();
		}
	}

	//ステージ5(ラスボス)
	public void boss() {
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("現在のHP: " + Score.getHp());
		System.out.println("");
		System.out.println("1番奥の部屋まで来たようだ");
		System.out.println("");
		System.out.println("何かの気配を感じる...");
		System.out.println("");
		System.out.println("Enterを押してください");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		for(int i = 0; i < 3; i++) {
			System.out.print(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("ボスが現れた!\nボスHP: ???");
		System.out.println("");
		timer();
		bBattle();
		if(Equip.haveWeapon()) {
			Score.setScore(Equip.getWeapon());
		}
		if(Equip.haveItem()) {
			Score.setScore(Equip.useItem());
		}
		Score.setTotal();
		if(Score.getMiss() < 30 && Score.getHp() > 0) {
			clear();
		}else {
			out();
		}
	}

	public void input_Key() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = br.readLine();
			select = Integer.parseInt(str);
		} catch (IOException | NumberFormatException e) {
			System.out.println("");
			System.out.println("! 無効な入力です !");
		}
	}

	//戦闘
	public void battle() {
		System.out.println("敵HP: " + Score.getCscore());
		timer();
		System.out.println("");

		if(getMode() == 1) {
			normal();
			result();
		}else if(getMode() == 2){
			hard();
			result();
		}
	}

	//判定
	public void result() {
		System.out.println("");
		System.out.println("Finish!");
		if(Equip.haveWeapon()) {
			Score.setScore(Equip.getWeapon());
		}
		if(Equip.haveItem()) {
			Score.setScore(Equip.useItem());
		}
		System.out.println("Score: " + Score.getScore() + " Miss: " + Score.getMiss() + " HP: " + Score.getHp());

		if(Score.getScore() >= Score.getCscore() && Score.getMiss() < Score.getBmiss() && Score.getHp() > 0) {
			System.out.println("");
			System.out.println("バトルクリア!");
		}else {
			System.out.println("");
			System.out.println("ゲームオーバー");
			System.out.println("タイトルに戻ります");
			playStory();
		}
	}

	//ゲームクリア
	public void clear() {
		System.out.println("");
		System.out.println("ボスを倒した!!!");
		System.out.println("");
		System.out.println("ゲームクリア!!!!!");
		System.out.println("");

		if(Score.getTotal() >= 1000) {
			System.out.println("Clear Rank: S");
		}else if(Score.getTotal() >= 500) {
			System.out.println("Clear Rank: A");
		}else if(Score.getTotal() >= 400) {
			System.out.println("Clear Rank: B");
		}else{
			System.out.println("Clear Rank: C");
		}

		System.out.println("");
		System.out.println("Total Score: " + Score.getTotal());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("タイトルに戻ります");
		System.out.println("");
		System.out.println("Enterを押してください");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		int i = 0;
		while( i < 50) {
			System.out.println("");
			i++;
		}
		playStory();
	}

	//チャレンジ,ラスボス敗北
	public void out() {
		System.out.println("");
		System.out.println("ゲームオーバー\nタイトルに戻ります");
		playStory();
	}

	//カウントダウンタイマ
	public final void timer() {
		try {
			System.out.println("");
			System.out.print("3");
			Thread.sleep(1000);
			System.out.print("2");
			Thread.sleep(1000);
			System.out.print("1");
			Thread.sleep(1000);
			System.out.println("Battle Start!!!");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	//難易度Normalの戦闘
	public void normal() {
		for(int i = 0; i < 20; i++) {
			Word normalWord = new Word(getMode());
			System.out.println("[ " + normalWord.getWord() + " ]");
			System.out.println("");
			System.out.print("->");

			@SuppressWarnings("resource")
			String input = new Scanner(System.in).nextLine();

			//デバック
			//String input = normalWord.getWord();

			if(input.equals(normalWord.getWord())) {
				Score.setScore(10);
				System.out.println("");
				System.out.println("Attack!!!\n");
				System.out.println("");
			}else if(!input.equals(normalWord.getWord())){
				Score.setMiss(10);
				Score.damage();
				System.out.println("");
				System.out.println("Damage!!!\n");
				System.out.println("");
			}
			if(Score.getHp() <= 0) {
				break;
			}
			if(Score.getScore() >= Score.getCscore()) {
				break;
			}
		}
	}

	//難易度Hardの戦闘
	public void hard() {
		for(int i = 0; i < 40; i++) {
			Word hardWord = new Word(getMode());
			System.out.println("[ " + hardWord.getWord() + " ]");
			System.out.println("");
			System.out.print("->");

			@SuppressWarnings("resource")
			String input = new Scanner(System.in).nextLine();

			if(input.equals(hardWord.getWord())) {
				Score.setScore(10);
				System.out.println("");
				System.out.println("Attack!!!\n");
				System.out.println("");
			}else if(!input.equals(hardWord.getWord())){
				Score.setMiss(10);
				Score.damage();
				System.out.println("");
				System.out.println("Damage!!!\n");
				System.out.println("");
			}
			if(Score.getHp() <= 0) {
				break;
			}
			if(Score.getScore() >= Score.getCscore()) {
				break;
			}
		}
	}

	//Boss戦闘
	public void bBattle() {
		for(int i = 0; i < 20; i++) {
			Word bossWord = new Word(4);
			System.out.println("[ " + bossWord.getWord() + " ]");
			System.out.println("");
			System.out.print("->");

			@SuppressWarnings("resource")
			String input = new Scanner(System.in).nextLine();

			//デバック
			//String input = bossWord.getWord();

			if(input.equals(bossWord.getWord())) {
				Score.setScore(10);
				System.out.println("");
				System.out.println("Attack!!!\n");
				System.out.println("");
			}else if(!input.equals(bossWord.getWord())){
				Score.setMiss(10);
				Score.damage();
				System.out.println("");
				System.out.println("Damage!!!\n");
				System.out.println("");
			}
			if(Score.getHp() <= 0) {
				break;
			}
		}

		System.out.println("");
		System.out.println("Finish!");
		if(Equip.haveWeapon()) {
			Score.setScore(Equip.getWeapon());
		}
		if(Equip.haveItem()) {
			Score.setScore(Equip.useItem());
		}
		System.out.println("Score: " + Score.getScore() + " Miss: " + Score.getMiss() + " HP: " + Score.getHp());
	}

	//アイテムイベント
	public void iEvent() {
		Equip.setItem();
		System.out.println("Scoreが" + Equip.getItem() + "Upします");
	}
}

//ゲーム中の挑戦でのカウントダウンタイマの設定
class CountDownTimer{
	private static long startTime;
	public static void initTime(){
		CountDownTimer.startTime = System.currentTimeMillis();
	}
	public static long getTime(){
		long nowTime = System.currentTimeMillis();
		return 180-(nowTime - CountDownTimer.startTime) / 1000;
	}
}

//サブスレッドによる同時処理
class SubThread extends Thread {
	private boolean running = true;
	private boolean inputAllow = true;

	public void start() {
		new Thread(this).start();
	}

	public void stopRunning() {
		this.running = false;
		this.inputAllow = false;
	}

	public void run() {
		timer();
		cBattle();
	}

	//カウントダウンタイマ
	public final void timer() {
		try {
			System.out.println("");
			System.out.print("3");
			Thread.sleep(1000);
			System.out.print("2");
			Thread.sleep(1000);
			System.out.print("1");
			Thread.sleep(1000);
			System.out.println("Battle Start!!!");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Challengeの戦闘
	public void cBattle() {
		while(this.running) {
			this.inputAllow = true;
			Word challengeWord = new Word(3);
			System.out.println("[ " + challengeWord.getWord() + " ]" );
			System.out.println("");
			System.out.print("->");

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = "";

				while(inputAllow) {
					if(br.ready()) {
						input = br.readLine();
						this.inputAllow = false;
					}
				}
				sleep(1);

				if(input.equals(challengeWord.getWord())) {
					Score.addChallengeScore(challengeWord.getWord().length());
				}

				if(this.running) {
					if(input.equals(challengeWord.getWord())) {
						System.out.println("");
						System.out.println("Great!!!\n");
						System.out.println("");
					}else {
						System.out.println("");
						System.out.println("Miss!!!\n");
						System.out.println("");
					}
					System.out.println("残り: " + CountDownTimer.getTime() + "秒");
					System.out.println("");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}