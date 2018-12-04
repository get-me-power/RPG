public class HiranoTentyo extends Original {

	public HiranoTentyo(){
		super(600, 70, 100, 80, "「気合はあるか？」", "平野店長", "「この私が......」");
		//this.refCount = refCount;
	}

    public void specialAttack(Original target){
        //麻痺技 66%の確率で成功
    	Status mahi = Status.mahi;
        int s = new java.util.Random().nextInt(3);
        System.out.println(this.name + "の縛道第一歌・呪！");
        if(this.mp >= 10){
            this.mp -= 10;
            if(s <= 1){
                System.out.println("「無駄だよ」");
                System.out.println(target.name + "は動けなくなった！");
                target.zyotai[mahi.ordinal()] = true;
            }else{
                System.out.println("しかし失敗した！");
            }
        }else{
            System.out.println("MPが足りない!");
        }
    }

	public void gachiBinta(Original target){
		//引数は後で設定します
        int s = new java.util.Random().nextInt(10);
        System.out.println(this.name + "のガチビンタ！");
        if(s <= 8){
            int point = (int) (target.hp * 0.15);
            target.hp -= point;
            System.out.println(target.name + "に" + point + "のダメージ！");
        }else{
            System.out.println("しかし、攻撃が外れた！");
        }

    }

    public void donutsReflection(){
    	System.out.println(this.name + "のドーナッツ・リフレクション！");
    	if(this.mp >= 25){
    		if (!this.reflectFlg){
    			this.reflectFlg = true;
    			this.mp -= 25;
    			this.de *= 2;
    		    System.out.println(this.name + "は神秘のベールに包まれた！");
    		}else if(this.reflectFlg == true) {
    			System.out.println("しかしすでにかかっている！！（池沼）");
    		}
    	}else{
    		System.out.println("MPが足りない！(絶望)");
    	}

    }
}