public class StatusAction{

	public int youStatus(Original you, int inp){
		Status suimin = Status.suimin;
		Status mahi = Status.mahi;
		Status poison = Status.poison;
		if(you.zyotai[suimin.ordinal()] == true){
			inp = 0;
			you.suimin();
		}
		//睡眠は麻痺より優先される
		if(you.zyotai[mahi.ordinal()] == true && you.zyotai[suimin.ordinal()] == false){
			inp = 0;
			you.mahi();
		}

		if(you.zyotai[poison.ordinal()] == true){
			you.poison();
		}
		return inp;
	}

	public int eneStatus(int inp, Original target){
		Status suimin = Status.suimin;
		Status mahi = Status.mahi;
		Status poison = Status.poison;
		if(target.zyotai[suimin.ordinal()] == true){
			inp = 0;
			target.suimin();
		}
		if(target.zyotai[mahi.ordinal()] == true && target.zyotai[suimin.ordinal()] == false){
			inp = 0;
			target.mahi();
		}
		if(target.zyotai[poison.ordinal()] == true){
			target.poison();
		}

		return inp;
	}

	public void youAction(Original you, Original target, int inp, int refCount){
		switch (inp) {
			case 0:
				//麻痺や睡眠状態の時は0が入力される
				System.out.print("");
				break;
			case 1:
				you.act(target);
				break;
			case 2:
				you.charge();
				break;
			case 3:
				you.heal();
				break;
			case 4:
				you.specialAttack(target);
				break;
			case 5:
				if(you.name == "野獣先輩"){
					//ここでyouは野獣先輩であることが確定する
					Yajuu yajuu = (Yajuu)you;
					yajuu.poisonAttack(target);
					break;
				}else if(you.name == "平野店長"){
					HiranoTentyo hiranotentyo = (HiranoTentyo)you;
					hiranotentyo.gachiBinta(target);
				}
				break;
			case 6:
				if(you.name == "平野店長"){
					HiranoTentyo hiranotentyo = (HiranoTentyo)you;
					hiranotentyo.refCount = refCount;
					hiranotentyo.donutsReflection();
				}else{
					System.out.println("分かる？適切なコマンドを突っ込めって言ってんの！！！");
				}
				break;
			default:
				System.out.println("分かる？適切なコマンドを突っ込めって言ってんの！！！");
		}
	}

	public void eneAction(Original you, Original target, int inp, int refCount){
		switch (inp){
			case 0:
				//麻痺や睡眠状態の時は0が入力される
				System.out.print("");
				break;
			case 1:
				target.act(you);
				break;
			case 2:
				target.charge();
				break;
			case 3:
				target.heal();
				break;
			case 4:
				target.specialAttack(you);
				break;
			case 5:
				if (target.name == "野獣先輩"){
					Yajuu yajuu = (Yajuu)target;
					yajuu.poisonAttack(you);
				}else if(target.name == "平野店長"){
					HiranoTentyo hiranotentyo = (HiranoTentyo)target;
					hiranotentyo.gachiBinta(you);
				}
				break;
			case 6:
				if (target.name == "平野店長"){
					HiranoTentyo hiranotentyo = (HiranoTentyo)target;
					target.refCount = refCount;
					hiranotentyo.donutsReflection();
				}
				break;
		}
	}
}
