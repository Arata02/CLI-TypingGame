package Game;

import java.util.Random;

public class Equip {

	//アイテムの変数
	private static int item = 0;
	private static boolean existanceOfItem;
	//武器の変数
	private static int weapon = 0;
	private static boolean existanceOfWeapon;

	//アイテムの取得
	public static void setItem() {
		int num = new Random().nextInt(3);
		if(num == 0) {
			item += 10;
			System.out.println("");
			System.out.println("謎の石を手に入れた!");
		}else if(num == 1) {
			item += 20;
			System.out.println("");
			System.out.println("謎のドリンクを手に入れた!");
		}else if(num == 2) {
			item += 30;
			System.out.println("");
			System.out.println("辞書を手に入れた!");
		}
		existanceOfItem = true;
	}

	public static int getItem() {
		return item;
	}

	//アイテムの使用
	public static int useItem() {
		int effect = item;
		item = 0;
		existanceOfItem = false;
		return effect;
	}

	//アイテムを所持しているか
	public static boolean haveItem() {
		return existanceOfItem;
	}

	//アイテムの初期化
	public static void initItem() {
		existanceOfItem = false;
		item = 0;
	}

	//武器の取得
	public static void setWeapon() {
		int num = new Random().nextInt(3);

		if(num == 0) {
			weapon = 30;
			System.out.println("");
			System.out.println("キーボードを手に入れた!");
		}else if(num == 1) {
			weapon = 50;
			System.out.println("");
			System.out.println("ちょっといいキーボードを手に入れた!");
		}else if(num == 2) {
			weapon = 100;
			System.out.println("");
			System.out.println("最高級キーボードを手に入れた!");
		}
		existanceOfWeapon = true;
	}

	//武器の初期化
	public static void initWeapon() {
		existanceOfWeapon = false;
		weapon = 0;
	}

	//武器を所持しているか
	public static boolean haveWeapon() {
		return existanceOfWeapon;
	}

	//武器の使用
	public static int getWeapon() {
		return weapon;
	}
}