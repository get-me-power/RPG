import java.util.Random;

public class Main{
	public static void main(String[] args){
		int inp;//プレイヤーの標準入力を受け取る
		Random random = new Random();
		View view = new View();
		StatusAction statusAction = new StatusAction();
		Original you = view.printSelfSelect();
		Original target = view.printTargetSelect();

		System.out.println(target.name + "が現れた！");
		int refCount = 0;
		int number = 0;

		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			inp = view.printCommandSelect(you,target);
			inp = statusAction.youStatus(you, inp);
			statusAction.youAction(you, target, inp, refCount);
			//的の行動を乱数で出す
			if(target.name == "野獣先輩"){
				number = random.nextInt(5);
				number++;
			}else if(target.name == "平野店長"){
				number = random.nextInt(6);
				number++;
			}else{
				number = random.nextInt(4);
				number++;
			}
			number = statusAction.eneStatus(number, target);


			//　敵の行動後にhpが0になることもあるので、敵のhpが0かどうかを先に判定
			if(target.hp <= 0){
				view.printWin(target);
				break;
			}

			statusAction.eneAction(you, target, number, refCount);

			if(you.hp <= 0){
				view.printLose(you);
				break;
			}
			//虐待おじさんが覚醒するメソッド呼び出し
			view.ozisanKakusei(you, target);

			refCount += 1;

			System.out.println(refCount + "ターン目");

			if(you.reflectFlg == true && refCount - you.refCount == 3){
				you.reflectFlg = false;
				you.de /= 2;
				System.out.println(you.name + "のリフレクトが消えた！");
			}

			if(target.reflectFlg == true && refCount - target.refCount == 3){
				target.reflectFlg = false;
				target.de /= 2;
				System.out.println(target.name + "（敵）のリフレクトが消えた！");
			}

		}

	}
}