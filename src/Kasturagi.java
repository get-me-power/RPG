import java.util.Random;
public class Kasturagi extends Original {

	//覚醒フラグは虐待おじさんのHPが一定以下になるとき、攻撃力が1.5倍になる
	public Kasturagi(){
		super(700, 120, 20, 80, "「興奮させてくれるねえ！」", "虐待おじさん", "「全く、困ったもんじゃい......」");
		//this.kakuseiFlg = kakuseiFlg;
	}

	public void specialAttack(Original target){
		//引数は後で書きます
		System.out.println("「真ん中こいよ」");
		Random random = new Random();
		int point = 30;
		this.hp -= point;
		int meityuRitu = random.nextInt(10);

		if (meityuRitu <= 1){
			System.out.println(this.name + "の攻撃は外れた！");
		}else{
			this.act(target);
			//引数は後で書きます;
			int s = random.nextInt(3);
			if(s <= 1){
				System.out.println("2回目の攻撃！");
				this.act(target);
			}
		}
		System.out.println("反動で" + point + "のダメージ!");
		//ダメージ表記のために、point変数使いました
	}
}