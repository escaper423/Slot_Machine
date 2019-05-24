package Project;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SlotMachine extends Frame implements ActionListener{
	char Shapes[]={'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	Button StartButton;			//���� ��ư, �����ִ� 15������ ����� ���ڵ�.
	SlotNumber1 Slotman1;		//������ ���� ������ Ŭ����
	SlotNumber2 Slotman2;
	SlotNumber3 Slotman3;
	SlotMachine SlotMaster;
	TextField Slot1;			//������ ����� �ؽ�Ʈ �ʵ� ����
	TextField Slot2;
	TextField Slot3;
	TextField Slot4;
	TextField Slot5;
	TextField Slot6;
	TextField Slot7;
	TextField Slot8;
	TextField Slot9;
	TextField BetAmount;
	TextField MoneyLeft;
	TextField Atext;
	Label Money;			//���̺� ����
	Label Bet;
	Label Announce;
	Checkbox Bet1;			//üũ�ڽ� ����
	Checkbox Bet2;
	Checkbox Bet3;
	int Moneyvalue;			//String���� int������ ���鶧 ����� int�� ����
	int Betvalue;			
	Random r=new Random();	//��������, �������� ����� ����.
	int rn;
	boolean Slot1Ended=false;	//����1�� �� ���Ҵ°��� üũ.
	boolean Slot2Ended=false;	//����2��...
	boolean Slot3Ended=false;	//����3��...
	boolean TripleSeven; //��� : 300000
	boolean TripleThree; //��� : 100000
	boolean TripleOther; //��� : 50000
	boolean TwoThree; //��� : 8000
	boolean OneThree; //��� : 4000
	boolean OneFirst; //��� : 1000
	boolean BeingRolling=false;


	SlotMachine(String name){
		super(name);
		setBackground(Color.darkGray);
		setResizable(false);
		setLayout(null);
		setSize(340,250);
		setVisible(true);
		StartButton=new Button("����");
		Slotman1=new SlotNumber1();
		Slotman2=new SlotNumber2();
		Slotman3=new SlotNumber3();
		Slot1=new TextField("N");
		Slot2=new TextField("N");
		Slot3=new TextField("N");
		Slot4=new TextField("N");
		Slot5=new TextField("N");
		Slot6=new TextField("N");
		Slot7=new TextField("N");
		Slot8=new TextField("N");
		Slot9=new TextField("N");
		Bet1=new Checkbox();
		Bet2=new Checkbox();
		Bet3=new Checkbox();
		Money=new Label("���� ��");
		Bet=new Label("���� �׼�");
		Announce=new Label ("�˸��� : ");
		Atext=new TextField("���� ��ư�� ������ �۵��մϴ�.");
		MoneyLeft=new TextField(60);
		BetAmount=new TextField(60);
		Closingman cm=new Closingman();
		ActionTrigger at=new ActionTrigger();

		Bet1.addMouseListener(at);
		Bet2.addMouseListener(at);
		Bet3.addMouseListener(at);
		StartButton.addActionListener(this);
		Money.setForeground(Color.white);
		Bet.setForeground(Color.white);
		Atext.setBounds(70,200,240,20);
		Announce.setBounds(10,200,45,20);
		Announce.setForeground(Color.white);
		Money.setBounds(220,50,60,30);
		MoneyLeft.setBounds(220,80,60,20);
		Bet.setBounds(220,110,60,30);
		BetAmount.setBounds(220,140,60,20);
		Slot1.setBounds(100,50,20,20);
		Slot2.setBounds(130,50,20,20);
		Slot3.setBounds(160,50,20,20);
		Slot4.setBounds(98,78,25,25);
		Slot5.setBounds(128,78,25,25);
		Slot6.setBounds(158,78,25,25);
		Slot7.setBounds(100,110,20,20);
		Slot8.setBounds(130,110,20,20);
		Slot9.setBounds(160,110,20,20);
		Bet1.setBounds(105,140,15,15);
		Bet2.setBounds(135,140,15,15);
		Bet3.setBounds(165,140,15,15);
		StartButton.setBounds(125,170,40,20);

		Slot1.setEditable(false);
		Slot2.setEditable(false);
		Slot3.setEditable(false);
		Slot4.setEditable(false);
		Slot5.setEditable(false);
		Slot6.setEditable(false);
		Slot7.setEditable(false);
		Slot8.setEditable(false);
		Slot9.setEditable(false);
		BetAmount.setEditable(false);
		MoneyLeft.setEditable(false);
		Atext.setEditable(false);

		add(Money);
		add(Bet);
		add(Slot1);
		add(Slot2);
		add(Slot3);
		add(Slot4);
		add(Slot5);
		add(Slot6);
		add(Slot7);
		add(Slot8);
		add(Slot9);
		add(StartButton);
		add(MoneyLeft);
		add(BetAmount);
		add(Bet1);
		add(Bet2);
		add(Bet3);
		add(Announce);
		add(Atext);

		addWindowListener(cm);
		MoneyLeft.setText("50000");
		BetAmount.setText("0");

	}
	public void actionPerformed(ActionEvent e){
		Moneyvalue=Integer.parseInt(MoneyLeft.getText());
		Betvalue=Integer.parseInt(BetAmount.getText());
		if(Moneyvalue>=Betvalue && Moneyvalue!=0 && BeingRolling==false){
			BeingRolling=true;
			SlotNumber1 Slotman1=new SlotNumber1();
			SlotNumber2 Slotman2=new SlotNumber2();
			SlotNumber3 Slotman3=new SlotNumber3();
			Slotman1.start();
			Slotman2.start();
			Slotman3.start();
			StartButton.setEnabled(false);
			Bet1.setEnabled(false);
			Bet2.setEnabled(false);
			Bet3.setEnabled(false);
			Atext.setText("������ ���۵Ǿ����ϴ�.");
			Moneyvalue-=Betvalue;
			String tempm;
			tempm=Integer.toString(Moneyvalue);
			MoneyLeft.setText(tempm);
		}
		else
			Atext.setText("���� ���ڶ��ϴ�.");
	}

	public static void main(String[] args){
		SlotMachine SlotMaster=new SlotMachine("�̰��� ���Ըӽ��̴�.");
	}

	public class ActionTrigger extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e){
			int BetCount=0;
			int Bet1v=0;
			int Bet2v=0;
			int Bet3v=0;
			if(Bet1.getState()==true)
				Bet1v=1;
			else
				Bet1v=0;
			if(Bet2.getState()==true)
				Bet2v=1;
			else
				Bet2v=0;
			if(Bet3.getState()==true)
				Bet3v=1;
			else
				Bet3v=0;

			BetCount=Bet1v+Bet2v+Bet3v;
			int BetValue=1000*BetCount;
			String BetValueText=Integer.toString(BetValue);
			BetAmount.setText(BetValueText);
		}

	}

	public class SlotNumber1 extends Thread{
		public void run(){
			int i=0;
			if(BeingRolling==true){
				try{
					for(i=0;i<(200+rn);i++){
						String Num1=Character.toString(Shapes[(i)%15]);
						String Num4=Character.toString(Shapes[(i+1)%15]);
						String Num7=Character.toString(Shapes[(i+2)%15]);

						sleep(5);
						Slot1.setText(Num1);
						Slot4.setText(Num4);
						Slot7.setText(Num7);
					}
				}
				catch(InterruptedException e)
				{
					System.exit(1);
				}
				haltd();
			}
		}
		public void haltd(){
			int i=0;
			int w=0;
			rn=r.nextInt(15);
			try{
				for(;i<(10+rn);i++){
					String Num1=Character.toString(Shapes[(i)%15]);
					String Num4=Character.toString(Shapes[(i+1)%15]);
					String Num7=Character.toString(Shapes[(i+2)%15]);
					sleep(w);
					Slot1.setText(Num1);
					Slot4.setText(Num4);
					Slot7.setText(Num7);
					w+=10;

				}
			}
			catch(InterruptedException e)
			{
				System.exit(1);
			}
			Slot1Ended=true;
			Slotman2.haltd();
		}

	}

	public class SlotNumber2 extends Thread{
		public void run(){
			int i=0;
			if(BeingRolling==true){
				try{
					while(Slot1Ended==false){
						String Num2=Character.toString(Shapes[(i)%15]);
						String Num5=Character.toString(Shapes[(i+1)%15]);
						String Num8=Character.toString(Shapes[(i+2)%15]);
						sleep(5);
						Slot2.setText(Num2);
						Slot5.setText(Num5);
						Slot8.setText(Num8);
						i++;
					}
				}
				catch(InterruptedException e)
				{
					System.exit(1);
				}
			}
		}
		public void haltd(){
			int i=0;
			int w=0;
			rn=r.nextInt(15);
			try{
				for(i=0;i<(10+rn); i++){
					String Num2=Character.toString(Shapes[(i)%15]);
					String Num5=Character.toString(Shapes[(i+1)%15]);
					String Num8=Character.toString(Shapes[(i+2)%15]);
					sleep(w);
					Slot2.setText(Num2);
					Slot5.setText(Num5);
					Slot8.setText(Num8);
					w+=10;
				}
			}
			catch(InterruptedException e)
			{
				System.exit(1);
			}
			Slot2Ended=true;
			Slotman3.haltd();
		}

	}
	public class SlotNumber3 extends Thread{
		public void run(){
			if(BeingRolling==true){
				int i=0;
				try{
					while(Slot2Ended==false){
						String Num3=Character.toString(Shapes[(i)%15]);
						String Num6=Character.toString(Shapes[(i+1)%15]);
						String Num9=Character.toString(Shapes[(i+2)%15]);
						sleep(5);
						Slot3.setText(Num3);
						Slot6.setText(Num6);
						Slot9.setText(Num9);
						i++;
					}
				}
				catch(InterruptedException e)
				{
					System.exit(1);
				}
			}
		}
		public void haltd(){
			int i=0;
			int w=0;
			rn=r.nextInt(15);
			try{
				for(i=0;i<(10+rn);i++){
					String Num3=Character.toString(Shapes[(i)%15]);
					String Num6=Character.toString(Shapes[(i+1)%15]);
					String Num9=Character.toString(Shapes[(i+2)%15]);
					sleep(w);
					Slot3.setText(Num3);
					Slot6.setText(Num6);
					Slot9.setText(Num9);
					w+=10;
				}
			}
			catch(InterruptedException e)
			{
				System.exit(1);
			}
			Slot3Ended=true;
			StartButton.setEnabled(true);
			Bet1.setEnabled(true);
			Bet2.setEnabled(true);
			Bet3.setEnabled(true);
			finalResume();
		}

	}

	public void finalResume(){
		if(Slot1Ended==true && Slot2Ended==true && Slot3Ended==true ){
			String One;
			String Two;
			String Three;
			One=Slot4.getText();
			Two=Slot5.getText();
			Three=Slot6.getText();
			if(One.equals(Two)==true && One.equals(Three)==true && One.equals("7")==true){
				TripleSeven=true;
				rewards();
			}
			else if(One.equals(Two)==true && One.equals(Three)==true && One.equals("3")==true){
				TripleThree=true;
				rewards();
			}
			else if(One.equals(Two)==true && One.equals(Three)==true && One.equals("3")==false && One.equals("7")==false){
				TripleOther=true;
				rewards();
			}
			else if(Two.equals(Three)==true && TripleSeven==false && TripleThree==false && TripleOther==false){
				TwoThree=true;
				rewards();
			}
			else if(One.equals(Three)==true && Two.equals(Three)==false && TripleSeven==false && TripleThree==false && TripleOther==false){
				OneThree=true;
				rewards();
			}
			else if(One.equals("1")==true && TripleSeven==false && TripleThree==false && TripleOther==false && TwoThree==false && OneThree==false){
				OneFirst=true;
				rewards();
			}
			else
				rewards();
		}
	}
	public void rewards()
	{
		if(TripleSeven==true && Bet1.getState()==true && Bet2.getState()==true && Bet3.getState()==true){
			Atext.setText("777�� ��÷. ��� 30����");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=300000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleSeven=false;
		}
		else if(TripleThree==true && Bet1.getState()==true && Bet2.getState()==true && Bet3.getState()==true){
			Atext.setText("333�� ��÷. ��� 10����");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=100000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleThree=false;
		}
		else if(TripleOther==true && Bet1.getState()==true && Bet2.getState()==true && Bet3.getState()==true){
			Atext.setText("��Ÿ ���� ���� 3��. ��� 5����");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=50000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleOther=false;
		}
		else if(TwoThree==true && Bet2.getState()==true && Bet3.getState()==true){
			Atext.setText("��� 8õ��(�ι�°�� ����° ����)");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=8000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TwoThree=false;
		}
		else if(OneThree==true && Bet1.getState()==true && Bet3.getState()==true){
			Atext.setText("��� 4õ��(ù��°�� ����° ����)");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=4000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			OneThree=false;
		}
		else if(OneFirst==true && Bet1.getState()==true){
			Atext.setText("��� õ��(ù��° ������ 1)");
			int Moneyvalue=Integer.parseInt(MoneyLeft.getText());
			Moneyvalue+=1000;
			String MoneyvalueText=Integer.toString(Moneyvalue);
			MoneyLeft.setText(MoneyvalueText);
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			OneFirst=false;
		}
		else if(TripleSeven==true && (Bet1.getState()==false || Bet2.getState()==false || Bet3.getState()==false)){
			Atext.setText("777�� ��÷�̳� ��ݾ��� (����)");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleSeven=false;
		}
		else if(TripleThree==true && (Bet1.getState()==false || Bet2.getState()==false || Bet3.getState()==false)){
			Atext.setText("333�� ��÷�̳� ��ݾ��� (����).");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleThree=false;
		}
		else if(TripleOther==true && (Bet1.getState()==false || Bet2.getState()==false || Bet3.getState()==false)){
			Atext.setText("��Ÿ ���� ���� 3���̳� ��ݾ��� (����)");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TripleOther=false;
		}
		else if(TwoThree==true && (Bet2.getState()==false || Bet3.getState()==false)){
			Atext.setText("�� ��°�� �� ��°�� ������ ��� ����(����)");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			TwoThree=false;
		}
		else if(OneThree==true && (Bet1.getState()==false || Bet3.getState()==false)){
			Atext.setText("ù ��°�� �� ��°�� ������ ��ݾ���(����)");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			OneThree=false;
		}
		else if(OneFirst==true && Bet1.getState()==false){
			Atext.setText("ù ��° ������ 1�̳� ��ݾ��� (����)");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
			OneFirst=false;
		}
		else{
			Atext.setText("���Դϴ�. �ٽ� �����ϼ���.");
			Slot1Ended=false;
			Slot2Ended=false;
			Slot3Ended=false;
			BeingRolling=false;
		}
	}
}


