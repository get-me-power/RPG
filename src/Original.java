import java.util.Random;

public abstract class Original{
	//boolean suimin_flg = false;
    //boolean mahi_flg = false;
    //boolean poison_flg = false;
    boolean[] zyotai = {false, false, false};
    int refCount = 0;
    boolean reflectFlg = false;
    boolean kakuseiFlg = false;

    /* キャラクター情報 */
    int hp, at, mp, de;
    String serifu, name, ziseinoku;
    //コンストラクタ
    public Original(int hp, int at, int mp, int de, String serifu, String name, String ziseinoku){
    	this.hp = hp;
    	this.at = at;
    	this.mp = mp;
    	this.de = de;
    	this.serifu = serifu;
    	this.name = name;
    	this.ziseinoku = ziseinoku;
    }

    public void status(){
    	//ステータス表示 異常の時だけ表示
    	String[] statusList = {"睡眠", "麻痺", "毒"};
    	for(int i = 0; i < statusList.length; i++){
    		if(this.zyotai[i]){
    			System.out.println(statusList[i]);
    		}
    	}
    }

    public void act(Original target){
    	Random random = new Random();
    	int s = random.nextInt(10);
    	int point = (random.nextInt(10) + 30) * (1 + (this.at - target.de) / 100);
    	if(s == 0){
    		int point_c = (int)(point * 1.5);
    		target.hp -= point_c;
    		System.out.println(this.serifu);
    		System.out.println("痛恨の一撃！" + target.name + "に" + point_c + "のダメージ!");
    	}else{
    		target.hp -= point;
    		System.out.println(this.name + "の攻撃！" + target.name + "に" + point + "のダメージ！");
    	}
    }

    public void charge(){
    	Random random = new Random();
    	int a_up_point = random.nextInt(5) + 10;
    	this.at += a_up_point;
        System.out.println(this.name + "はチャージした！　攻撃力" + a_up_point + "アップ！");

    }

    public void heal(){
        Random random = new Random();
        System.out.println(this.name + "は回復呪文を唱えた！");
        if(this.mp >= 5){
            this.mp -= 5;
            int rePoint = random.nextInt(30) + 20;
            this.hp += rePoint;
            System.out.println("体力が" + rePoint + "回復した！");
        }else{
            System.out.println("しかしMPが足りない（絶望）");
        }
    }

    public abstract void specialAttack(Original you);
    //下位クラスで実装しなくてはならない(宣言だけ)(抽象クラス）

    public void mahi(){
        Random random = new Random();
        Status mahi = Status.mahi;

        //麻痺になるタイミングを見つける(フラグ変更)
        System.out.println("痺れて何もできない！");
        if(random.nextInt(5) == 0){
            this.zyotai[mahi.ordinal()] = false;
            System.out.println("麻痺が治った！");
        }
    }

    public void suimin(){
        Random random = new Random();
        Status suimin = Status.suimin;
        //睡眠になるタイミングを見つける(フラグ変更)
        int s = random.nextInt(3);
        if(s <= 1){
            System.out.println(this.name + "は眠っている！");
        }else{
            this.zyotai[suimin.ordinal()] = false;
            System.out.println(this.name + "は目を覚ました！");
        }

    }

    public void poison(){
        int point = 15;
        this.hp -= point;
        System.out.println(this.name + "は毒を受けた！" + point + "のダメージ！");
    }
}

