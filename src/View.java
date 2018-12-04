import java.util.Scanner;

public class View{

	public Original printSelfSelect(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("誰を選びますか");
			System.out.println("平野店長 : 1");
			System.out.println("野獣先輩 : 2");
			System.out.println("葛　　城 : 3");

            	String inpSelf = scanner.nextLine();
            	switch (inpSelf) {
                	case "1":
                		return new HiranoTentyo();
                	case "2":
                		return new Yajuu();
                	case "3":
                		return new Kasturagi();
                	default:
                		System.out.println("分かる？適切な数字を突っ込めって言ってんの！！");
            }
        }
    }

	public Original printTargetSelect(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("対戦相手を選ぼう（提案）");
			System.out.println("平野店長 : 1");
			System.out.println("野獣先輩 : 2");
			System.out.println("葛　　城 : 3");

            	String inpEne = scanner.nextLine();
            	switch (inpEne) {
                	case "1":
                		return new HiranoTentyo();
                	case "2":
                		return new Yajuu();
                	case "3":
                		return new Kasturagi();
                	default:
                		System.out.println("分かる？適切な数字を突っ込めって言ってんの！！");
            }
        }
    }



    public void ozisanKakusei(Original you, Original target){
        if(you.name == "虐待おじさん" && you.hp <= 250 && you.kakuseiFlg == false){
            you.at *= 2;
            you.kakuseiFlg = true;
            System.out.println("おじさんのこと本気で怒らせちゃったね！");
            System.out.println("おじさんは覚醒した！");
        }
        if (target.name == "虐待おじさん" && target.hp <= 250 && target.kakuseiFlg == false){
            target.at *= 2;
            target.kakuseiFlg = true;
            System.out.println("おじさんのこと本気で怒らせちゃったね！");
            System.out.println("おじさんは覚醒した！");
        }
    }

    public int printCommandSelect(Original you, Original target){
    	Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
        System.out.println("　       HP   MP    AT  DE");
        //ここの表記は実際に実行してから調整していこうと思う
        System.out.println(you.name + "  " +  you.hp + "  " + you.mp + "  " + you.at + "  " + you.de);
        //自分の状態異常を表示する関数
        you.status();
        System.out.println(target.name + "  " +  target.hp + "  " + target.mp + "  " + target.at + "  " + target.de);
        target.status();
        System.out.print("1 : 攻撃\n2 : チャージ\n3 : 回復\n4 : 特殊攻撃\n");
        if(you.name == "野獣先輩"){
            System.out.println("5: 毒技");
        }
        if(you.name == "平野店長"){
            System.out.print("5 : ガチビンタ\n6 : リフレクション");
        }
        int inp = scanner.nextInt();
        System.out.println("---------------------------------------------");
        return inp;
    }

    public void printWin(Original target){
        System.out.println(target.ziseinoku);
        if(target.name == "野獣先輩"){
            printYajuu();
        }
        System.out.println("You Win!!");
    }

    public void printLose(Original you){
        System.out.println(you.ziseinoku);
        if(you.name == "野獣先輩"){
            printYajuu();
        }
        System.out.println("You Lose...");
    }

    public void printYajuu(){
        System.out.println("　　　　　　　　　　　　　 ,,,z=~’ﾞ’+”ｯ彡ｯ,､");
        System.out.println("　　　　　　　　　　　　,ｨ´ 　　　　　 “‘:’;:;ｯ;,");
        System.out.println("　　　　　　　　 ,　’ ﾞ´`ﾞﾐﾞｯ,　　　　　　　 “‘,`,");
        System.out.println("　　　　　　 ,／ 　　　 `､ﾞミ　　　　　　　　 ﾞ:;:,");
        System.out.println("　　　　　 /　　　　　 _ =ヾ､ﾞｼｼ=;,z,、　　　 ﾞ;ｼ::ﾐ");
        System.out.println("　　　　 /　　　　 ,ｒ,´　　 /　´`ヽ ゛ﾞ`　 　　,ﾞ彡:ﾐ");
        System.out.println("　　　 / 　　　, ‘-､_`ヽ_/,　　　　　　　 　 ﾐ;::彡;");
        System.out.println("　　 ,’　　　,ｼ´｀｀ ヽ`i｀!　　　　　　　　 ,,彡;::ｼ:彡　");
        System.out.println("　　;i　　､（´ ￣`ヽ / ‘　　　　　　　　シ:ｼ;:ﾐ::ｼ”");
        System.out.println("　ノ:!､　 ヽ｀`ｰ =;ｨ’　　　　　　　　,,ｼ:;彡;ｼﾞ");
        System.out.println("´:::::.ヾ. 　　　￣´　　　　　　　　’ `,ｼﾐﾞ");
        System.out.println(":::::::::::::.`:ヽ､_　　　　　　　…:;’＿,ソ’ﾞ”");
        System.out.println("::::::::::::::::｀::::::::::-=””／");
    }
}

