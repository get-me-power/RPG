import java.util.Random;
public class Yajuu extends Original{

	public Yajuu(){
		//継承
		super(900, 100, 80, 100, "「いいよ！　こいよ！」", "野獣先輩", "「んああああああああああああああああ！」");
	}

	public void specialAttack(Original target){
		//アイスティー攻撃
		Status suimin = Status.suimin;
		Random random = new Random();
		System.out.println(this.name + "の昏睡攻撃！");
		if(this.mp < 10){
			System.out.println("MPが足りない！（絶望）");
		}else{
			this.mp -= 10;
			int s = random.nextInt(10);
			if(s <= 6 && target.zyotai[suimin.ordinal()] == false){
				target.zyotai[suimin.ordinal()] = true;
				System.out.println("「アイスティーしかなかったけどいいかな？」");
				System.out.println(target.name + "は眠ってしまった！");
			}else{
				System.out.println("しかし失敗した！");
			}
		}
	}

	public void poisonAttack(Original target){
		//汚い攻撃
		Status poison = Status.poison;
		Random random = new Random();
		System.out.println("ブッチッパ！");
		if(this.mp >= 10){
			this.mp -= 10;
			int s = random.nextInt(10);
			if(s <= 7){
				target.zyotai[poison.ordinal()] = true;
				System.out.println(target.name + "は毒を受けた!");
			}else{
				System.out.println("しかし失敗した!");
			}
		}else{
			System.out.println("MPが足りない！（絶望）");
		}
	}
}