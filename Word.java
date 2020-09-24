package Game;

import java.util.Random;

public class Word {

	//出力用変数
	private String output;

	private static final String[] normal =
		{"Chiyoda-ku", "Chuo-ku", "Minato-ku", "Shinjuku-ku", "Bunkyo-ku", "Taito-ku", "Sumida-ku", "Koto-ku", "Shinagawa-ku", "Meguro-ku",
				"Ota-ku", "Setagaya-ku", "Shibuya-ku", "Nakano-ku", "Suginami-ku", "Toshima-ku", "Kita-ku", "Arakawa-ku", "Itabashi-ku", "Nerima-ku",
				"Adachi-ku", "Katsushika-ku", "Edogawa-ku"};

	private static final String[] hard =
		{"Sapporo", "Aomori", "Morioka", "Sendai", "Akita", "Yamagata", "Fukushima", "Mito", "Utsunomiya", "Maebashi",
				"Saitama", "Chiba", "Shinjuku", "Yokohama", "Niigata", "Toyama", "Kanazawa", "Fukui", "Kofu", "Nagano",
				"Gifu", "Shizuoka", "Nagoya", "Tsu", "Otsu", "Kyoto", "Osaka", "Kobe", "Nara", "Wakayama",
				"Tottori", "Matsue", "Okayama", "Hiroshima", "Yamaguchi", "Tokushima", "Takamatsu", "Matsuyama", "Kochi", "Fukuoka",
				"Saga", "Nagasaki", "Kumamoto", "Oita", "Miyazaki", "Kagoshima", "Naha"};

	private static final String[] challenge =
		{"Step out into the dawn", "You pray 'til, you pray 'til the lights come on","And then you feel like you've just been born",
				"Yeah, you come to raise me up", "When I'm beaten and broken up", "And now I'm back in the arms I love",
				"And I think I just died", "I think I just died", "Yeah, I think I just died", "I think I just died",
				"And went to Heaven", "And went to Heaven, whoa", "Beaten and bathed in blood", "I'm hit by, I'm hit by your love and drug",
				"And now you've c-come to raise me up", "And I think I just died", "I think I just died", "Yeah, I think I just died",
				"And went to Heaven", "went to Heaven", "Whoa, and went to Heaven", "It's such a night, such a beautiful night",
				"It's such a view, such a beautiful sight", "I think I just, oh, I think I just died, oh", "And went to Heaven",
				"And went to Heaven", "Oh, yeah, yeah", "We're gonna be birds and fly", "We're gonna set the world alight",
				"We're gonna lose ourselves tonight, whoa", "We're gonna be birds and fly", "We're gonna set the world alight",
				"We're gonna lose ourselves tonight, oh", "In Heaven (Heaven)"};

	private static final String[] boss =
		{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
				"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
				"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

	//引数に乱数をセットし配列をランダムで返す
	public Word(int mode) {
		int num;
		switch(mode){
		case 1: //Normal
			num = new Random().nextInt(getNlength());
			output = getNword(num);
			break;
		case 2: //hard
			num = new Random().nextInt(getHlength());
			output = getHword(num);
			break;
		case 3: //Challenge
			num =new Random().nextInt(getClength());
			output = getCword(num);
			break;
		case 4: //Boss
			num = new Random().nextInt(getBlength());
			output = getBword(num);
			break;
		}
	}

	//配列の値を返す
	public String getWord() {
		return this.output;
	}

	//配列の長さを取得
	public static int getNlength() {
		return normal.length;
	}

	public static int getHlength() {
		return hard.length;
	}

	public static int getClength() {
		return challenge.length;
	}

	public static int getBlength() {
		return boss.length;
	}

	//配列の任意の値を取得
	public static String getNword(int num) {
		return normal[num];
	}

	public static String getHword(int num) {
		return hard[num];
	}

	public static String getCword(int num) {
		return challenge[num];
	}

	public static String getBword(int num) {
		return boss[num];
	}
}